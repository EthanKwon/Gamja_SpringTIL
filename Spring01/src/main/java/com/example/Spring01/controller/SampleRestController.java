package com.example.Spring01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring01.model.dto.ProductDTO;

@RestController
public class SampleRestController {
	
	@ResponseBody
	@RequestMapping("test/doF")
	public ProductDTO doF() {
		return new ProductDTO("세탁기",500000);
		
	}

}
