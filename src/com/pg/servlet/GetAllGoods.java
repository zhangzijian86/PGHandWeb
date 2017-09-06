package com.pg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pg.bean.Pg_goods;
import com.pg.bean.Pg_order;
import com.pg.daoimpl.DaoImpl;

@SuppressWarnings("serial")
public class GetAllGoods extends HttpServlet {
	
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
		String CurrentPage=request.getParameter("CurrentPage");
		String EachPage=request.getParameter("EachPage");
		String GoodsTmp=request.getParameter("GoodsTmp");
		if(GoodsTmp!=null){
			GoodsTmp = new String(GoodsTmp.getBytes("ISO-8859-1"), "UTF-8");
		}		 
		System.out.println("====GetAllOrders=============CurrentPage======"+CurrentPage);
		System.out.println("====GetAllOrders=============EachPage======"+EachPage);
		System.out.println("====GetAllOrders=============OrderTmp======"+GoodsTmp);
		DaoImpl userDaoImpl=new DaoImpl();
		List<Pg_goods> list=userDaoImpl.GetAllGoods(GoodsTmp,CurrentPage,EachPage);
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
