package com.shanli.weixin.api.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import com.shanli.weixin.util.storage.FileStorage;

@FixMethodOrder(org.junit.runners.MethodSorters.NAME_ASCENDING)
public class TestFileStorage {
	static File folder;
	static FileStorage fs;
	static HashMap<String, Object> datas;
	static String longKey;
	static String nullKey = "key_null_value";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		datas = new HashMap<String, Object>();
		datas.put("k1", "v1");
		datas.put(nullKey, null);
		datas.put("k3", new Date());
		longKey = StringUtils.repeat("keys", 1024);
		datas.put(longKey, StringUtils.repeat("valuevalue", 10240));

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// 删除测试产生的目录
		FileUtils.deleteDirectory(folder);
	}

	@Test
	public void test00FileStorage() {
		folder = new File("/tmp_test");
		fs = new FileStorage(folder);
	}

	/**
	 * 保存所有值 。检查k1/nullKey/longKey值
	 */
	@Test
	public void test01Save() {
		for (Entry<String, Object> data : datas.entrySet()) {
			fs.save(data.getKey(), data.getValue());
		}

		String key = "k1";
		assertEquals(fs.get(key, datas.get(key).getClass()), datas.get(key));

		assertNull(datas.get(nullKey));

		assertEquals(fs.get(longKey, datas.get(longKey).getClass()), datas.get(longKey));
	}

	/**
	 * 获取k3
	 */
	@Test
	public void test02Get() {
		String key = "k3";
		Object date = fs.get(key, datas.get(key).getClass());
		assertTrue(date instanceof Date);
		assertNotNull(date);
	}

	/**
	 * 删除k1
	 */
	@Test
	public void test03Remove() {
		String key = "k1";
		fs.remove(key);
		assertNull(fs.get(key, datas.get(key).getClass()));
	}

	/**
	 * 检查应当存在k3/longKey不存在k1/nullKey
	 */
	@Test
	public void test04Keys() {
		Set<String> keys = fs.keys();
		assertEquals(keys.size(), 2);
		assertFalse(keys.contains("k1"));
		assertFalse(keys.contains(nullKey));
		assertTrue(keys.contains("k3"));
		assertTrue(keys.contains(longKey));
	}

}
