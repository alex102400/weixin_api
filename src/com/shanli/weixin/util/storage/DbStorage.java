package com.shanli.weixin.util.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 数据库键值存储实现类。能够支持跨OS跨JVM的多应用的数据同步能力。
 * 数据库连接通过DriverManager.getConnection(alias)获得，因此可以使用proxool.projectAlias利用Proxool或者直接使用jdbc_url;
 * 表名默认tbl_weixin_api_runtime，字段名默认fld_key(String,PK)/fld_value(byte[])。
 * 
 * @author alex
 *
 */
public class DbStorage extends Storage {
	private static final Log log = LogFactory.getLog(DbStorage.class);

	private String dbAlias;
	private String table = "tbl_weixin_api_runtime";
	private String fieldKey = "fld_key";
	private String fieldValue = "fld_value";

	/**
	 * 指定数据库连接的jdbc url。对于proxool连接池可以设置为proxool.projectAlias。
	 * 
	 * @param jdbcUrl
	 *            如果有用户名和密码需要写在jdbcUrl中
	 */
	public DbStorage(String jdbcUrl) {
		this.dbAlias = jdbcUrl;
	}

	/**
	 * 设置表名和字段名。
	 * 
	 * @param table
	 *            表名。默认tbl_weixin_api_runtime
	 * @param fieldKey
	 *            主键字段名。必须为主键。默认fld_key
	 * @param fieldValue
	 *            值字段名。必须为BLOB类型。默认fld_value
	 */
	public void setTableAndFieldName(String table, String fieldKey, String fieldValue) {
		this.table = table;
		this.fieldKey = fieldKey;
		this.fieldValue = fieldValue;
	}

	@Override
	public Set<String> keys() {
		ArrayList<String> keys = new ArrayList<String>();
		try {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(dbAlias);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(String.format("SELECT %s FROM %s", fieldKey, fieldValue, table));

				while (rs.next()) {
					keys.add(rs.getString(1));
				}
				rs.close();
				st.close();
			} finally {
				if (conn != null) {
					conn.close();
				}
			}
		} catch (Exception e) {
			log.error("获取主键清单失败", e);
		}
		return new HashSet<String>(keys);
	}

	@Override
	public void save(String key, Object value) {
		if (value == null) {
			remove(key);
		}
		try {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(dbAlias);
				// 先更新
				PreparedStatement pst = conn
						.prepareStatement(String.format("UPDATE %s SET %s=? WHERE %s=? ", table, fieldValue, fieldKey));
				byte[] bytes = object2bytes(value);
				pst.setBytes(1, bytes);
				pst.setString(2, key);
				int rows = pst.executeUpdate();
				pst.close();

				// 再尝试插入
				if (rows < 1) {
					try {
						pst = conn.prepareStatement(
								String.format("INSERT INTO %s (%s,%s) VALUES (?,?)", table, fieldKey, fieldValue));
						pst.setString(1, key);
						pst.setBytes(2, bytes);
						pst.executeUpdate();
						pst.close();
					} catch (Exception e) {
					}
				}
			} finally {
				if (conn != null) {
					conn.close();
				}
			}
		} catch (Exception e) {
			log.error(String.format("键值保存失败 %s %s", key, value), e);
		}
	}

	@Override
	public <T> T get(String key, Class<T> type) {
		T value = null;
		try {
			byte[] bytes = null;
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(dbAlias);
				PreparedStatement pst = conn
						.prepareStatement(String.format("SELECT %s FROM %s WHERE %s=?", fieldValue, table, fieldKey));
				pst.setString(1, key);
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					bytes = rs.getBytes(1);
				}
				rs.close();
				pst.close();
			} finally {
				if (conn != null) {
					conn.close();
				}
			}
			Object obj = bytes2object(bytes);
			if (obj != null) {
				value = type.cast(obj);
			}
		} catch (Exception e) {
			log.error(String.format("键值获取失败 %s", key), e);
		}
		return value;
	}

	@Override
	public void remove(String key) {
		try {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(dbAlias);
				PreparedStatement pst = conn
						.prepareStatement(String.format("DELETE FROM %s WHERE %s=? ", table, fieldKey));
				pst.setString(1, key);
				pst.executeUpdate();
				pst.close();

			} finally {
				if (conn != null) {
					conn.close();
				}
			}
		} catch (Exception e) {
			log.error(String.format("键值删除失败 %s", key), e);
		}
	}

}
