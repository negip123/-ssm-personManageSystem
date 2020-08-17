package com.neuedu.print.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.neuedu.print.model.Message;
@Repository
public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);
    
    int batchDelete(Integer[] ids);
    
    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    List<Message> selectByLike(
			@Param("id")Integer id,
			@Param("qq")Integer qq);

	List<Message> selectAll();
}