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
import com.neuedu.print.dao.NoticeMapper;
import com.neuedu.print.model.Notice;
import com.neuedu.print.model.Orders;
import com.neuedu.print.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	@RequestMapping(value = "notice/managerNotice", method = RequestMethod.GET)
	public String managerUser(Model model) {
		// 调用信息业务逻辑对象，实现查询所有信息
		List<Notice> notice = noticeService.selectAll();
		// 使用ResultBean封装数据
		ResultBean resultBean = new ResultBean(200, true, "查询所有部门信息成功~~~", notice);
		// 向前端页面传递数据
		model.addAttribute("print", resultBean);
		return "notice/managerNotice";
	}
	/**
	 * 显示修改页面
	 * @param id
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "notice/updateNotice", method = RequestMethod.GET)
	public String updataNotice(Integer id,Model model) {
		Notice notice = noticeService.selectById(id);
		model.addAttribute("rd", new ResultBean(200, true, "根据id查询信息成功",notice));
		return "notice/updateNotice";
	}
	@RequestMapping(value = "notice/update",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean update(Integer id, String noticetext, String noticedate, String remark) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Notice notice = new Notice(id,noticetext,sdf.parse(noticedate),remark);
		boolean flag = noticeService.update(notice);
		ResultBean resultBean = new ResultBean();
		if (flag) {
			// 新增成功			
			resultBean.setCode(200);
			resultBean.setSuccessed(true);
			resultBean.setMessage("信息修改成功~~~");
		}else {
			// 新增失败
			resultBean.setCode(500);
			resultBean.setSuccessed(false);
			resultBean.setMessage("信息修改失败~~~");
		}
		return resultBean;
	}
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "notice/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean batchDelete(@RequestParam("ids[]")Integer[] ids) {
		//红色部分，是用来解决jQuery在传递数组时尝试序列化问题
//		for (Integer v : ids) {
//			System.out.print(v + "\t");
//		}
		boolean flag = noticeService.batchDelete(ids);
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
