package com.shanli.weixin.mp.recv.event;

/**
 * 消息群发结果事件。
 * 由于群发任务提交后，群发任务可能在一定时间后才完成，因此，群发接口调用时，仅会给出群发任务是否提交成功的提示，若群发任务提交成功，则在群发任务结束时，会向开发者在公众平台填写的开发者URL（callback
 * URL）推送事件。 需要注意，由于群发任务彻底完成需要较长时间，将会在群发任务即将完成的时候，就推送群发结果，此时的推送人数数据将会与实际情形存在一定误差
 * 
 * @author alex
 *
 */
public class MsgEventMassSendJobFinish extends MsgEvent {

	private String msgID;// 群发的消息ID
	/**
	 * err(10001), //涉嫌广告 err(20001), //涉嫌政治 err(20004), //涉嫌社会 err(20002),
	 * //涉嫌色情 err(20006), //涉嫌违法犯罪 err(20008), //涉嫌欺诈 err(20013), //涉嫌版权
	 * err(22000), //涉嫌互推(互相宣传) err(21000), //涉嫌其他 err(30001) //
	 * 原创校验出现系统错误且用户选择了被判为转载就不群发 err(30002) // 原创校验被判定为不能群发 err(30003) //
	 * 原创校验被判定为转载文且用户选择了被判为转载就不群发
	 */
	private String status;// 状态
	private Integer totalCount;// tag_id下粉丝数；或者openid_list中的粉丝数
	/**
	 * 过滤后准备发送的粉丝数。 原则上，FilterCount = SentCount + ErrorCount
	 */
	private Integer filterCount;// 过滤后粉丝数
	/**
	 * 发送成功的粉丝数
	 */
	private Integer sentCount;
	private Integer errorCount;// 发送失败的粉丝数
	private CopyrightCheckResult copyrightCheckResult;// 各个单图文校验结果

	public static class CopyrightCheckResult {
		private Integer count;// 新闻条数
		private ResultList resultList;
		/**
		 * 整体校验结果。 1-未被判为转载，可以群发，2-被判为转载，可以群发，3-被判为转载，不能群发
		 */
		private Integer checkState;

		/**
		 * 新闻条数
		 * 
		 * @return the count
		 */
		public Integer getCount() {
			return count;
		}

		/**
		 * 新闻条数
		 * 
		 * @param count
		 *            the count to set
		 */
		public void setCount(Integer count) {
			this.count = count;
		}

		/**
		 * @return the resultList
		 */
		public ResultList getResultList() {
			return resultList;
		}

		/**
		 * @param resultList
		 *            the resultList to set
		 */
		public void setResultList(ResultList resultList) {
			this.resultList = resultList;
		}

		/**
		 * 整体校验结果。
		 * 
		 * @return the checkState
		 */
		public Integer getCheckState() {
			return checkState;
		}

		/**
		 * 整体校验结果。
		 * 
		 * @param checkState
		 *            the checkState to set
		 */
		public void setCheckState(Integer checkState) {
			this.checkState = checkState;
		}

	}

	public static class ResultList {
		private ResultListItem item;

		/**
		 * @return the item
		 */
		public ResultListItem getItem() {
			return item;
		}

		/**
		 * @param item
		 *            the item to set
		 */
		public void setItem(ResultListItem item) {
			this.item = item;
		}

	}

	public static class ResultListItem {
		private Integer articleIdx;// 群发文章的序号，从1开始
		private Integer userDeclareState;// 用户声明文章的状态
		private Integer auditState;// 系统校验的状态
		private String originalArticleUrl;// 相似原创文的url
		private Integer originalArticleType;// 相似原创文的类型
		private Integer canReprint;
		private Integer needReplaceContent;
		private Integer needShowReprintSource;

		/**
		 * 群发文章的序号
		 * 
		 * @return the articleIdx
		 */
		public Integer getArticleIdx() {
			return articleIdx;
		}

		/**
		 * 群发文章的序号
		 * 
		 * @param articleIdx
		 *            the articleIdx to set
		 */
		public void setArticleIdx(Integer articleIdx) {
			this.articleIdx = articleIdx;
		}

		/**
		 * 用户声明文章的状态
		 * 
		 * @return the userDeclareState
		 */
		public Integer getUserDeclareState() {
			return userDeclareState;
		}

		/**
		 * 用户声明文章的状态
		 * 
		 * @param userDeclareState
		 *            the userDeclareState to set
		 */
		public void setUserDeclareState(Integer userDeclareState) {
			this.userDeclareState = userDeclareState;
		}

