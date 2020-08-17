package com.neuedu.print.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neuedu.print.model.Notice;
@Repository
public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);
    int batchDelete(Integer[] ids);

    int insert(Notice record);

    int insertSelective(Notice record);
    
    List<Notice> selectAll();

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}