package com.neuedu.print.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.neuedu.print.model.Orders;
/**
 * DAO接口或信息mapper接口：封装了对这表的所有操作，并通过方法名与mapper.xml文件中的id进行映射关联
 * @author steve
 *
 */
@Repository
public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);
    
    int batchDelete(Integer[] ids);
    
    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer id);
    
    List<Orders> selectAll();
    
    List<Orders> selectByLike(
			@Param("id")Integer id,
			@Param("orderno")Integer orderno);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}