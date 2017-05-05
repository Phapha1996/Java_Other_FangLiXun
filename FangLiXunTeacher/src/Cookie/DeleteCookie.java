package Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//删除cookie
public class DeleteCookie extends HttpServlet {




	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		cookie.setMaxAge(0);
		cookie.setPath("/MyWebProject");
		response.addCookie(cookie);删除cookie的核心思想就是serMaxAge（0）*/
		
		response.sendRedirect("/MyWebProject/servlet/CookieDemo");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
