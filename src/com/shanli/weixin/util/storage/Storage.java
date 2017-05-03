package com.shanli.weixin.util.storage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

/**
 * 键值数据存储器接口。
 * 文件实现类FileStorage能够支持同一OS下不同JVM应用的数据同步，数据库实现类DbStorage能够支持跨OS的多应用的数据同步。
 * 
 * @author alex
 *
 */
public abstract class Storage {

	/**
	 * 获得所有主键
	 * 
	 * @param <T>
	 * @return
	 */
	public abstract Set<String> keys();

	/**
	 * 保存键值到存储中。如果已经存在在覆盖。
	 * 
	 * @param key
	 * @param value
	 *            如果值为null则相关于调用remove
	 * @throws Exception
	 */
	public abstract void save(String key, Object value);

	/**
	 * 移除键值
	 * 
	 * @param key
	 * @throws Exception
	 */
	public abstract void remove(String key);

	/**
	 * 使用主键获得对应类型的值。
	 * 
	 * @param key
	 * @param type
	 * @return 如果不存在则返回null
	 */
	public abstract <T> T get(String key, Class<T> type);

	/**
	 * 对象序列化转换为byte数组
	 * 
	 * @param obj
	 * @return
	 * @throws IOException
	 */
	byte[] object2bytes(Object obj) throws IOException {
		if (obj == null) {
			return null;
		}
		// 值对象转换为byte[]
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		oos.close();
		byte[] bytes = baos.toByteArray();
		baos.close();
		return bytes;
	}

	/**
	 * 将byte数组反序列化为对象
	 * 
	 * @param bytes
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	Object bytes2object(byte[] bytes) throws IOException, ClassNotFoundException {
		if (bytes == null || bytes.length < 1) {
			return null;
		}
		ByteArrayInputStream bains = new ByteArrayInputStream(bytes);
		ObjectInputStream oins = new ObjectInputStream(bains);
		Object obj = oins.readObject();
		oins.close();
		bains.close();
		return obj;
	}

}
