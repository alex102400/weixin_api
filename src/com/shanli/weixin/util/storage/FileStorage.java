package com.shanli.weixin.util.storage;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 文件存储实现类。能够支持同一OS下不同JVM应用的数据同步。
 * 
 * 在指定文件夹下为每个key创建一个文件，文件名为md5(key)，移除key时删除文件。
 * 使用RadmonAccessFile的rws模式进行并发数据存取，数据文件内容为：主键(UTF)值字节数(int)值字节数组(byte[])。
 * 
 * @author alex
 *
 */
public class FileStorage extends Storage {
	private static final Log log = LogFactory.getLog(FileStorage.class);
	private String folder;// 文件夹路径

	/**
	 * 创建文件存储。
	 * 
	 * @param folder
	 *            文件夹，如果不存在则自动创建。如果需要多应用共享则建议使用绝对路径。
	 */
	public FileStorage(File folder) {
		this.folder = folder.getAbsolutePath();
	}

	/**
	 * 遍历文件夹下所有文件，读取key。
	 */
	@Override
	public Set<String> keys() {
		File[] files = new File(folder).listFiles();
		if (files == null || files.length < 1) {
			return null;
		}
		HashSet<String> keys = new HashSet<String>(files.length);
		for (File f : files) {
			try {
				RandomAccessFile file = new RandomAccessFile(f, "r");
				try {
					String key = file.readUTF();
					keys.add(key);
				} finally {
					if (file != null) {
						file.close();
					}
				}
			} catch (Exception e) {
				log.warn(String.format("读取主键失败,忽略文件 %s", f.getAbsolutePath()), e);
			}
		}
		return keys;
	}

	@Override
	public void save(String key, Object value) {
		if (key == null) {
			return;
		}
		// 值为空则删除
		if (value == null) {
			remove(key);
			return;
		}

		try {
			byte[] bytes = object2bytes(value);
			if (bytes == null) {
				return;
			}

			// 写文件
			File dataFile = key2file(key);
			dataFile.getParentFile().mkdirs();// 创建目录
			RandomAccessFile file = new RandomAccessFile(dataFile, "rws");
			file.seek(0);
			file.writeUTF(key);// 写主键
			file.writeInt(bytes.length);// 写值长度
			file.write(bytes);// 写值字节数组
			file.close();

		} catch (Exception e) {
			log.error(String.format("键值保存失败 %s %s", key, value), e);
		}
	}

	@Override
	public void remove(String key) {
		if (key == null) {
			return;
		}
		// 文件不存在则忽略
		File dataFile = key2file(key);
		if (!dataFile.exists()) {
			return;
		}
		try {
			// 删除文件
			FileUtils.forceDelete(dataFile);
		} catch (Exception e) {
			log.error(String.format("键值删除失败 %s", key), e);
		}
	}

	@Override
	public <T> T get(String key, Class<T> type) {

		File dataFile = key2file(key);
		if (!dataFile.exists()) {
			return null;
		}

		T value = null;

		try {
			// 读取文件
			RandomAccessFile file = new RandomAccessFile(dataFile, "r");
			file.readUTF();// 读取key
			int length = file.readInt();// 读取值长度
			byte[] bytes = new byte[length];// 读取值
			file.read(bytes);
			file.close();

			// 将byte[]转换为对象
			Object obj = bytes2object(bytes);
			if (obj != null) {
				value = type.cast(obj);
			}
		} catch (Exception e) {
			log.error(String.format("键值获取失败 %s", key), e);
		}

		return value;
	}

	/**
	 * 返回key对应的数据文件。
	 * 
	 * @param key
	 * @return
	 */
	private File key2file(String key) {
		String filename = DigestUtils.md5Hex(key);
		return new File(folder, filename);
	}

}
