package com.shanli.weixin.mp;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.TreeMap;

import org.apache.http.ParseException;

import com.google.gson.Gson;
import com.shanli.weixin.bean.AccessTokenFailException;
import com.shanli.weixin.mp.bean.MpAccessToken;
import com.shanli.weixin.mp.resp.datacube.DataCubeGetArticleCountResp;
import com.shanli.weixin.mp.resp.datacube.DataCubeGetArticleSummaryResp;
import com.shanli.weixin.mp.resp.datacube.DataCubeGetInterfaceSummaryHourResp;
import com.shanli.weixin.mp.resp.datacube.DataCubeGetInterfaceSummaryResp;
import com.shanli.weixin.mp.resp.datacube.DataCubeGetUserCumulateResp;
import com.shanli.weixin.mp.resp.datacube.DataCubeGetUserReadHourResp;
import com.shanli.weixin.mp.resp.datacube.DataCubeGetUserReadResp;
import com.shanli.weixin.mp.resp.datacube.DataCubeGetUserShareHourResp;
import com.shanli.weixin.mp.resp.datacube.DataCubeGetUserShareResp;
import com.shanli.weixin.mp.resp.datacube.DataCubeGetUserSummaryResp;
import com.shanli.weixin.util.HttpUtil;

/**
 * 数据统计API。应用层应当进行缓存。
 * 
 * @author alex
 *
 */
public class MpDataCubeApi {
	private MpApi mpApi;

	public MpDataCubeApi(MpApi mpApi) {
		this.mpApi = mpApi;
	}

	/**
	 * 获取用户增减数据。时间跨度不超过7天。
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws AccessTokenFailException
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public DataCubeGetUserSummaryResp apiDataCubeGetUserSummary(java.sql.Date beginDate, java.sql.Date endDate)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/datacube/getusersummary?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("begin_date", beginDate);
		reqMap.put("end_date", endDate);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		DataCubeGetUserSummaryResp resp = new Gson().fromJson(respText, DataCubeGetUserSummaryResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiDataCubeGetUserSummary %s", resp));
		}
		return resp;
	}

	/**
	 * 获取累计用户量数据。时间跨度不超过7天。
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws AccessTokenFailException
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public DataCubeGetUserCumulateResp apiDataCubeGetUserCumulate(java.sql.Date beginDate, java.sql.Date endDate)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/datacube/getusercumulate?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("begin_date", beginDate);
		reqMap.put("end_date", endDate);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		DataCubeGetUserCumulateResp resp = new Gson().fromJson(respText, DataCubeGetUserCumulateResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiDataCubeGetUserCumulate %s", resp));
		}
		return resp;
	}

	/**
	 * 获取图文群发每日数据。
	 * 
	 * @param date
	 * @return
	 * @throws AccessTokenFailException
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public DataCubeGetArticleSummaryResp apiDataCubeGetArticleSummary(java.sql.Date date)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/datacube/getarticlesummary?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("begin_date", date);
		reqMap.put("end_date", date);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		DataCubeGetArticleSummaryResp resp = new Gson().fromJson(respText, DataCubeGetArticleSummaryResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiDataCubeGetArticleSummary %s", resp));
		}
		return resp;
	}

	/**
	 * 获取图文群发总数据。
	 * 
	 * @param date
	 * @return
	 * @throws AccessTokenFailException
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public DataCubeGetArticleCountResp apiDataCubeGetArticleCount(java.sql.Date date)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/datacube/getarticlesummary?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("begin_date", date);
		reqMap.put("end_date", date);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		DataCubeGetArticleCountResp resp = new Gson().fromJson(respText, DataCubeGetArticleCountResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiDataCubeGetArticleCount %s", resp));
		}
		return resp;
	}

	/**
	 * 获取图文统计数据。时间跨度不超过3天。
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws AccessTokenFailException
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public DataCubeGetUserReadResp apiDataCubeGetUserRead(java.sql.Date beginDate, java.sql.Date endDate)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/datacube/getuserread?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("begin_date", beginDate);
		reqMap.put("end_date", endDate);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		DataCubeGetUserReadResp resp = new Gson().fromJson(respText, DataCubeGetUserReadResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiDataCubeGetUserRead %s", resp));
		}
		return resp;
	}

	/**
	 * 图文统计分时数据。
	 * 
	 * @param date
	 * @return
	 * @throws AccessTokenFailException
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public DataCubeGetUserReadHourResp apiDataCubeGetUserReadHour(java.sql.Date date)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/datacube/getuserreadhour?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("begin_date", date);
		reqMap.put("end_date", date);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		DataCubeGetUserReadHourResp resp = new Gson().fromJson(respText, DataCubeGetUserReadHourResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiDataCubeGetUserReadHour %s", resp));
		}
		return resp;
	}

	/**
	 * 获取图文分享数据。时间跨度不超过7天。
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws AccessTokenFailException
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public DataCubeGetUserShareResp apiDataCubeGetUserShare(java.sql.Date beginDate, java.sql.Date endDate)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/datacube/getusershare?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("begin_date", beginDate);
		reqMap.put("end_date", endDate);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		DataCubeGetUserShareResp resp = new Gson().fromJson(respText, DataCubeGetUserShareResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiDataCubeGetUserShare %s", resp));
		}
		return resp;
	}

	/**
	 * 获取图文分享小时数据。
	 * 
	 * @param beginDate
	 * @return
	 * @throws AccessTokenFailException
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public DataCubeGetUserShareHourResp apiDataCubeGetUserShareHour(java.sql.Date date)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/datacube/getusersharehour?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("begin_date", date);
		reqMap.put("end_date", date);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		DataCubeGetUserShareHourResp resp = new Gson().fromJson(respText, DataCubeGetUserShareHourResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiDataCubeGetUserShareHour %s", resp));
		}
		return resp;
	}

	/**
	 * 获取接口分析数据。时间跨度不超过30天。
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws AccessTokenFailException
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public DataCubeGetInterfaceSummaryResp apiDataCubeGetInterfaceSummary(java.sql.Date beginDate,
			java.sql.Date endDate) throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/datacube/getinterfacesummary?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("begin_date", beginDate);
		reqMap.put("end_date", endDate);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		DataCubeGetInterfaceSummaryResp resp = new Gson().fromJson(respText, DataCubeGetInterfaceSummaryResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiDataCubeGetInterfaceSummary %s", resp));
		}
		return resp;
	}

	/**
	 * 获取接口分析小时数据。
	 * 
	 * @param date
	 * @return
	 * @throws AccessTokenFailException
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public DataCubeGetInterfaceSummaryHourResp apiDataCubeGetInterfaceSummaryHour(java.sql.Date date)
			throws AccessTokenFailException, ParseException, IOException, URISyntaxException {
		MpAccessToken token = mpApi.apiToken();
		String path = String.format("/datacube/getinterfacesummaryhour?access_token=%s", token.getAccessToken());
		TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
		reqMap.put("begin_date", date);
		reqMap.put("end_date", date);
		String respText = HttpUtil.post(mpApi.config.getApiHttps(), path, reqMap);
		DataCubeGetInterfaceSummaryHourResp resp = new Gson().fromJson(respText,
				DataCubeGetInterfaceSummaryHourResp.class);
		if (mpApi.log.isInfoEnabled()) {
			mpApi.log.info(String.format("apiDataCubeGetInterfaceSummaryHour %s", resp));
		}
		return resp;
	}

}
