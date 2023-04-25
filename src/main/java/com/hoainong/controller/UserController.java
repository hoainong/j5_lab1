package com.hoainong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class UserController {
	@GetMapping("/read-info")
	public String readInforGet( HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Cookie[] cookies = request.getCookies();
		String userCookieValue = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("username")) {
				userCookieValue = cookie.getValue();
				break;
			}
		}
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("User cookie value: " + userCookieValue);
		return "indexUser";
	}
	@PostMapping("/read-info")
	public String readInforPost( HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userCookieValue = "cookie name is user";
		Cookie userCookie = new Cookie("user", userCookieValue);
		Cookie[] cookies = request.getCookies();
		
		
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName());
			if (cookie.getName().equals("user")) {
				userCookieValue = cookie.getValue();
				break;
			}
		}
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("User cookie value: " + userCookieValue);
		return "indexUser";
	}
}
