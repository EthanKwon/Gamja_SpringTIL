package com.example.Spring02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	//URL pattern mapping 으로 get이나 post 방식 모두 사용 가능
	@RequestMapping("/")
	public String main(Model model) {
		//Model : 데이터의 담을 그릇 역활, map(키,값)
		//model.addAttribute("변수","값")
		model.addAttribute("message","저의 홈페이지 입니다.");
		return "main";
	}
	
	@RequestMapping(value="gugu.do", method=RequestMethod.GET)
	public String gogo(int dan, Model model) {
		String result="";
		for(int i=1; i<=9; i++) {
			result += dan + "X" + i + "=" + (dan*i) + "<br>";
		}
		model.addAttribute("result",result);
		return "test/gugudan";
	}

}