		/**
		 * 系统校验的状态
		 * 
		 * @return the auditState
		 */
		public Integer getAuditState() {
			return auditState;
		}

		/**
		 * 系统校验的状态
		 * 
		 * @param auditState
		 *            the auditState to set
		 */
		public void setAuditState(Integer auditState) {
			this.auditState = auditState;
		}

		/**
		 * 相似原创文的url
		 * 
		 * @return the originalArticleUrl
		 */
		public String getOriginalArticleUrl() {
			return originalArticleUrl;
		}

		/**
		 * 相似原创文的url
		 * 
		 * @param originalArticleUrl
		 *            the originalArticleUrl to set
		 */
		public void setOriginalArticleUrl(String originalArticleUrl) {
			this.originalArticleUrl = originalArticleUrl;
		}

		/**
		 * 相似原创文的类型
		 * 
		 * @return the originalArticleType
		 */
		public Integer getOriginalArticleType() {
			return originalArticleType;
		}

		/**
		 * 相似原创文的类型
		 * 
		 * @param originalArticleType
		 *            the originalArticleType to set
		 */
		public void setOriginalArticleType(Integer originalArticleType) {
			this.originalArticleType = originalArticleType;
		}

		/**
		 * 是否能转载
		 * 
		 * @return the canReprint
		 */
		public Integer getCanReprint() {
			return canReprint;
		}

		/**
		 * 是否能转载
		 * 
		 * @param canReprint
		 *            the canReprint to set
		 */
		public void setCanReprint(Integer canReprint) {
			this.canReprint = canReprint;
		}

		/**
		 * 是否需要替换成原创文内容
		 * 
		 * @return the needReplaceContent
		 */
		public Integer getNeedReplaceContent() {
			return needReplaceContent;
		}

		/**
		 * 是否需要替换成原创文内容
		 * 
		 * @param needReplaceContent
		 *            the needReplaceContent to set
		 */
		public void setNeedReplaceContent(Integer needReplaceContent) {
			this.needReplaceContent = needReplaceContent;
		}

		/**
		 * 是否需要注明转载来源
		 * 
		 * @return the needShowReprintSource
		 */
		public Integer getNeedShowReprintSource() {
			return needShowReprintSource;
		}

		/**
		 * 是否需要注明转载来源
		 * 
		 * @param needShowReprintSource
		 *            the needShowReprintSource to set
		 */
		public void setNeedShowReprintSource(Integer needShowReprintSource) {
			this.needShowReprintSource = needShowReprintSource;
		}

	}

	/**
	 * 状态
	 * 
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 状态
	 * 
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * tag_id下粉丝数；或者openid_list中的粉丝数
	 * 
	 * @return the totalCount
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * tag_id下粉丝数；或者openid_list中的粉丝数
	 * 
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 过滤后粉丝数
	 * 
	 * @return the filterCount
	 */
	public Integer getFilterCount() {
		return filterCount;
	}

	/**
	 * 过滤后粉丝数
	 * 
	 * @param filterCount
	 *            the filterCount to set
	 */
	public void setFilterCount(Integer filterCount) {
		this.filterCount = filterCount;
	}

	/**
	 * 发送成功的粉丝数
	 * 
	 * @return the sentCount
	 */
	public Integer getSentCount() {
		return sentCount;
	}

	/**
	 * 发送成功的粉丝数
	 * 
	 * @param sentCount
	 *            the sentCount to set
	 */
	public void setSentCount(Integer sentCount) {
		this.sentCount = sentCount;
	}

	/**
	 * 发送失败的粉丝数
	 * 
	 * @return the errorCount
	 */
	public Integer getErrorCount() {
		return errorCount;
	}

	/**
	 * 发送失败的粉丝数
	 * 
	 * @param errorCount
	 *            the errorCount to set
	 */
	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}

	/**
	 * 各个单图文校验结果
	 * 
	 * @return the copyrightCheckResult
	 */
	public CopyrightCheckResult getCopyrightCheckResult() {
		return copyrightCheckResult;
	}

	/**
	 * 各个单图文校验结果
	 * 
	 * @param copyrightCheckResult
	 *            the copyrightCheckResult to set
	 */
	public void setCopyrightCheckResult(CopyrightCheckResult copyrightCheckResult) {
		this.copyrightCheckResult = copyrightCheckResult;
	}

	/**
	 * 群发的消息ID
	 * 
	 * @return the msgID
	 */
	public String getMsgID() {
		return msgID;
	}

	/**
	 * 群发的消息ID
	 * 
	 * @param msgID
	 *            the msgID to set
	 */
	public void setMsgID(String msgID) {
		this.msgID = msgID;
	}
}
