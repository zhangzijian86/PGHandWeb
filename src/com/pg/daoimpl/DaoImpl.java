package com.pg.daoimpl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.pg.bean.Pg_order;
import com.pg.db.GetConn;

public class DaoImpl 
{
	  public List<Pg_order> GetAllOrders(String UserTmp,String OrderTmp,String currentPage,String eachPage) 
	   	{
	   		int rows;
	   		GetConn getConn=new GetConn();
	   		ResultSet rs = null;
	   		Connection conn=getConn.getConnection();
	   		List<Pg_order> list=new ArrayList<Pg_order>();
	   		Pg_order porder = null;
	   		String strTmp = "";
	   		if(UserTmp!=null&&!UserTmp.trim().equals("")){
	   			strTmp = "and ( pg_order.CreatedBy = '"+UserTmp+"' or pg_user.username ='"+UserTmp+"')";
	   		}
	   		if(OrderTmp!=null&&!OrderTmp.trim().equals("")){
	   			strTmp = strTmp + " and (pg_order.Remark like '%"+OrderTmp+"%' or OrderCode like '%"+OrderTmp+"%')";
	   		}
	   		try {
	   			PreparedStatement ps=conn.prepareStatement(
	   					"select OrderID,OrderCode,OperationRemark,pg_order.Status,pg_order.Remark,FlowRemark,"
	   					+ "Price,pg_order.CreatedBy,pg_order.CreatedDate,pg_order.ModifiedBy,"
	   					+ "pg_order.ModifiedDate,pg_user.username "
	   					+ "from pg_order "
	   					+ "left join pg_user on pg_order.CreatedBy = pg_user.usercode "
	   					+ "where  pg_order.Status!=-1 "+ strTmp  					
	   					+ "order by pg_order.Status ,pg_order.ModifiedDate desc limit ?, ?");
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
	   		    		porder.setOrderCode(rs.getString("OrderCode"));
	   		    		porder.setStatus(rs.getString("Status"));	   		    		
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
}
