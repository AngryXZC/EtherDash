package com.xzc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object obj,	//obj 异常对象的 全包名 + 类名+ 方法名
			Exception e) {
		
		ModelAndView mav = new ModelAndView();
		
		//获取异常信息
		String errorMsg = "";
		
		//判断异常信息类型
		if(e instanceof MyException) {
			//执行自定义异常处理
			errorMsg = "自定异常 " + ((MyException)e).getMsg() +"  " + obj;
		}else {
			//运行时异常
			errorMsg = "运行时异常 " + e.getMessage() +"  " + obj;
		}
		
		//将异常信息输出到错误页面
		mav.addObject("error", errorMsg);
		
		//设置要跳转的视图名称
		mav.setViewName("error");
		
		return mav;
	}

}
