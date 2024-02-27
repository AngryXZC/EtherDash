package com.xzc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xzc.bean.User;
import com.xzc.exception.MyLoginException;

/**
 * 登录
 */
@Controller
@RequestMapping("/login/")
public class LoginController {

	//登录请求 
	
	//登录成功 重定向到列表页
	@RequestMapping(value = "login.do", method= RequestMethod.POST)
	public String login(User u, HttpSession session) throws MyLoginException {
		
		User user = new User();
		user.setUsername("xzc");
		user.setPassword("123");
		
		if(u.getUsername().equals(user.getUsername())) {
			//用户名正确
			if(u.getPassword().equals(user.getPassword())) {
				session.setAttribute("user", u);
			}
			else {
				//throw new MyLoginException("密码错误");
				throw new  MyLoginException(u.getUsername(), "密码错误");
			}
		}
		else {
			throw new MyLoginException("用户名错误");
		}
		
		//判断用户
		/*if(u != null) {
			session.setAttribute("user", u);
		}*/
		
		//重定向到列表页
		return "redirect:/item/allList.do";
	}
	
	
	//登录失败 前往登录页面
	@RequestMapping(value = "login.do", method= RequestMethod.GET)
	public String login() {
		//前往登录页面
		return "login_page";
	}
	
	
}
