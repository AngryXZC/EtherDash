package com.xzc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xzc.bean.ItemInfo;
import com.xzc.bean.ItemInfoVo;
import com.xzc.exception.MyException;
import com.xzc.service.ItemService;

/**
 * 游戏信息管理
 */
@Controller
@RequestMapping("/item/")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("allList.do")
	public ModelAndView list() throws MyException {
		ModelAndView mav = new ModelAndView();
		
		List<ItemInfo> itemList = itemService.selectAll();
		
		//查询 将结果赋值给mav
		mav.addObject("itemList", itemList);
		
		//设置视图名
		mav.setViewName("item_list");
		
		return mav;
	}
	
	//默认参数绑定
	@RequestMapping("select.do")
	public String select(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		
		//获取参数
		String id = request.getParameter("id");
		//查询
		ItemInfo item = itemService.selectItemInfoById(id);
		
		List<ItemInfo> itemList = new ArrayList<ItemInfo>();
		itemList.add(item);
		
		//model 保存数据
		//request.setAttribute(arg0, arg1);
		model.addAttribute("itemList", itemList);
		
		//返回视图名
		return "item_list";
	}
	
	//基本类型参数绑定
	@RequestMapping("delete.do")
	//public String delete(@RequestParam(value="id",required=false, defaultValue="1")String deleteId) 
	public String delete(String id) 
	{
		//从前台获取id
		System.out.println( "delete id = " + id);
		
		//删除
		itemService.deleteById(id);
		
		//重定向到列表页
		return "redirect:allList.do";
	}
	
	//绑定bean对象的形式 来完成参数获取
	@RequestMapping("save.do")
	public String save(ItemInfo item) {
		//获取参数
		System.out.println(item);
		
		//保存逻辑
		itemService.save(item);
		
		//重定向到列表页
		return "redirect:allList.do";
	}
	
	//包装类绑定
	@RequestMapping("selectByVo.do")
	public String selectByVo(ItemInfoVo vo, Model model) {
		
		//获取vo对象
		System.out.println("itemInfoVo " + vo.getItemInfo());
		
		//查询
		List<ItemInfo> itemList = itemService.selectByVo(vo);
		
		//保存数据
		model.addAttribute("itemList", itemList);
		
		//返回视图名称
		return "item_list";
		
	}
	
	//绑定数组
	@RequestMapping("selectArrays.do")
	public void selectArrays(String[] ids) {
		System.out.println(" ids =" + ids.length);
		
		for (String string : ids) {
			System.out.println(" id = " + string);
		}
	}
	
	//绑定Vo数组
	@RequestMapping("selectVoArrays.do")
	public void selectVoArrays(ItemInfoVo vo) {
		System.out.println(" ids =" + vo.getIds().length);
		
		for (String string : vo.getIds()) {
			System.out.println(" id = " + string);
		}
	}
	
	//绑定Vo List集合
	@RequestMapping("selectVoList.do")
	public void selectVoList(ItemInfoVo vo) {
		System.out.println(" list =" + vo.getPriceList().size());
		
		Double totalPrice = 0d;
		for (Double price : vo.getPriceList()) {
			System.out.println(" price = " + price);
			
			totalPrice += price;
		}
		
		System.out.println("总价 = " + totalPrice);
	}
	
	//接收前台的json字符串
	
	@RequestMapping("jsonData")
	@ResponseBody
	public ItemInfo jsonData(@RequestBody ItemInfo item) {
		System.out.println("json Data = " + item);
		
		return item;
				
	}
	
	//回显数据
	@RequestMapping("editItem.do")
	@ResponseBody
	public ItemInfo editItem(String id) {
		//根据id查询一个游戏信息
		ItemInfo item = itemService.selectItemInfoById(id);
		return item;
	}
	
	
/*	//使用@RequestBody 来绑定 list
	@RequestMapping("getNameList.do")
	public void getNameList(@RequestBody List<String> nameList) {
		
		System.out.println("namelist size " + nameList.size());
		
		for (String string : nameList) {
			System.out.println(string);
		}
	}*/
	
	//使用@RequestBody 来绑定 array
	@RequestMapping("getNameList.do")
	public void getNameList(@RequestBody String[] array) {
		
		System.out.println("namelist size " + array.length);
		
		for (String string : array) {
			System.out.println(" array name = " + string);
		}
	}
	
	//使用restFul开发
	//查询一个游戏信息，并且显示在内容页
	
	@RequestMapping(value = "{item_id}", method=RequestMethod.GET)
	@ResponseBody
	public ItemInfo restFul(@PathVariable("item_id") String id, Model model) {
		System.out.println("ajax " + id);
		//查询
		ItemInfo item = itemService.selectItemInfoById(id);
		
		model.addAttribute("item", item);
		
		//返回页面
		//return "item_info";
		return item;
	}
	
	
}
