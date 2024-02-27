package com.xzc.service;

import java.util.List;

import com.xzc.bean.ItemInfo;
import com.xzc.bean.ItemInfoVo;
import com.xzc.exception.MyException;

public interface ItemService {
	
	//查询全部
	public List<ItemInfo> selectAll() throws MyException;

	//根据id查询 itemInfo
	public ItemInfo selectItemInfoById(String id);

	//根据id删除
	public void deleteById(String id);

	//保存
	public void save(ItemInfo item);

	//根据vo查询 返回列表
	public List<ItemInfo> selectByVo(ItemInfoVo vo);
}
