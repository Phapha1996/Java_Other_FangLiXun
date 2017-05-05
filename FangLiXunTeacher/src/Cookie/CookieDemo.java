package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CookieDemo extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("您上次访问的时间为：");
		
		//获得用户的时间cookie
		Cookie[] cookies = request.getCookies();		//得到用户的所有cookie
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("lastAccessTime")){  
				long cookieValue = Long.parseLong(cookies[i].getValue());			//转化成毫秒值
				Date date = new Date(cookieValue);				//直接设置时间
				out.println(date.toLocaleString());				//中国格式
			}
		}
		
	
		//给用户送回最新的访问时间
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");	//构造一个cookie
		cookie.setMaxAge(1*24*60*60);		//cookie的存活时间
		cookie.setPath("/MyWebProject");	//cookie回送路径
		response.addCookie(cookie);			//给IE打Cookie
		
		
		out.flush();
		out.close();
		
		
		
		
		/**
		 * public Cookie(String name ,String value)
		 * setValue(),getValue()得到cookie的值
		 * setMaxAge(),getMaxAge()设置或者得到有效期
		 * setPath(),getPath()设置cookie的有效目录，当访问这个目录下的资源时候，浏览器都会带着cookie去访问
		 * setDomain(),getDomain()
		 * getName()得到cookie的名字
		 * 
		 * */
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

}
