package com.neuedu.print.service;

import java.util.List;

import com.neuedu.print.model.Message;

public interface MessageService {
boolean insert(Message message);
	
	/**
	 * 修改留言信息
	 * @param message 留言信息对象
	 * @return 修改留言，成功true与否false
	 */
	boolean update(Message message);
	
	/**
	 * 批量删除留言信息
	 * @param ids 留言信息编号数组
	 * @return 批量删除留言，成功true与否false
	 */
	boolean batchDelete(Integer[] ids);
	
	/**
	 * 根据留言编号查询指定的留言信息对象
	 * @param id 留言编号
	 * @return 留言信息对象
	 */
	Message selectById(Integer id);
	
	/**
	 * 显示所有留言信息对象
	 * @return 留言信息对象集合
	 */
	List<Message> selectAll();
	
	
	List<Message> selectByLike(Integer id,Integer qq);
}

