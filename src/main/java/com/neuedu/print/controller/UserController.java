package com.neuedu.print.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.print.model.User;
import com.neuedu.print.service.UserService;

@Controller
@RequestMapping("client")
public class UserController {
	    @Autowired
	    private UserService userService;
	 
	    @ResponseBody
	    @RequestMapping("/regist")
	    public String regist(User user){
	        userService.regist(user);
	        return "OK";
	    }
	    @RequestMapping("/login")
	    public String login(User user){
	        User userExist = userService.login(user);
	        if(userExist == null){
	            System.out.println("用户不存在!");
	            return "/regist";
	 
	        }else{
	            return "/index";
	        }
	    }
	}

