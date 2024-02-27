package com.xzc.bean;

import java.util.List;


public class ItemInfoVo {
	
	private ItemInfo itemInfo;
	
	private String[] ids;
	
	private List<Double> priceList;
	
	public List<Double> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<Double> priceList) {
		this.priceList = priceList;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public ItemInfo getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(ItemInfo itemInfo) {
		this.itemInfo = itemInfo;
	}
}
