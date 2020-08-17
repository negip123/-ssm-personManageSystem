package com.neuedu.print.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.print.dao.MessageMapper;
import com.neuedu.print.model.Message;
import com.neuedu.print.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService {
	@Autowired 
	private MessageMapper messageMapper;
	@Override
	public boolean insert(Message message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Message message) {
		// TODO Auto-generated method stub
		return false;
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
		return messageMapper.batchDelete(ids) > 0 ? true : false;
	}

	@Override
	public Message selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> selectAll() {
		
		return messageMapper.selectAll();
	}

	@Override
	public List<Message> selectByLike(Integer id, Integer qq) {
		// TODO Auto-generated method stub
		return null;
	}

}
