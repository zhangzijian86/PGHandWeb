package com.pg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pg.bean.Pg_order;
import com.pg.daoimpl.DaoImpl;

@SuppressWarnings("serial")
public class GetOneOrder extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	    PrintWriter out=response.getWriter();
		String OrderID=request.getParameter("OrderID");		
		System.out.println("====GetAllOrders====OrderID======"+OrderID);
		DaoImpl userDaoImpl=new DaoImpl();
		List<Pg_order> list=userDaoImpl.GetOneOrder(OrderID);
    	if(list!=null&&list.size()>=0){			
			Gson gson=new Gson();
			String jsonstring=gson.toJson(list);
			out.write(jsonstring);
		}else{
			out.write("error");
		}	    
		out.flush();
		out.close();
	}
}
