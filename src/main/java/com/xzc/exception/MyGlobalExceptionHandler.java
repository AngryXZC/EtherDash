package com.xzc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class MyGlobalExceptionHandler {
	
	//处理运行时异常
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	String runtimeHandler(RuntimeException e) {
		return e.getMessage();
	}

	
	//处理自定义异常
	@ExceptionHandler(MyException.class)
	String myHandler(MyException e, Model model) {
		
		model.addAttribute("error", e.getMsg() + "  " + e.getStackTrace()[0]);
		
		//视图名
		return "error";
		
	}
	
	//处理自定义异常
	@ExceptionHandler(MyLoginException.class)
	String loginException(MyLoginException e, Model model) {
		
		Object obj = e.getObj();
		if(obj != null)
		{
			model.addAttribute("username", obj.toString());
		}
		
		model.addAttribute("errorMsg", e.getMsg());
		
		//视图名
		return "login_page";
		
	}
	
}
