package com.pg.bean;

public class Pg_goods {

	private String GoodsID;			 //��Ʒϵͳ����,
	//private String GoodsCode;		 //��Ʒ����,
	private String GoodsName;		 //��Ʒ����,
	private String GoodsType;		 //1,�� 2,�� 3,��,	
	private String Number;			 //����,	
	private String UnitPrice;		 //����,	
	private String Unit;			 //��λ,	
	private String Status; 			 //����״̬(1��Ч��-1ɾ��)
	private String CreatedBy; 		 //������
	private String CreatedDate; 	 //����ʱ��
	private String ModifiedBy; 		 //�޸���
	private String ModifiedDate; 	 //�޸�ʱ��

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
