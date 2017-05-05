package fage_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//¿ØÖÆä¯ÀÀÆ÷»º´æ
public class Expires extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setDateHeader("expires", System.currentTimeMillis()+1000*3600);   //»º´æÒ»Ð¡Ê±
		
		String data = "hahahahahahahahahaha";
		response.getWriter().println(data);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		
		
	}

}
