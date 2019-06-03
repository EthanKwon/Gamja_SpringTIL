package com.example.Spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.Spring01.model.dto.ProductDTO;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String main(Model model) {
		//Model : 데이터의 담을 그릇 역활, map(키,값)
		//model.addAttribute("변수","값")
		model.addAttribute("message","저의 홈페이지 입니다.");
		return "main";
		
	}
	
	@RequestMapping(value = "gugu.do", method=RequestMethod.GET)
	public String gugudan(int dan, Model model) {
		String result = "";
		for(int i=1;i<=9;i++) {
			result += dan + " X " + i + " = " + (dan*i) + "<br>";
		}
		model.addAttribute("result",result);
		return "test/gugudan";
	}
	
	@RequestMapping("test")
	public void test() {
		
	}
	
	@RequestMapping("test/doA")
	public String doA(Model model) {
		model.addAttribute("message","doA매핑을 통해 들어왔습니다.");
		return "test/doB";
	}
	
	@RequestMapping("test/doB")
	public void doB(Model model) {
	}
	
	@RequestMapping("test/doC")
	public ModelAndView doC() {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("product", new ProductDTO("샤프",1000));
		return new ModelAndView("test/doC","map",map);
	}

}
