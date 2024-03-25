package com.xzc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzc.bean.ItemInfo;
import com.xzc.bean.ItemInfoVo;
import com.xzc.exception.MyException;
import com.xzc.mapper.ItemMapper;


@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;

	@Override
	public List<ItemInfo> selectAll() throws MyException {

		//制造运行时异常
//		int i = 1/0;
//
//		if(true) {
//			throw new MyException("列表没有获取到");
//		}


		return itemMapper.selectAll();
	}

	@Override
	public ItemInfo selectItemInfoById(String id) {
		return itemMapper.selectItemInfoById(id);
	}

	@Override
	public void deleteById(String id) {
		itemMapper.deleteById(id);
	}

	@Override
	public void save(ItemInfo item) {
		itemMapper.save(item);
	}

	@Override
	public List<ItemInfo> selectByVo(ItemInfoVo vo) {
		return itemMapper.selectByVo(vo);
	}



}
