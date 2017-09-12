package com.pg.bean;

public class Pg_order_goods {
	private String GoodsID;			 //订单系物品系统编码
	//private String GoodsCode;		 //订单物品编码
	private String GoodsName;		 //订单物品名称
	private String OrderCode;		 //订单code 来源于(pg_order)
	private String GoodsType;		 //1,烟 2,酒 3,茶
	private String Number;			 //数量
	private String UnitPrice;			 //单价	
	private String TotalPrice;		 //总价	
	private String Status; 			 //订单状态(1有效, 0, 未确认  -1,删除)
	private String CreatedBy; 		 //创建人
	private String CreatedDate; 	 //创建时间
	private String ModifiedBy; 		 //修改人
	private String ModifiedDate; 	 //修改时间	
	
	//GoodsID,GoodsCode,GoodsName,OrderCode,
	//GoodsType,Number,Price,Status,
	//CreatedBy,CreatedDate,ModifiedBy,ModifiedDate
	
	public String getGoodsID() {
		return GoodsID;
	}
	public void setGoodsID(String goodsID) {
		GoodsID = goodsID;
	}
	//public String getGoodsCode() {
	//	return GoodsCode;
	//}
	//public void setGoodsCode(String goodsCode) {
	//	GoodsCode = goodsCode;
	//}
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public String getGoodsType() {
		return GoodsType;
	}
	public void setGoodsType(String goodsType) {
		GoodsType = goodsType;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public String getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(String price) {
		UnitPrice = price;
	}
	public String getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		TotalPrice = totalPrice;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public String getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(String createdDate) {
		CreatedDate = createdDate;
	}
	public String getModifiedBy() {
		return ModifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}
	public String getModifiedDate() {
		return ModifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		ModifiedDate = modifiedDate;
	}	
}
