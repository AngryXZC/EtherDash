package com.xzc.exception;


public class MyLoginException extends Exception {
	
	private String msg;
	
	private Object obj;
	
	public Object getObj() {
		return obj;
	}

	public String getMsg() {
		return msg;
	}

	public MyLoginException(String msg) {
		super();
		this.msg = msg;
	}
	
	public MyLoginException(Object obj, String msg) {
		super();
		this.msg = msg;
		this.obj = obj;
	}
	

}
