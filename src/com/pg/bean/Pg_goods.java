package com.pg.bean;

public class Pg_goods {

	private String GoodsID;			 //物品系统编码,
	//private String GoodsCode;		 //物品编码,
	private String GoodsName;		 //物品名称,
	private String GoodsType;		 //1,烟 2,酒 3,茶,	
	private String Number;			 //数量,	
	private String UnitPrice;		 //单价,	
	private String Unit;			 //单位,	
	private String Status; 			 //订单状态(1有效，-1删除)
	private String CreatedBy; 		 //创建人
	private String CreatedDate; 	 //创建时间
	private String ModifiedBy; 		 //修改人
	private String ModifiedDate; 	 //修改时间

	//GoodsID,GoodsName,GoodsType,
	//Number,UnitPrice,Unit,Status,
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
	public void setUnitPrice(String unitPrice) {
		UnitPrice = unitPrice;
	}
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
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
