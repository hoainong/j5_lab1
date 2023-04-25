package com.hoainong.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class Controller_B4_3 {
	@Autowired
	HttpSession session;
	@Autowired
	ServletContext application;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	
	@GetMapping("/sayHello")
	public String sayHelloGet(Model model) {
		//lấy giữ liệu lưu vào session
//		String username = request.getParameter("username");
//		
//		System.out.println(username);
//		session.setAttribute("username", username);
		
		 // Lưu dữ liệu vào application scope
        application.setAttribute("total", 10);
        
//        String message = "HELLO" + username;
//        model.addAttribute("message", message);

		return "sayHello";
	}
	@PostMapping("/sayHello")
	public String sayHelloPost(Model model) {
		//đọc giá trị từ session and application
		String username = request.getParameter("username");
//		String username = (String) session.getAttribute("username");
		int total = (int)application.getAttribute("total");
		
		
		//Tạo cookie chưa người dùng
//		Cookie cookie = new Cookie("username", username);
//		response.addCookie(cookie);
		
		//đặt gía trị của biến message và truyền vào jsp
		String message = " hello "+ username + " Bạn đã trúng " + total +" nghìn $ " ;
		
		 model.addAttribute("message", message);
		   Random rand = new Random();
		   int randomNumber = rand.nextInt(100) + 1;
		   System.out.println(randomNumber);
		 
		 application.setAttribute("total", total + randomNumber  );
		
		return "sayHello";
	}
	
	
	
}
