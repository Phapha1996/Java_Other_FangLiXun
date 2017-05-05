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
//��ʾ�û������servlet
public class CookieDemo2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		Book book = (Book)Db.getAll().get(id);
		
		out.print("��Ŀ������"+book.getId()+"<br>");
		out.print("��Ŀ���֣�"+book.getName()+"<br>");
		out.print("��Ŀ���ߣ�"+book.getAuthor()+"<br>");
		out.print("��Ŀ��飺"+book.getDescription()+"<br>");
		
		
		
		//����cookieд����������л���
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
	
		//������ε��,Ҳ����֮ǰû��cookie������һ�����bookHistory == null       1        1
		if(bookHistory==null){
			return id;
		}
		
		//�ڶ������bookHistory ==2,5,1		1		1,2,5
		LinkedList<String> list = new LinkedList(Arrays.asList(bookHistory.split("\\,")));
		
		/*if(list.contains(id)){
			list.remove(id);
			list.addFirst(id);
		}
		else{
			//���������bookHistory == 2,5,1      1       1,2,5
			if(list.size()>=3){						//����洢���б���������ˣ�ֱ��ȥ�����һ�����ڱ�ǰ�����һ��
				list.removeLast();
				list.addFirst(id);
			}
			else{
				//���������
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
