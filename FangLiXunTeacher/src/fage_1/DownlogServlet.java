package fage_1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownlogServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = this.getServletContext().getRealPath("/¶¯Ì¬Í¼.gif");
		String filename = path.substring(path.lastIndexOf("\\")+1);
		response.setHeader("content-disposition", "attachment;filename="+filename);
		
		InputStream in = null;
		OutputStream out = null;
		
		try{
			
			in = new FileInputStream(path); 
			int len = 0;
			byte buffer[] = new byte[2014];
			out = response.getOutputStream();
			while((len=in.read(buffer))>0){
				out.write(buffer, 0, len);
			}
		}
		finally{
			try{ 
			  if(in!=null){
				in.close();
			      }
	        	}catch(Exception e){
	        		e.printStackTrace();
	        	}
			if(out!=null){
				try{
					out.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
				
			
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		System.out.print("yes");
		
	}



}
