package com.example.Spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String main(Model model) {
		//Model : 데이터의 담을 그릇 역활, map(키,값)
		//model.addAttribute("변수","값")
		model.addAttribute("message","저의 홈페이지 입니다.");
		return "main";
		
	}

}
