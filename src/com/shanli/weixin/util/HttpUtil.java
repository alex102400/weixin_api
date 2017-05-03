package com.shanli.weixin.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

/**
 * HTTP请求工具类
 * 
 * @author alex
 *
 */
public class HttpUtil {
	private static final Log log = LogFactory.getLog(HttpUtil.class);
	/**
	 * 设置HTTP请求和传输超时时间
	 */
	public static RequestConfig config = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000)
			.build();

	/**
	 * GET请求
	 * 
	 * @param url
	 * @param path
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws URISyntaxException
	 */
	public static String get(String url, String path) throws ParseException, IOException, URISyntaxException {
		return get(url, path, null);
	}

	/**
	 * GET请求。支持下载文件。
	 * 
	 * @param url
	 * @param path
	 * @param target
	 * @return 如果响应结果不是文件则返回文本
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String get(String url, String path, File target)
			throws URISyntaxException, ClientProtocolException, IOException {
		String respText = null;
		CloseableHttpClient http = HttpClients.createDefault();
		try {

			URI uri = new URIBuilder(url + path).build();
			if (log.isDebugEnabled()) {
				log.debug(String.format(">> GET %s", uri));
			}

			HttpGet get = new HttpGet(uri);
			get.setConfig(config);

			CloseableHttpResponse response = null;
			try {
				response = http.execute(get);
				respText = parserResponse(response, target);

			} finally {
				if (response != null) {
					response.close();
				}
			}

		} finally {
			if (http != null) {
				http.close();
			}
		}
		return respText;
	}

	/**
	 * POST提交json
	 * 
	 * @param url
	 *            基本URL，后面会组合path
	 * @param path
	 *            路径，组合在url后。
	 * @param json
	 *            JSON对象
	 * 
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String post(String url, String path, Object json)
			throws ClientProtocolException, URISyntaxException, IOException {
		return post(url, path, json, null);
	}

	/**
	 * POST提交json。支持下载文件。
	 * 
	 * @param url
	 * @param path
	 * @param json
	 * @param target
	 * @return
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String post(String url, String path, Object json, File target)
			throws URISyntaxException, ClientProtocolException, IOException {
		String respText = null;
		CloseableHttpClient http = HttpClients.createDefault();
		try {

			URI uri = new URIBuilder(url + path).build();
			if (log.isDebugEnabled()) {
				log.debug(String.format(">> POST %s", uri));
			}

			HttpPost post = new HttpPost(uri);
			post.setConfig(config);
			if (json != null) {
				post.setHeader("Content-Type", "application/json; encoding=utf-8");
				String data = new Gson().toJson(json);
				if (log.isDebugEnabled()) {
					log.debug(String.format(">> %s", json));
				}
				post.setEntity(EntityBuilder.create().setContentEncoding("utf8").setText(data).build());
			}

			CloseableHttpResponse response = null;
			try {
				response = http.execute(post);
				respText = parserResponse(response, target);
			} finally {
				if (response != null) {
					response.close();
				}
			}

		} finally {
			if (http != null) {
				http.close();
			}
		}
		return respText;
	}

	/**
	 * HTTP上传文件
	 * 
	 * @param url
	 * @param path
	 * @param fileFieldName
	 *            文件在表单中的字段名
	 * @param file
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String upload(String url, String path, String fileFieldName, File file)
			throws URISyntaxException, ClientProtocolException, IOException {
		return upload(url, path, fileFieldName, file, null);
	}

	/**
	 * 上传文件附带表单
	 * 
	 * @param url
	 * @param path
	 * @param fileFieldName
	 * @param file
	 * @param attachFormFields
	 *            其它的表单项
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String upload(String url, String path, String fileFieldName, File file,
			TreeMap<String, String> attachFormFields) throws URISyntaxException, ClientProtocolException, IOException {
		if (file == null || !file.exists()) {
			throw new IllegalArgumentException(
					String.format("文件[%s]不存在!", file != null ? file.getAbsolutePath() : file));
		}
		String respText = null;
		CloseableHttpClient http = HttpClients.createDefault();
		try {

			URI uri = new URIBuilder(url + path).build();
			if (log.isDebugEnabled()) {
				log.debug(String.format(">> UPLOAD %s", uri));
			}

			HttpPost post = new HttpPost(uri);
			post.setConfig(config);
			MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
			if (attachFormFields != null) {
				for (Entry<String, String> fields : attachFormFields.entrySet()) {
					entityBuilder.addTextBody(fields.getKey(), fields.getValue());
				}
			}

			HttpEntity entity = entityBuilder.addPart(fileFieldName, new FileBody(file)).build();
			post.setEntity(entity);

			CloseableHttpResponse response = null;
			try {
				response = http.execute(post);
				respText = parserResponse(response, null);
			} finally {
				if (response != null) {
					response.close();
				}
			}

		} finally {
			if (http != null) {
				http.close();
			}
		}
		return respText;
	}

	/**
	 * 解析HTTP响应。
	 * 
	 * @param response
	 * @param target
	 *            将文件类型的响应内容保存到文件。不指定此参数则返回文本内容。
	 * @return 如果响应内容为文件则返回{"filename":FILENAME}，否则为原始文本内容。
	 * @throws IOException
	 * @throws ParseException
	 */
	private static String parserResponse(CloseableHttpResponse response, File target)
			throws ParseException, IOException {
		String respText = null;
		StatusLine status = response.getStatusLine();
		if (log.isDebugEnabled()) {
			log.debug(String.format("<< %s", status));
		}
		HttpEntity resp = response.getEntity();

		if (resp != null) {

			// 返回的是文本内容
			if (target == null || isResponseText(response, resp.getContentType())) {
				respText = EntityUtils.toString(new BufferedHttpEntity(resp), "utf8");
				if (log.isDebugEnabled()) {
					log.debug(String.format("<< %s", respText));
				}
			} else {// 返回的是文件
				String filename = getResponseFileName(response.getAllHeaders());
				respText = String.format("{\"filename\":\"%s\"}", StringEscapeUtils.escapeJava(filename));
				if (log.isDebugEnabled()) {
					log.debug(String.format("<< FILE [%s]", filename));
				}
				if (target != null) {
					if (log.isDebugEnabled()) {
						log.debug(String.format("<< SAVE [%s]", target.getAbsolutePath()));
					}
					FileOutputStream fouts = null;
					try {
						fouts = new FileOutputStream(target);
						resp.writeTo(fouts);
					} finally {
						if (fouts != null) {
							fouts.close();
						}
					}
				}

			}

		}
		if (StringUtils.isBlank(respText)) {
			throw new NullPointerException("HTTP响应内容为空");
		}
		return respText;
	}

	/**
	 * 检查响应结果是否为文本内容
	 * 
	 * @param response
	 * @return
	 */
	private static boolean isResponseText(CloseableHttpResponse response, Header responseEntityContentType) {
		String contentType = responseEntityContentType.getValue();
		if (StringUtils.containsIgnoreCase(contentType, "text")
				|| StringUtils.containsIgnoreCase(contentType, "json")) {
			return true;
		}
		return false;
	}

	/**
	 * 从响应消息的Content-Disposition头中获得文件名。
	 * 
	 * @param headers
	 * @return 如果不是文件则返回null
	 */
	private static String getResponseFileName(Header[] headers) {
		String filename = null;
		if (headers == null) {
			return null;
		}
		for (Header header : headers) {
			if (StringUtils.equalsIgnoreCase(header.getName(), "Content-Disposition")) {
				String value = header.getValue();
				String key = "filename=";
				int keyLength = key.length();
				int position = StringUtils.indexOfIgnoreCase(header.getValue(), key);
				if (position > -1) {
					filename = StringUtils.substring(value, position + keyLength);
				}
				break;
			}
		}
		return filename;
	}

}
