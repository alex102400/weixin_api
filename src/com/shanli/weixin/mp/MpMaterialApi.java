package com.shanli.weixin.mp;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.TreeMap;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.shanli.weixin.bean.AccessTokenFailException;
import com.shanli.weixin.bean.BaseResp;
import com.shanli.weixin.mp.bean.MediaTypeEnum;
import com.shanli.weixin.mp.bean.MpAccessToken;
import com.shanli.weixin.mp.req.Article;
import com.shanli.weixin.mp.resp.material.BatchGetMaterialResp;
import com.shanli.weixin.mp.resp.material.GetMaterialCountResp;
import com.shanli.weixin.mp.resp.material.MaterialGetResp;
import com.shanli.weixin.mp.resp.material.MediaUploadImgResp;
import com.shanli.weixin.mp.resp.material.MediaUploadResp;
import com.shanli.weixin.mp.resp.material.MeidaGetResp;
import com.shanli.weixin.util.HttpUtil;

/**
 * 素材管理API
 * @author alex
 *
 */
public class MpMaterialApi {
	private MpApi mpApi;

	public MpMaterialApi(MpApi mpApi) {
		this.mpApi = mpApi;
	}

	/**
	 * 上传图文消息内的图片，获取URL。 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。
	 * 
	 * @param imagePngAndJpg_1MB
	 *            图片仅支持jpg/png格式，大小必须在1MB以下。
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws AccessTokenFailException
	 */
	public MediaUploadImgResp apiMediaUploadImg(File imagePngAndJpg_1MB)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/media/uploadimg?access_token=%s", token.getAccessToken());
	
