package com.neuedu.print.controller;

import org.springframework.test.annotation.ExpectedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.print.bean.ResultBean;

@ControllerAdvice(basePackages = { "com.neuedu.print", "com.neuedu.print.controller",
		"com.neuedu.print.service.impl", "com.neuedu.print.dao" })
public class GlobalExceptionController {
	
//	@ExceptionHandler(RuntimeException.class)
//	public String reHanler() {
//		// 方法1：返回特定的页面
//		return "error";
//	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ResultBean reHanler(Exception ex) {
		// 方法2：返回json
		ResultBean resultBean = new ResultBean(500, false, ex.getMessage(), ex);
		return resultBean;
	}
}
