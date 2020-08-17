package com.neuedu.print.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.print.dao.NoticeMapper;
import com.neuedu.print.model.Notice;
import com.neuedu.print.service.NoticeService;
@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired NoticeMapper noticeMapper;
	
	@Override
	public boolean insert(Notice notice) {
		
		return false;
	}

	@Override
	public boolean update(Notice notice) {
		
		int line =noticeMapper.updateByPrimaryKeySelective(notice);
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
		return noticeMapper.batchDelete(ids) > 0 ? true : false;
	}


	@Override
	public Notice selectById(Integer id) {
		
		return noticeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Notice> selectAll() {
		
		return noticeMapper.selectAll();
	}

}
