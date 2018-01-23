package com.h3c.framework.web.system.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.h3c.framework.common.entities.VSyscode;
import com.h3c.framework.web.system.code.service.ISysCode;

/**
 * 
 * 代码管理类
 * 
 * @author 周兆巍
 * @version 创建时间：2014年10月26日 上午10:09:54
 */
@Controller
public class SysCodeController {

	@Autowired
	private ISysCode syscode;

	/**
	 * 从代码表中取代码
	 * 
	 * @param codeType
	 *            代码类别
	 * @param filter
	 *            代码过滤条件
	 * @return
	 */
	public List<VSyscode> getCodeList(String codeType, String filter) {
		return syscode.getCodeList(codeType, filter);
	}

	/**
	 * 根据codeType和code查代码视图，如果存在，则返回code对应的名称，否则返回原code
	 * 
	 * @param codeType
	 * @param code
	 * @return
	 */
	public String getValueByCode(String codeType, String code) {
		return syscode.getValueByCode(codeType, code);
	}

}
