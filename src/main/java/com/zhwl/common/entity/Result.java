package com.zhwl.common.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Result {

	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1698938732924943919L;

	// @Fields SUCCESS : TODO(用一句话描述这个变量表示什么)
	@SuppressWarnings("unused")
	private static final int SUCCESS = 1;
	// @Fields FAILURE : TODO(用一句话描述这个变量表示什么)
	@SuppressWarnings("unused")
	private static final int FAILURE = -1;

	// @Fields success : 是否成功(用一句话描述这个变量表示什么)
	private boolean success = false;

	// @Fields message : 提示消息(用一句话描述这个变量表示什么)
	private String message = "";

	// @Fields object : 数据(用一句话描述这个变量表示什么)
	private Object data = null;

	private List dataList = new ArrayList();

	private Map<String, Object> dataMap = new HashMap<String, Object>();

	private Map<String, List<Object>> dataMapList = new HashMap<String, List<Object>>();

	/**
	 * 要获得的 @return success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            要设置的 success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * 要获得的 @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            要设置的 message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 要获得的 @return dataList
	 */
	public List getDataList() {
		return dataList;
	}

	/**
	 * @param resourceList
	 *            要设置的 dataList
	 */
	public void setDataList(List resourceList) {
		this.dataList = resourceList;
	}

	/**
	 * 要获得的 @return dataMap
	 */
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	/**
	 * @param dataMap
	 *            要设置的 dataMap
	 */
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	/**
	 * 要获得的 @return dataMapList
	 */
	public Map<String, List<Object>> getDataMapList() {
		return dataMapList;
	}

	/**
	 * @param dataMapList
	 *            要设置的 dataMapList
	 */
	public void setDataMapList(Map<String, List<Object>> dataMapList) {
		this.dataMapList = dataMapList;
	}

}
