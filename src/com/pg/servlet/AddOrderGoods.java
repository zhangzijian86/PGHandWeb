package com.pg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.pg.daoimpl.DaoImpl;
import com.pg.bean.Pg_goods;

@SuppressWarnings("serial")
public class AddOrderGoods extends HttpServlet {
	
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
	    Gson gson=new Gson();
		String OrderID=request.getParameter("OrderID");
		String GoodsName=request.getParameter("GoodsName");
		String Number=request.getParameter("Number");
		if(GoodsName!=null){
			GoodsName  = new String(GoodsName.getBytes("ISO-8859-1"), "UTF-8");
		}
		if(Number!=null){
			Number  = new String(Number.getBytes("ISO-8859-1"), "UTF-8");
		}

		DaoImpl userDaoImpl=new DaoImpl();
		int flag=userDaoImpl.AddOrderGoods(OrderID,GoodsName,Number);
		if(flag<0){
			out.write("error");		
		}else if(flag==5){
			out.write("nogoods");		
		}else if(flag==56){
			out.write("notenough");
		}

		out.flush();
		out.close();
	}
}
