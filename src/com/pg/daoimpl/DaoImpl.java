package com.pg.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pg.bean.Pg_goods;
import com.pg.bean.Pg_order;
import com.pg.bean.Pg_order_goods;
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
	   					"pg_order where status = 1 "+ strTmp +" order by  ModifiedDate desc limit ?, ?");
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
	   					"select GoodsID,GoodsName,GoodsType,"+
	   					"Number,UnitPrice,Unit,Status,"+
	   					"CreatedBy,CreatedDate,ModifiedBy,ModifiedDate from "+ 
	   					"pg_goods where status = 1 "+ strTmp +" order by  ModifiedDate desc limit ?, ?");
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
	  
		public int DeleteGoods(String GoodsID){
			GetConn getConn=new GetConn();
			int i = 0;
			Connection conn=getConn.getConnection();
			try {
				PreparedStatement ps=conn.prepareStatement("update pg_goods "
						 + "set Status = -1 , ModifiedDate = now() "
		        	     + "where GoodsID = ?"
		        	     );
				ps.setString(1,GoodsID);	
				System.out.println("=DeleteGoods=sql="+ps.toString());
				i=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			getConn.closeconn(conn);
			return i;
		}
		
		public int DeleteOrderGoods(String GoodsID,String GoodsName){
			GetConn getConn=new GetConn();
			int i = 0;
			Connection conn=getConn.getConnection();
			try {
				PreparedStatement ps=conn.prepareStatement("update pg_order_goods "
						 + "set Status = -1 , ModifiedDate = now() "
		        	     + "where GoodsID = ? and GoodsName = '"+GoodsName+"'"
		        	     );
				ps.setString(1,GoodsID);	
				System.out.println("=DeleteOrderGoods=sql="+ps.toString());
				i=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			getConn.closeconn(conn);
			return i;
		}
		
		public int DeleteOrder(String OrderID){
			GetConn getConn=new GetConn();
			int i = 0;
			Connection conn=getConn.getConnection();
			try {
				PreparedStatement ps=conn.prepareStatement("update pg_order "
						 + "set Status = -1 , ModifiedDate = now() "
		        	     + "where OrderID = ?"
		        	     );
				ps.setString(1,OrderID);	
				System.out.println("=DeleteOrder=sql="+ps.toString());
				i=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			getConn.closeconn(conn);
			return i;
		}
		
		public int AddGoods(Pg_goods goods){
	    	GetConn getConn=new GetConn();
	    	int rows = 0;
			int i = 0;
			ResultSet rs = null;
			int flag = 0;
			int Number = 0;
			String GoodsID = "";
			Connection conn=getConn.getConnection();			
			try {
	   			PreparedStatement ps=conn.prepareStatement(
	   					"select GoodsID,GoodsName,GoodsType,Number from pg_goods "+ 
	   					"where Status =1 and GoodsName = '"+goods.getGoodsName()+"'");
	   			System.out.println("=AddGoods=sql1="+ps.toString());
	   			rs=ps.executeQuery();
	   			if(rs!=null){    		
	   				rs.last();
	   	    		rows = rs.getRow();
	   	    		rs.beforeFirst();
	   	    		if(rows>0)
	   		    	{	    	
	   	    			rs.next();
	   	    			flag = 1;
	   	    			Number = rs.getInt("Number");
	   	    			GoodsID  = rs.getString("GoodsID");
	   	    		}
	   			}	   			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Number = Number+Integer.parseInt(goods.getNumber());
			if(flag==0){
				try {
					PreparedStatement ps=conn.prepareStatement(
					"insert into pg_goods(GoodsID,GoodsName,GoodsType,Number,"+ 
					"UnitPrice,Unit,Status,CreatedBy,CreatedDate,ModifiedBy,ModifiedDate)"+
					"value(UUID(),'"+goods.getGoodsName()+"','"+goods.getGoodsType()+"',"+
					"'"+goods.getNumber()+"','"+goods.getUnitPrice()+"','"+goods.getUnit()+ 
					"','1','zzj',now(),'zzj',now());"
		        	);		
					System.out.println("=AddGoods=sql2="+ps.toString());
					i=ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}else{
				try {
					PreparedStatement ps=conn.prepareStatement(
					"update pg_goods set Number="+Number+","+
					"ModifiedDate = now() where GoodsID = '"+GoodsID+"'"			
		        	);		
					System.out.println("=AddGoods=sql3="+ps.toString());
					i=ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
			}
			getConn.closeconn(conn);
	    	return i;
	  }
		
		public List<Pg_goods> GetOneGoods(String GoodsID) 
	   	{
	   		int rows;
	   		GetConn getConn=new GetConn();
	   		ResultSet rs = null;
	   		Connection conn=getConn.getConnection();
	   		List<Pg_goods> list=new ArrayList<Pg_goods>();
	   		Pg_goods goods = null;  	

	   		try {
	   			PreparedStatement ps=conn.prepareStatement(
	   					"select GoodsID,GoodsName,GoodsType,"+
	   					"Number,UnitPrice,Unit,Status,"+
	   					"CreatedBy,CreatedDate,ModifiedBy,ModifiedDate from "+ 
	   					"pg_goods where status = 1 and GoodsID = '"+GoodsID+"'");   			
				System.out.println("=GetOneGoods=sql="+ps.toString());
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
		
		public int UpdateGoods(Pg_goods goods){
	    	GetConn getConn=new GetConn();
			int i = 0;
			Connection conn=getConn.getConnection();				
			try {
				PreparedStatement ps=conn.prepareStatement(
				"update pg_goods set "+ 
				"Number="+goods.getNumber()+","+
				"UnitPrice="+goods.getUnitPrice()+","+
				"Unit="+goods.getUnit()+","+
				"GoodsType="+goods.getGoodsType()+","+
				"ModifiedDate = now() "+ 
				"where GoodsID = '"+goods.getGoodsID()+"'"			
	        	);		
				System.out.println("=AddGoods=sql3="+ps.toString());
				i=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			getConn.closeconn(conn);
	    	return i;
	  }
		
		public int AddOrder(Pg_order order){
	    	GetConn getConn=new GetConn();
			int i = 0;
			Connection conn=getConn.getConnection();				
			try {
				PreparedStatement ps=conn.prepareStatement(
				"insert into pg_order(OrderID,OrderName,TotalPrice,"+ 
				"ActualPrice,Customer,CustomerAddress,Status,OrderDate,"+
				"CreatedBy,CreatedDate,ModifiedBy,ModifiedDate)"+
				"value('"+order.getOrderID()+"','"+order.getOrderName()+"','"+order.getTotalPrice()+"',"+
				"'"+order.getActualPrice()+"','"+order.getCustomer()+"','"+order.getCustomerAddress()+ 
				"','1',now(),'zzj',now(),'zzj',now());"			
	        	);		
				System.out.println("=AddOrder=sql1="+ps.toString());
				i=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				PreparedStatement ps=conn.prepareStatement(
				"UPDATE pg_goods a , pg_order_goods b "+
				"SET a.Number = a.Number - b.Number , "+
				"b.`Status` = 1 WHERE a.GoodsName = b.GoodsName "+
				"and b.`Status` != -1 and b.OrderID = '"+order.getOrderID()+"'"			
	        	);		
				System.out.println("=AddOrder=sql2="+ps.toString());
				i=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}			

			getConn.closeconn(conn);
	    	return i;
	  }
		
		public int AddOrderGoods(String OrderID,String GoodsName,String Number){
	    	GetConn getConn=new GetConn();
	    	int rows = 0;
			int i = 0;
			ResultSet rs = null;
			int flag = 0;
			int hasNumber = 0;
			
			String GoodsType = "";
			String UnitPrice = "";
			float TotalPrice  = 0;
			String Unit = "";
			Connection conn=getConn.getConnection();			
			try {
	   			PreparedStatement ps=conn.prepareStatement(
	   					"select GoodsID,GoodsName,GoodsType,Number,UnitPrice,Unit from pg_order_goods "+ 
	   		   			"where Status !=-1 and GoodsName = '"+GoodsName+"' and OrderID = '"+OrderID+"'");
	   			System.out.println("=AddOrderGoods=sql0="+ps.toString());
	   			rs=ps.executeQuery();
	   			if(rs!=null){    		
	   				rs.last();
	   	    		rows = rs.getRow();
	   	    		rs.beforeFirst();
	   	    		if(rows>0)
	   		    	{	    	
	   	    			return 10;
	   	    		}
	   			}	   			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
	   			PreparedStatement ps=conn.prepareStatement(
	   					"select GoodsID,GoodsName,GoodsType,Number,UnitPrice,Unit from pg_goods "+ 
	   					"where Status =1 and GoodsName = '"+GoodsName+"'");
	   			System.out.println("=AddOrderGoods=sql1="+ps.toString());
	   			rs=ps.executeQuery();
	   			if(rs!=null){    		
	   				rs.last();
	   	    		rows = rs.getRow();
	   	    		rs.beforeFirst();
	   	    		if(rows>0)
	   		    	{	    	
	   	    			rs.next();
	   	    			hasNumber = rs.getInt("Number");	 
	   		    		GoodsType  = rs.getString("GoodsType");
	   		    		UnitPrice = rs.getString("UnitPrice");
	   		    		Unit = rs.getString("Unit");
	   		    		TotalPrice = (Float.parseFloat(UnitPrice)*Integer.parseInt(Number));
	   	    			flag = 1;
	   	    		}
	   			}	   			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(flag == 0){
				return 5;
			}else{
				if(hasNumber<Integer.parseInt(Number)){
					return 56;
				}else{
					try {
						PreparedStatement ps=conn.prepareStatement(
						"insert into pg_order_goods (GoodsID,"+
						"GoodsName,OrderID,GoodsType,Number,UnitPrice,TotalPrice,"+
						"Status,CreatedBy,CreatedDate,ModifiedBy,ModifiedDate,Unit)"+
						"value (UUID(),'"+GoodsName+"','"+OrderID+"','"+GoodsType+"',"+ 
						"'"+Number+"','"+UnitPrice+"','"+TotalPrice+"','0',"+ 
						"'zzj',now(),'zzj',now(),'"+Unit+"');"			
			        	);		
						System.out.println("=AddOrderGoods=sql3="+ps.toString());
						i=ps.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			getConn.closeconn(conn);
			return i;
		}
		
		
		  public List<Pg_order_goods> GetOrderGoods(String OrderID) 
		   	{
		   		int rows;
		   		GetConn getConn=new GetConn();
		   		ResultSet rs = null;
		   		Connection conn=getConn.getConnection();
		   		List<Pg_order_goods> list=new ArrayList<Pg_order_goods>();
		   		Pg_order_goods goods = null;
		   		try {
		   			PreparedStatement ps=conn.prepareStatement(
		   					"select GoodsID,GoodsName,GoodsType,"+
		   					"Number,UnitPrice,Unit,Status,"+
		   					"CreatedBy,CreatedDate,ModifiedBy,ModifiedDate,TotalPrice,OrderID from "+ 
		   					"pg_order_goods where status !=-1 and OrderID = '"+OrderID+"' order by  ModifiedDate desc ");
		   			System.out.println("=GetOrderGoods=sql="+ps.toString());
		   			rs=ps.executeQuery();
		   			if(rs!=null){    		
		   	    		rs.last();
		   	    		rows = rs.getRow();
		   	    		rs.beforeFirst();
		   	    		for(int i=0;i<rows;i++)
		   		    	{	    			
		   		    		rs.next();
		   		    		goods = new Pg_order_goods();
		   		    		goods.setGoodsID(rs.getString("GoodsID"));
		   		    		goods.setGoodsName(rs.getString("GoodsName"));
		   		    		goods.setGoodsType(rs.getString("GoodsType"));	 
		   		    		goods.setNumber(rs.getString("Number"));		   		    		
		   		    		goods.setUnitPrice(rs.getString("UnitPrice"));
		   		    		goods.setUnit(rs.getString("Unit"));	 
		   		    		goods.setStatus(rs.getString("Status"));	 
		   		    		goods.setTotalPrice(rs.getString("TotalPrice"));	 
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
		  
		  public List<Pg_order> GetOneOrder(String OrderID) 
		   	{
		   		int rows;
		   		GetConn getConn=new GetConn();
		   		ResultSet rs = null;
		   		Connection conn=getConn.getConnection();
		   		List<Pg_order> list=new ArrayList<Pg_order>();
		   		Pg_order porder = null;
		   		try {
		   			PreparedStatement ps=conn.prepareStatement(
		   					"select OrderID,OrderName,TotalPrice,ActualPrice,"+
		   					"Customer,CustomerAddress,Status,OrderDate,CreatedBy,"+
		   					"CreatedDate,ModifiedBy,ModifiedDate from "+ 
		   					"pg_order where status = 1 and OrderID = '"+ OrderID +"'");		   			
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
}
