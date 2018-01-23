package com.h3c.framework.exception;
/**
 * 用户组织异常
 * @author 周兆巍
 * @version 创建时间：2014年11月10日 下午5:40:23
 */
public class GroupException extends Exception{

	private static final long serialVersionUID = -918297720990500482L;
	Throwable myException;
	
	public GroupException(String errorMsg){
		super(errorMsg);
	}
	
	public GroupException(String errorMsg,Exception e){
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