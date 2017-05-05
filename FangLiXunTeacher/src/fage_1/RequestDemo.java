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
//�õ�request�����·�������ֵ
public class RequestDemo extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//��ʽ1���õ�����ֵ
		String username = request.getParameter("user");
		if(username!=null&&!username.trim().equals(""))
		System.out.println("user:"+username);
		
		
		//��ʽ2,�õ�������ֵ�ƥ��ֵ
		Enumeration e = request.getParameterNames(); 
		while(e.hasMoreElements()){
			String name = (String) e.nextElement();
			if(name!=null&&!name.trim().equals(" ")){
			String value = request.getParameter(name);
			System.out.println(name+":"+value);
			}
		}
		
		
		//��ʽ3,���ͬһ�����ֵı�Ԫ�صĶ��ֵ
		String [] values = request.getParameterValues("username");
		for(int i=0;values!=null&&i<values.length;i++){
			System.out.println(values[i]);
		}
		
		
		//��ʽ4����map���ϣ������Ž�Bean
		Map<String,String[]> map = request.getParameterMap();
		Bean user = new Bean();
		try{
		BeanUtils.populate(user,map);
		}catch(Exception e2){
			e2.printStackTrace();
		}
		System.out.println(user);
		
		
		//����get�����µ���������
		String index = request.getParameter("username");
		String username2 = new String(index.getBytes("iso8859-1"),"utf-8");
	}

}
