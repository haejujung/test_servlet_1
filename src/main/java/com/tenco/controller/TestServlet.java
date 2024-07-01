package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TestServlet() {
        super();
      
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		String htmlFilePath = "/todoListPage.html";
		InputStream inputStream = getServletContext().getResourceAsStream(htmlFilePath);
		if(inputStream == null) {
			response.getWriter().write("<html><body>해당 파일을 찾을 수 없음 404</body></html>");
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		StringBuffer htmlContent = new StringBuffer();
		String line;
		while((line = reader.readLine()) != null) {
			htmlContent.append(line);
		}
		
		reader.close();
		response.getWriter().write(htmlContent.toString());
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
