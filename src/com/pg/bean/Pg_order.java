package com.pg.bean;

public class Pg_order {
	
	private String OrderID;            //订单系统编码
	//private String OrderCode;          //订单编码
	private String OrderName;          //订单名称
	private String TotalPrice;         //订单总价
	private String ActualPrice;         //订单实际总价
	private String Customer;		   //客户名称	
	private String CustomerAddress;    //客户地址
	private String Status; 			   //订单状态(1有效，-1删除)
	private String OrderDate;          //订单时间
	private String CreatedBy; 		   //创建人
	private String CreatedDate; 	   //创建时间
	private String ModifiedBy; 		   //修改人
	private String ModifiedDate; 	   //修改时间
	
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
