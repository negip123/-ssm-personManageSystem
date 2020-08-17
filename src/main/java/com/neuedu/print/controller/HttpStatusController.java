package com.neuedu.print.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HttpStatusController {
	
	@RequestMapping(value = {"error/404"} ,method = RequestMethod.GET)
	public String left() {
		return "error/404";
	}
}
