package com.h3c.framework.common.dto;

import java.util.List;

/**
 * 原生SQL分页查询DTO
 * @author 周兆巍
 * @version 创建时间：2014年12月4日 上午11:00:09
 */
public class SqlQueryDTO {

	private int totalCount;
	private List<Object[]> objLst;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<Object[]> getObjLst() {
		return objLst;
	}
	public void setObjLst(List<Object[]> objLst) {
		this.objLst = objLst;
	}
}
