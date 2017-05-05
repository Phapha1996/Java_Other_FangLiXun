package fage_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyfirstServlet extends HttpServlet {

	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		res.getOutputStream().write("·¢¸ç".getBytes());
		
	}
}
