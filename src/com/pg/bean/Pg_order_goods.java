package com.pg.bean;

public class Pg_order_goods {
	private String GoodsID;			 //����ϵ��Ʒϵͳ����
	//private String GoodsCode;		 //������Ʒ����
	private String GoodsName;		 //������Ʒ����
	private String OrderCode;		 //����code ��Դ��(pg_order)
	private String GoodsType;		 //1,�� 2,�� 3,��
	private String Number;			 //����
	private String UnitPrice;			 //����	
	private String TotalPrice;		 //�ܼ�	
	private String Status; 			 //����״̬(1��Ч, 0, δȷ��  -1,ɾ��)
	private String CreatedBy; 		 //������
	private String CreatedDate; 	 //����ʱ��
	private String ModifiedBy; 		 //�޸���
	private String ModifiedDate; 	 //�޸�ʱ��	
	
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