		String respText = HttpUtil.upload(mpApi.config.getApiHttps(), path, "media", imagePngAndJpg_1MB);
		MediaUploadImgResp resp = new Gson().fromJson(respText, MediaUploadImgResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMediaUploadimg %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 上传图文消息素材
	 * 
	 * @param articles
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public MediaUploadResp apiMediaUploadNews(Article[] articles)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/media/uploadnews?access_token=%s", token.getAccessToken());
	
		TreeMap<String, Article[]> reqMap = new TreeMap<String, Article[]>();
		reqMap.put("articles", articles);
	
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		MediaUploadResp resp = new Gson().fromJson(respText, MediaUploadResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMediaUploadNews %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 视频素材上传为群发素材
	 * 
	 * @param mediaId
	 * @param title
	 * @param description
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public MediaUploadResp apiMediaUploadVideo(String mediaId, String title, String description)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/media/uploadvideo?access_token=%s", token.getAccessToken());
	
		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("media_id", mediaId);
		reqMap.put("title", title);
		reqMap.put("description", description);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		MediaUploadResp resp = new Gson().fromJson(respText, MediaUploadResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMediaUploadVideo %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 上传临时素材。 1、临时素材media_id是可复用的。 2、媒体文件在微信后台保存时间为3天，即3天后media_id失效。
	 * 3、上传临时素材的格式、大小限制与公众平台官网一致。 图片（image）: 2M，支持PNG\JPEG\JPG\GIF格式
	 * 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式 视频（video）：10MB，支持MP4格式
	 * 缩略图（thumb）：64KB，支持JPG格式
	 * 
	 * @param type
	 * @param file
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public MediaUploadResp apiMediaUpload(MediaTypeEnum type, File file)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/media/upload?access_token=%s&type=%s", token, type);
		String respText = HttpUtil.upload(mpApi.config.getApiHttps(), path, "media", file);
		MediaUploadResp resp = new Gson().fromJson(respText, MediaUploadResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMediaUploadimg %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获取图片、语音、缩略图临时素材。
	 * 
	 * @param mediaId
	 * @param target
	 *            视频素材指定target无意义。
	 * @return 如果响应为null或者失败，则表示文件下载失败。视频素材响应json其中有url。
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws AccessTokenFailException
	 */
	public MeidaGetResp apiMediaGet(String mediaId, File target)
			throws ParseException, IOException, URISyntaxException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/media/get?access_token=%s&media_id=%s", token, mediaId);
		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path, target);
	
		MeidaGetResp resp = new Gson().fromJson(respText, MeidaGetResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMediaGet %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 新增永久图文素材
	 * 
	 * @param articles
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public MediaUploadResp apiMaterialAddNews(Article[] articles)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/material/add_news?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("articles", articles);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		MediaUploadResp resp = new Gson().fromJson(respText, MediaUploadResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMaterialAddNews %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 新增永久素材
	 * 
	 * @param type
	 * @param file
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public MediaUploadResp apiMaterialAddMaterial(MediaTypeEnum type, File file)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/material/add_material?access_token=%s&type=%s", token, type);
		String respText = HttpUtil.upload(mpApi.config.getApiHttps(), path, "media", file);
		MediaUploadResp resp = new Gson().fromJson(respText, MediaUploadResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMaterialAddMaterial %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 新增永久视频素材
	 * 
	 * @param file
	 *            视频文件
	 * @param title
	 *            视频标题
	 * @param introduction
	 *            视频描述
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public MediaUploadResp apiMaterialAddVideoMaterial(File file, String title, String introduction)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/material/add_material?access_token=%s&type=video", token.getAccessToken());
	
		TreeMap<String, String> json = new TreeMap<String, String>();
		json.put("title", title);
		json.put("introduction", introduction);
	
		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("introduction", new Gson().toJson(json));
	
		String respText = HttpUtil.upload(mpApi.config.getApiHttps(), path, "media", file, reqMap);
		MediaUploadResp resp = new Gson().fromJson(respText, MediaUploadResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMaterialAddVideoMaterial %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获取永久素材的URL。
	 * 
	 * @param mediaId
	 * @return 普通素材直接在浏览器中打开返回的url或者下载URL即可,对于图文素材和视频素材返回的是json。
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws AccessTokenFailException
	 */
	public MaterialGetResp apiMaterialGetMaterial(String mediaId, File target)
			throws ParseException, IOException, URISyntaxException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("material/get_material?access_token=%s", token.getAccessToken());
		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("media_id", mediaId);
	
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap, target);
		MaterialGetResp resp = new Gson().fromJson(respText, MaterialGetResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMaterialGetMaterial %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 删除素材
	 * 
	 * @param mediaId
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiMaterialDelMaterial(String mediaId)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("material/del_material?access_token=%s", token.getAccessToken());
		TreeMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("media_id", mediaId);
	
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMaterialDelMaterial %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 修改永久图文素材
	 * 
	 * @param mediaId
	 * @param index
	 *            第一篇为0
	 * @param article
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BaseResp apiMaterialUpdateNews(String mediaId, int index, Article article)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("material/update_news?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("media_id", mediaId);
		reqMap.put("index", index);
		reqMap.put("articles", article);
	
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BaseResp resp = new Gson().fromJson(respText, BaseResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMaterialUpdateNews %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 获取素材总数
	 * 
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public GetMaterialCountResp apiMaterialGetMaterialCount()
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("material/get_materialcount?access_token=%s", token.getAccessToken());
		String respText = HttpUtil.get(mpApi.config.getApiHttps(), path);
		GetMaterialCountResp resp = new Gson().fromJson(respText, GetMaterialCountResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMaterialGetMaterialCount %s", new Gson().toJson(resp)));
		}
		return resp;
	}

	/**
	 * 批量获取素材列表
	 * 
	 * @param type
	 * @param offset
	 *            从全部素材的该偏移位置开始返回，0表示从第一个素材
	 * @param count
	 *            返回素材的数量，取值在1到20之间
	 * @return
	 * @throws ClientProtocolException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws AccessTokenFailException
	 */
	public BatchGetMaterialResp apiMaterialBatchGetMaterial(MediaTypeEnum type, int offset, int count)
			throws ClientProtocolException, URISyntaxException, IOException, AccessTokenFailException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("material/batchget_material?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("type", type);
		reqMap.put("offset", offset);
		reqMap.put("count", count);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		BatchGetMaterialResp resp = new Gson().fromJson(respText, BatchGetMaterialResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiMaterialBatchGetMaterial %s", new Gson().toJson(resp)));
		}
		return resp;
	}
	
	
}
