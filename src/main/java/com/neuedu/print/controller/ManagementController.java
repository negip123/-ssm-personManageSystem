package com.neuedu.print.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.print.bean.ResultBean;
import com.neuedu.print.model.Management;
import com.neuedu.print.service.ManagementService;

/**
 * 管理员控制器ManagementController：显示登录页面、登录、注销
 *
 */
@Controller
public class ManagementController {
	@Autowired
	private ManagementService managementService;
	
	@RequestMapping(value = {"admin/left"} ,method = RequestMethod.GET)
	public String left() {
		return "admin/left";
	}
	
	@RequestMapping(value = {"admin/content"} ,method = RequestMethod.GET)
	public String content() {
		return "admin/content";
	}
	@RequestMapping(value = "check_login",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean checkLogin(String name,String password,HttpServletRequest request) {
		boolean flag = managementService.login(name, password);
		ResultBean resultBean = new ResultBean();
		if (flag) {
			resultBean.setCode(200);
			resultBean.setSuccessed(true);
			resultBean.setMessage("登录成功~~~");
			//成功后，将登录信息写入session
			// 建议重新查一下对象信息
			Management m = new Management();
			m.setName(name);
			resultBean.setData(m);
			request.getSession().setAttribute("rm", resultBean);
		}else {
			resultBean.setCode(500);
			resultBean.setSuccessed(false);
			resultBean.setMessage("登录名称或登录密码不正确，登录失败~~~");
			request.getSession().removeAttribute("rm");
		}
		return resultBean;
	}
	
	@RequestMapping(value = "admin/exit",method = RequestMethod.GET)
	public String exit(HttpSession session) {
		// 移除session内容
		session.removeAttribute("rm");
		return "admin/login";
	}

}
