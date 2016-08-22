package com.chj;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UrlPathHelper;

@Controller
public class RootController {

	@Autowired
	UrlPathHelper urlHelper;

	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		return "redirect:/swagger-ui.html";
	}
}
