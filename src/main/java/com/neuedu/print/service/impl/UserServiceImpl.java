package com.neuedu.print.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.print.dao.UserMapper;
import com.neuedu.print.model.User;
import com.neuedu.print.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	    @Autowired
	    private UserMapper userMapper;

		@Override
		public void regist(User user) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public User login(String username, String password, HttpSession session) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public User login(User user) {
			// TODO Auto-generated method stub
			return null;
		}

		
	 
	   
	}


