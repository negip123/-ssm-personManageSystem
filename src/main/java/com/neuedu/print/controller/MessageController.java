package com.neuedu.print.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.print.bean.ResultBean;
import com.neuedu.print.model.Message;

import com.neuedu.print.service.MessageService;

@Controller
	public class MessageController {
	
		@Autowired
		private MessageService messageService;
		/**
		 * 显示所有信息
		 * @param model
		 * @return
		 */
		@RequestMapping(value = "message/managerMessage", method = RequestMethod.GET)
		public String managerMessage(Model model) {
			// 调用部门信息业务逻辑对象，实现查询所有部门信息
			List<Message> message = messageService.selectAll();
			// 使用ResultBean封装数据
			ResultBean resultBean = new ResultBean(200, true, "查询所有部门信息成功~~~", message);
			// 向前端页面传递数据
			model.addAttribute("print", resultBean);
			return "message/managerMessage";
		}
		/**
		 * 带参查询
		 * @param id
		 * @param qq
		 * @param model
		 * @return
		 */
		@RequestMapping(value = "message/selectbylike", method = RequestMethod.GET)
		public String selectByLike(Integer id, Integer qq, Model model) {
			// 调用部门信息业务逻辑对象，根据id,name,type进行多条件组合模糊查询
			List<Message> message = messageService.selectByLike(id, qq);
			// 使用ResultBean封装数据
			ResultBean resultBean = new ResultBean(200, true, "据id,name,type进行多条件组合模糊查询成功~~~", message);
			// 向前端页面传递数据
			model.addAttribute("print", resultBean);
			return "message/managerMessage";
		} 
		
		@RequestMapping(value = "message/delete", method = RequestMethod.POST)
		@ResponseBody
		public ResultBean batchDelete(@RequestParam("ids[]")Integer[] ids) {
			//红色部分，是用来解决jQuery在传递数组时尝试序列化问题
//			for (Integer v : ids) {
//				System.out.print(v + "\t");
//			}
			boolean flag = messageService.batchDelete(ids);
			ResultBean resultBean = new ResultBean();
			if (flag) {
				// 删除成功
				resultBean.setCode(200);
				resultBean.setSuccessed(true);
				resultBean.setMessage("部门信息删除~~~");
			}else {
				// 删除失败
				resultBean.setCode(500);
				resultBean.setSuccessed(false);
				resultBean.setMessage("部门信息删除失败~~~");
			}
			return resultBean;
		}

		
}