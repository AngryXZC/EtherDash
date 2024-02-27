package com.xzc.mapper;

import java.util.List;

import com.xzc.bean.ItemInfo;
import com.xzc.bean.ItemInfoVo;


public interface ItemMapper {
	
	//查询全部
	public List<ItemInfo> selectAll();

	//根据id 查询ItemInfo
	public ItemInfo selectItemInfoById(String id);

	//根据id删除
	public void deleteById(String id);

	//保存
	public void save(ItemInfo item);

	//根据vo 查询 返回列表
	public List<ItemInfo> selectByVo(ItemInfoVo vo);
	
}
