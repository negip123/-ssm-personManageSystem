package com.neuedu.print.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.print.dao.OrdersMapper;
import com.neuedu.print.model.Orders;
import com.neuedu.print.service.OrdersService;
/**
 * 信息业务逻辑接口实现类：接口中定义的行为要实现，也可以扩展内部私有方法
 * 功能：业务逻辑实现
 * @author steve
 *
 */
@Service
public class OrdersServiceImpl implements OrdersService {
 
	@Autowired OrdersMapper ordersMapper;
	
	@Override
	public boolean insert(Orders order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Orders order) {
		int line =ordersMapper.updateByPrimaryKeySelective(order);
		return line==1?true:false;

	}

	@Override
	public boolean batchDelete(Integer[] ids) {
		if (null == ids) {
			return false;
		}
		if (ids.length == 0) {
			return false;
		}
		for (Integer v : ids) {
			if (v <= 0) {
				return false;
			}
		}
		return ordersMapper.batchDelete(ids) > 0 ? true : false;
	}


	@Override
	public Orders selectById(Integer id) {
		
		return ordersMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Orders> selectAll() {
		
		return ordersMapper.selectAll();
	}

	@Override
	public List<Orders> selectByLike(Integer id, Integer orderno) {
		
		return ordersMapper.selectByLike(id, orderno);
	}

}
