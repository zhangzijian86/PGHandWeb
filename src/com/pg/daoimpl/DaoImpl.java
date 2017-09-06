package com.pg.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pg.bean.Pg_goods;
import com.pg.bean.Pg_order;
import com.pg.db.GetConn;

public class DaoImpl 
{
	
	public int getCount(String name,String Condition){   
    	String sql="select count(*) as pageCount from "+name+" "+Condition;   
    	System.out.println(sql);
    	int i=-1;   
    	GetConn getConn=new GetConn();
    	ResultSet rs = null;
    	Connection conn=getConn.getConnection();
    	try {
    		PreparedStatement ps=conn.prepareStatement(sql);
    		rs=ps.executeQuery();
    		if(rs!=null){    					
    			rs.next();  
    			i=rs.getInt("pageCount");  
    		}
    	} catch (SQLException e) {   
    		e.printStackTrace();   
    	}   
    	return i;   
    } 
	
	  public List<Pg_order> GetAllOrders(String OrderTmp,String currentPage,String eachPage) 
	   	{
	   		int rows;
	   		GetConn getConn=new GetConn();
	   		ResultSet rs = null;
	   		Connection conn=getConn.getConnection();
	   		List<Pg_order> list=new ArrayList<Pg_order>();
	   		Pg_order porder = null;
	   		String strTmp = "";
	   		if(OrderTmp!=null&&!OrderTmp.trim().equals("")){
	   			strTmp = strTmp + " and OrderName like '%"+OrderTmp+"%'";
	   		}
	   		try {
	   			PreparedStatement ps=conn.prepareStatement(
	   					"select OrderID,OrderName,TotalPrice,ActualPrice,"+
	   					"Customer,CustomerAddress,Status,OrderDate,CreatedBy,"+
	   					"CreatedDate,ModifiedBy,ModifiedDate from "+ 
	   					"pg_order where status = 1 "+ strTmp +" desc limit ?, ?");
	   			int intcurrentPage = Integer.parseInt(currentPage);
	   			int inteachPage = Integer.parseInt(eachPage);
	   			if(currentPage.equals("0")){
	   				ps.setInt(1, 0);
	   			}else{
	   				ps.setInt(1, (intcurrentPage-1)*inteachPage);
	   			}
	   			ps.setInt(2, inteachPage);
	   			System.out.println("=GetAllOrders=sql="+ps.toString());
	   			rs=ps.executeQuery();
	   			if(rs!=null){    		
	   	    		rs.last();
	   	    		rows = rs.getRow();
	   	    		rs.beforeFirst();
	   	    		for(int i=0;i<rows;i++)
	   		    	{	    			
	   		    		rs.next();
	   		    		porder = new Pg_order();
	   		    		porder.setOrderID(rs.getString("OrderID"));
	   		    		porder.setOrderName(rs.getString("OrderName"));
	   		    		porder.setTotalPrice(rs.getString("TotalPrice"));	 
	   		    		porder.setActualPrice(rs.getString("ActualPrice"));		   		    		
	   		    		porder.setCustomer(rs.getString("Customer"));
	   		    		porder.setCustomerAddress(rs.getString("CustomerAddress"));	 
	   		    		porder.setStatus(rs.getString("Status"));	 
	   		    		porder.setOrderDate(rs.getString("OrderDate"));
			    		porder.setCreatedBy(rs.getString("CreatedBy"));
			    		porder.setCreatedDate(rs.getString("CreatedDate"));
			    		porder.setModifiedBy(rs.getString("ModifiedBy"));
			    		porder.setModifiedDate(rs.getString("ModifiedDate"));
	   		    		list.add(porder);
	   		    	}
	   			}
	   		} catch (SQLException e) {
	   			e.printStackTrace();
	   		}
	   		return list;
	   	}
	  
	  public List<Pg_goods> GetAllGoods(String GoodsTmp,String currentPage,String eachPage) 
	   	{
	   		int rows;
	   		GetConn getConn=new GetConn();
	   		ResultSet rs = null;
	   		Connection conn=getConn.getConnection();
	   		List<Pg_goods> list=new ArrayList<Pg_goods>();
	   		Pg_goods goods = null;
	   		String strTmp = "";
	   		if(GoodsTmp!=null&&!GoodsTmp.trim().equals("")){
	   			strTmp = strTmp + " and GoodsName like '%"+GoodsTmp+"%'";
	   		}
	   		try {
	   			PreparedStatement ps=conn.prepareStatement(
	   					"GoodsID,GoodsName,GoodsType,"+
	   					"Number,UnitPrice,Unit,Status,"+
	   					"CreatedBy,CreatedDate,ModifiedBy,ModifiedDate from "+ 
	   					"pg_goods where status = 1 "+ strTmp +" desc limit ?, ?");
	   			int intcurrentPage = Integer.parseInt(currentPage);
	   			int inteachPage = Integer.parseInt(eachPage);
	   			if(currentPage.equals("0")){
	   				ps.setInt(1, 0);
	   			}else{
	   				ps.setInt(1, (intcurrentPage-1)*inteachPage);
	   			}
	   			ps.setInt(2, inteachPage);
	   			System.out.println("=GetAllGoods=sql="+ps.toString());
	   			rs=ps.executeQuery();
	   			if(rs!=null){    		
	   	    		rs.last();
	   	    		rows = rs.getRow();
	   	    		rs.beforeFirst();
	   	    		for(int i=0;i<rows;i++)
	   		    	{	    			
	   		    		rs.next();
	   		    		goods = new Pg_goods();
	   		    		goods.setGoodsID(rs.getString("GoodsID"));
	   		    		goods.setGoodsName(rs.getString("GoodsName"));
	   		    		goods.setGoodsType(rs.getString("GoodsType"));	 
	   		    		goods.setNumber(rs.getString("Number"));		   		    		
	   		    		goods.setUnitPrice(rs.getString("UnitPrice"));
	   		    		goods.setUnit(rs.getString("Unit"));	 
	   		    		goods.setStatus(rs.getString("Status"));	 
	   		    		goods.setCreatedBy(rs.getString("CreatedBy"));
	   		    		goods.setCreatedDate(rs.getString("CreatedDate"));
	   		    		goods.setModifiedBy(rs.getString("ModifiedBy"));
	   		    		goods.setModifiedDate(rs.getString("ModifiedDate"));
	   		    		list.add(goods);
	   		    	}
	   			}
	   		} catch (SQLException e) {
	   			e.printStackTrace();
	   		}
	   		return list;
	   	}
}
