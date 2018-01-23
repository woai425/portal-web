package com.h3c.framework.common.dto;

import java.util.Map;



/**
 * *********************************************************************
 * 后台返回前台的DTO对象
 * AjaxJson.java
 *
 * H3C所有，
 * 受到法律的保护，任何公司或个人，未经授权不得擅自拷贝。
 * @copyright   Copyright: 2015-2020
 * @creator     z10926<br/>
 * @create-time 2015年12月14日 下午3:59:47
 * @revision    $Id:  *
 **********************************************************************
 */
public class AjaxJson {

	private boolean success = true;
	private String msg = "请求成功！";
	private Object data = null;
	private Map<String, Object> attributes;
	private int totalCount;
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	/*
	public String getJsonStr(){
		JSONObject obj = new JSONObject();
		obj.put("success", this.isSuccess());
		obj.put("msg", this.msg);
		obj.put("data", this.data);
		obj.put("totalCount", this.totalCount);
		obj.put("attributes", this.attributes);
		return obj.toString();
	}*/
}
