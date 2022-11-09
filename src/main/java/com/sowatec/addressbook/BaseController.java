package com.sowatec.addressbook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller

public class BaseController {
	
	@GetMapping("/index")
	
	public String index(Model model) {
		
		model.addAttribute("title", "Hello World");
		log.info("Test");
		
		
		return "/index";
	}
	
}
