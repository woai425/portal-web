package com.h3c.framework.exception;
/**
 * 用户异常类
 * @author 周兆巍
 * @version 创建时间：2014年11月11日 下午6:53:13
 */
public class UserException extends Exception{

	private static final long serialVersionUID = 1L;
	Throwable myException;
	
	public UserException(String errorMsg){
		super(errorMsg);
	}
	
	public UserException(String errorMsg,Exception e){
		super(errorMsg);
		this.myException=e;
	}
	
	public String getDetailMessage(){
		if(myException!=null){
			return myException.getMessage();
		}else{
			return null;
		}
	}
	
	public String toString(){
		String s=this.getMessage();
		if(myException!=null){
			s=s+","+myException.getMessage();
		}
		return s;
	}
	
	public void printStackTrace(){
		//this.printStackTrace();
		if(myException!=null){
			myException.printStackTrace();
		}
	}

	public Throwable getMyException() {
		return myException;
	}

	public void setMyException(Throwable myException) {
		this.myException = myException;
	}

}
