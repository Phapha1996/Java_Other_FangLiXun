package fage_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCount extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		if(this.getServletContext().getAttribute("count")==null){
			CountBean count = new CountBean();	
			count.setCount();
			this.getServletContext().setAttribute("count", count);
			request.getRequestDispatcher("/forward.jsp").forward(request, response);
			return;
		}
		else if(request.getSession().isNew()){
			CountBean count = (CountBean) this.getServletContext().getAttribute("count");
			count.setCount();
			this.getServletContext().setAttribute("count", count);
			request.getRequestDispatcher("/forward.jsp").forward(request, response);
			return;
		}
	
		
		request.getRequestDispatcher("/forward.jsp").forward(request, response);
		
		
	}

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
