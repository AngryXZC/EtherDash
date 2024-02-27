package com.xzc.exception;

//自定义异常
public class MyException extends Exception {

	//错误消息
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public MyException(String msg) {
		super();
		this.msg = msg;
	}
	
	
}
