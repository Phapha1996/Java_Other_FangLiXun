package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//显示用户点入的servlet
public class CookieDemo2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		Book book = (Book)Db.getAll().get(id);
		
		out.print("项目索引："+book.getId()+"<br>");
		out.print("项目名字："+book.getName()+"<br>");
		out.print("项目作者："+book.getAuthor()+"<br>");
		out.print("项目简介："+book.getDescription()+"<br>");
		
		
		
		//构建cookie写给浏览器进行缓存
		String cookieValue = buildCookie(id,request);
		Cookie cookie = new Cookie("bookHistory",cookieValue);
		cookie.setMaxAge(1*30*24*60*60);
		cookie.setPath("/MyWebProject");
		response.addCookie(cookie);
		
	}

	
	private String buildCookie(String id,HttpServletRequest request) {
	
		/*bookHistory == null       1        1
		 *bookHistory == 2,5,1      1       1,2,5
		 *bookHistory == 2,5,4 		1  		1,2,5
		 *bookHistory == 2,5 		1		1,2,5
		 * */
		
		String bookHistory = null;
		Cookie cookies[] = request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("bookHistory"));
			bookHistory = cookies[i].getValue();
		}
	
		//如果初次点击,也就是之前没有cookie；即第一种情况bookHistory == null       1        1
		if(bookHistory==null){
			return id;
		}
		
		//第二种情况bookHistory ==2,5,1		1		1,2,5
		LinkedList<String> list = new LinkedList(Arrays.asList(bookHistory.split("\\,")));
		
		/*if(list.contains(id)){
			list.remove(id);
			list.addFirst(id);
		}
		else{
			//第三种情况bookHistory == 2,5,1      1       1,2,5
			if(list.size()>=3){						//如果存储的列表大于三个了，直接去掉最后一个，在表前加入第一个
				list.removeLast();
				list.addFirst(id);
			}
			else{
				//第四种情况
				list.addFirst(id);
			}*/
		
		
		if(list.contains(id)){
			list.remove(id);
		}
		else{
			if(list.size()>=3){						
				list.removeLast();
			}	
		}
		list.addFirst(id);
		
		
		StringBuffer sb = new StringBuffer();
		for(String bid:list){
			sb.append(bid+",");
		}
		
		return sb.deleteCharAt(sb.length()-1).toString();							
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
