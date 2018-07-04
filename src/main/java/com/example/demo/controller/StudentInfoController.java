package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/studentInfo/")
public class StudentInfoController {

	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("str","add model demo");
		return "index";
	}
}
