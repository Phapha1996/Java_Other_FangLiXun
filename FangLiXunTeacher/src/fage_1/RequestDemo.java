package fage_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
//得到request请求下发过来的值
public class RequestDemo extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//方式1，得到单个值
		String username = request.getParameter("user");
		if(username!=null&&!username.trim().equals(""))
		System.out.println("user:"+username);
		
		
		//方式2,得到多个名字的匹配值
		Enumeration e = request.getParameterNames(); 
		while(e.hasMoreElements()){
			String name = (String) e.nextElement();
			if(name!=null&&!name.trim().equals(" ")){
			String value = request.getParameter(name);
			System.out.println(name+":"+value);
			}
		}
		
		
		//方式3,获得同一个名字的表单元素的多个值
		String [] values = request.getParameterValues("username");
		for(int i=0;values!=null&&i<values.length;i++){
			System.out.println(values[i]);
		}
		
		
		//方式4，用map集合，将其存放进Bean
		Map<String,String[]> map = request.getParameterMap();
		Bean user = new Bean();
		try{
		BeanUtils.populate(user,map);
		}catch(Exception e2){
			e2.printStackTrace();
		}
		System.out.println(user);
		
		
		//处理get请求下的中文乱码
		String index = request.getParameter("username");
		String username2 = new String(index.getBytes("iso8859-1"),"utf-8");
	}

}
