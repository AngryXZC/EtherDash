package com.xzc.bean;


public class ItemInfo {
	
	//id
	private String item_id;
	//name
	private String item_name;
	//type
	private String item_type;
	//price
	private Double item_price;
	
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public Double getItem_price() {
		return item_price;
	}
	public void setItem_price(Double item_price) {
		this.item_price = item_price;
	}
	@Override
	public String toString() {
		return "ItemInfo [item_id=" + item_id + ", item_name=" + item_name + ", item_type=" + item_type
				+ ", item_price=" + item_price + "]";
	}

}
