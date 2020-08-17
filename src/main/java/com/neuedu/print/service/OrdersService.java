package com.neuedu.print.service;

import java.util.List;

import com.neuedu.print.model.Orders;


/**
 * 
 * @author steve
 * 信息业务逻辑接口OrderService
 * 面向接口编程：体现出整体系统行为表现抽象，这些行为共同协作完成整体系统的功能，团队开发就成为可能，只依赖于抽象而不依赖于具体实现，宁愿增加一个接口不能去修改接口
 * 观察mapper接口，增删改，其实无需再返回受影响的行数，只需要返回boolean

 */
public interface OrdersService {
	    /**
	     * 
	     * @param order
	     * @return
	     */
	    boolean insert(Orders order);
		/**
		 * 
		 * @param Orders
		 * @return
		 */
		boolean update(Orders order);
		
		/**
		 * 
		 * @param ids
		 * @return
		 */
		boolean batchDelete(Integer[] ids);
		
		/**
		 * 
		 * @param id
		 * @return
		 */
		Orders selectById(Integer id);
		
		/**
		 * 
		 * @return
		 */
		List<Orders> selectAll();
		
		/**
		 * 
		 * @param id
		 * @param orderno
		 * @return
		 */
		List<Orders> selectByLike(Integer id,Integer orderno);
	}

