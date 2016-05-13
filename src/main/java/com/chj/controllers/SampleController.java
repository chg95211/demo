package com.chj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chj.common.settings.DataSourceSettings;

@Controller
public class SampleController {
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	DataSourceSettings dataSourceSettings;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		System.out.println(applicationContext.getBean(DataSourceProperties.class));
		System.out.println(dataSourceSettings);
		System.out.println(dataSourceSettings.getType());
		return "Hello World!";
	}
	
	@RequestMapping("/aaa/a1")
	@ResponseBody
	String a1() {
		return "aaa1!";
	}
	
	@RequestMapping("/aaa/a2")
	@ResponseBody
	String a2() {
		return "aaa2!";
	}
	
	@RequestMapping("/bbb/b1")
	@ResponseBody
	String b1() {
		return "bbb1!";
	}
	
	@RequestMapping("/bbb/b2")
	@ResponseBody
	String b2() {
		return "bbb2!";
	}
	
	@RequestMapping("/ccc/c1")
	@ResponseBody
	String c1() {
		return "ccc1!";
	}
}
