package com.pg.bean;

public class Pg_order {
	
	private String OrderID;            //����ϵͳ����
	//private String OrderCode;          //��������
	private String OrderName;          //��������
	private String TotalPrice;         //�����ܼ�
	private String ActualPrice;         //����ʵ���ܼ�
	private String Customer;		   //�ͻ�����	
	private String CustomerAddress;    //�ͻ���ַ
	private String Status; 			   //����״̬(1��Ч��-1ɾ��)
	private String OrderDate;          //����ʱ��
	private String CreatedBy; 		   //������
	private String CreatedDate; 	   //����ʱ��
	private String ModifiedBy; 		   //�޸���
	private String ModifiedDate; 	   //�޸�ʱ��
	
	//OrderID,OrderCode,OrderName,TotalPrice,
	//Customer,CustomerAddress,Status,CreatedBy,
	//CreatedDate,ModifiedBy,ModifiedDate
	
	public String getOrderID() {
		return OrderID;
	}
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}
	//public String getOrderCode() {
	//	return OrderCode;
	//}
	//public void setOrderCode(String orderCode) {
	//	OrderCode = orderCode;
	//}
	public String getOrderName() {
		return OrderName;
	}
	public void setOrderName(String orderName) {
		OrderName = orderName;
	}
	public String getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		TotalPrice = totalPrice;
	}
	public String getActualPrice() {
		return ActualPrice;
	}
	public void setActualPrice(String actualPrice) {
		ActualPrice = actualPrice;
	}
	public String getCustomer() {
		return Customer;
	}
	public void setCustomer(String customer) {
		Customer = customer;
	}
	public String getCustomerAddress() {
		return CustomerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
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
