package com.shanli.weixin.mp.bean;

/**
 * 用户标签
 * 
 * @author alex
 *
 */
public class Tag {
	private Integer id;
	private String name;
	private Long count;// 此标签下粉丝数

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 此标签下粉丝数
	 * 
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * 此标签下粉丝数
	 * 
	 * @param count
	 *            the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}

}
