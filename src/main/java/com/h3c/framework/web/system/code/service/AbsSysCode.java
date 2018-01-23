package com.h3c.framework.web.system.code.service;

import java.util.List;

import com.h3c.framework.common.entities.VSyscode;

public abstract class AbsSysCode implements ISysCode {

	/**
	 * 从代码表中取代码
	 * 
	 * @param codeType
	 *            代码类别
	 * @param filter
	 *            代码过滤条件
	 * @return
	 */
	abstract public List<VSyscode> getCodeList(String codeType, String filter);

	/**
	 * 根据codeType和code查代码视图，如果存在，则返回code对应的名称，否则返回原code
	 * 
	 * @param codeType
	 * @param code
	 * @return
	 */
	abstract public String getValueByCode(String codeType, String code);

}
