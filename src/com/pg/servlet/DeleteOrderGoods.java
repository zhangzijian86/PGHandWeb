package com.pg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pg.daoimpl.DaoImpl;

@SuppressWarnings("serial")
public class DeleteOrderGoods extends HttpServlet {
	
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
		String GoodsID=request.getParameter("GoodsID");
		String GoodsName=request.getParameter("GoodsName");		
		System.out.println("==DeleteOrderGoods==GoodsID======"+GoodsID); 
		System.out.println("==DeleteOrderGoods==GoodsName======"+GoodsName); 
		if(GoodsID!=null&&!GoodsID.equals("")){
			DaoImpl daoImpl=new DaoImpl();
			int flag=daoImpl.DeleteOrderGoods(GoodsID,GoodsName);
			if(flag<0){
				out.write("error");		
			}else{
				out.write("ok");
			}
		}else{
			out.write("error");		
		}
		out.flush();
		out.close();
	}
}
