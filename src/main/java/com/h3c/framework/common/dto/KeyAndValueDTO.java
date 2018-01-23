package com.h3c.framework.common.dto;
/**
 * 键与值的DTO或者是2个属性的DTO
 * 类型由开发人员自己控制
 * {@code
 * 	 KeyAndValueDTO<int,String> dto = new KeyAndValueDTO<int,String>();
 * }
 * @author 周兆巍
 * @version 创建时间：2014年11月11日 上午9:05:37
 */
public class KeyAndValueDTO<keyName,valueName> {

	private  keyName key;
	private  valueName value;
	
	public KeyAndValueDTO(){}
	
	public KeyAndValueDTO(keyName key,valueName value){
		this.key = key;
		this.value = value;
	}

	public keyName getKey(){
		return this.key;
	}
	public void setKey(keyName key){
		this.key = key;
	}
	public valueName getValue(){
		return this.value;
	}
	public void setValue(valueName value){
		this.value = value;
	}	
} 
