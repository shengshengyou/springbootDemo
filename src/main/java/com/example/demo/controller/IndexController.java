package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.StudentInfo;

@RestController
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping("index")
	public String index() {
		return "hello Springboot";
	}
	
	@RequestMapping("student/{id}/{name}")
	public StudentInfo show(@PathVariable Integer id,@PathVariable String name) {
		StudentInfo studentInfo=new StudentInfo();
		studentInfo.setId(id);
		studentInfo.setName(name);
		return studentInfo;
	}
}
