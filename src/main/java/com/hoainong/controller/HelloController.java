package com.hoainong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {

	@GetMapping("/HelloWord")
	public String index(Model model) {
		String message = "Hello Word";
		model.addAttribute("message", message);
		return "index";
	}
}
