package com.neuedu.print.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.print.bean.ResultBean;
import com.neuedu.print.model.Orders;
import com.neuedu.print.service.OrdersService;
	/**
	 * 信息控制器：响应用户请求，完成信息的显示，查询 ，新增，修改，删除
	 * @author steve
	 *
	 */
	@Controller
	public class OrdersController {
		
		@Autowired
		private OrdersService ordersService;
		/**
		 * 显示所有信息
		 * @param model
		 * @return
		 */
		@RequestMapping(value = "order/managerOrders", method = RequestMethod.GET)
		public String managerOrders(Model model) {
			// 调用部门信息业务逻辑对象，实现查询所有部门信息
			List<Orders> orders = ordersService.selectAll();
			// 使用ResultBean封装数据
			ResultBean resultBean = new ResultBean(200, true, "查询所有信息成功~~~",orders);
			// 向前端页面传递数据
			model.addAttribute("print", resultBean);
			return "order/managerOrders";
		}
		/**
		 * 查询
		 * @param id
		 * @param orderno
		 * @param model
		 * @return
		 */
		@RequestMapping(value = "order/selectbylike", method = RequestMethod.GET)
		public String selectByLike(Integer id, Integer orderno, Model model) {
			// 调用部门信息业务逻辑对象，根据id,name,type进行多条件组合模糊查询
			List<Orders> orders = ordersService.selectByLike(id, orderno);
			// 使用ResultBean封装数据
			ResultBean resultBean = new ResultBean(200, true, "据id,orderno进行多条件组合模糊查询成功~~~", orders);
			// 向前端页面传递数据
			model.addAttribute("print", resultBean);
			return "order/managerOrders";
		} 
		/**
		 * 修改
		 * @param id
		 * @param model
		 * @return
		 */
		@RequestMapping(value = "order/updateOrders", method = RequestMethod.GET)
		public String updataOrders(Integer id,Model model) {
			Orders orders = ordersService.selectById(id);
			model.addAttribute("rd", new ResultBean(200, true, "根据id查询信息成功",orders));
			return "order/updateOrders";
		}
		/**
		 * 
		 * @param id
		 * @param orderno
		 * @param paytime
		 * @param paymoney
		 * @param paystate
		 * @param receiveaddress
		 * @param receivername
		 * @param receiverphone
		 * @param remark
		 * @return
		 * @throws ParseException
		 */
		@RequestMapping(value = "order/update",method = RequestMethod.POST)
		@ResponseBody
		public ResultBean update(Integer id, String orderno, String paytime, String paymoney, String paystate, String receiveaddress, String receivername, String receiverphone, String remark) throws ParseException {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Orders orders = new Orders(id,Integer.parseInt(orderno), sdf.parse(paytime),Integer.parseInt(paymoney),Integer.parseInt(paystate),receiveaddress,receivername,Integer.parseInt(receiverphone),remark);
			boolean flag =ordersService.update(orders);
			ResultBean resultBean = new ResultBean();
			if (flag) {
				// 新增成功			
				resultBean.setCode(200);
				resultBean.setSuccessed(true);
				resultBean.setMessage("用户信息修改成功~~~");
			}else {
				// 新增失败
				resultBean.setCode(500);
				resultBean.setSuccessed(false);
				resultBean.setMessage("用户信息修改失败~~~");
			}
			return resultBean;
		}
		/**
		 * 
		 * @param ids
		 * @return
		 */
		@RequestMapping(value = "order/delete", method = RequestMethod.POST)
		@ResponseBody
		public ResultBean batchDelete(@RequestParam("ids[]")Integer[] ids) {
			//红色部分，是用来解决jQuery在传递数组时尝试序列化问题
//			for (Integer v : ids) {
//				System.out.print(v + "\t");
//			}
			boolean flag = ordersService.batchDelete(ids);
			ResultBean resultBean = new ResultBean();
			if (flag) {
				// 删除成功
				resultBean.setCode(200);
				resultBean.setSuccessed(true);
				resultBean.setMessage("信息删除~~~");
			}else {
				// 删除失败
				resultBean.setCode(500);
				resultBean.setSuccessed(false);
				resultBean.setMessage("信息删除失败~~~");
			}
			return resultBean;
		}

	}

