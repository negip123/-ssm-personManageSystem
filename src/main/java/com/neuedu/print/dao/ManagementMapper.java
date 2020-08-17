package com.neuedu.print.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.neuedu.print.model.Management;

/**
 * 数据访问层ManagementMapper接口
 *
 */
@Repository
public interface ManagementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Management record);

    int insertSelective(Management record);

    Management selectByPrimaryKey(Integer id);
    
    int login(@Param("name")String name, @Param("password")String password);

    int updateByPrimaryKeySelective(Management record);

    int updateByPrimaryKey(Management record);
}
