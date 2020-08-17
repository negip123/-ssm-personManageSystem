package com.neuedu.print.service;

import java.util.List;

import com.neuedu.print.model.Notice;

public interface NoticeService {
	
		/**
		 * 
		 * @return
		 */
		boolean insert(Notice notice);
		
		/**
		 * 
		 * @param notice
		 * @return
		 */
		boolean update(Notice notice);
		
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
		Notice selectById(Integer id);
		/**
		 * 
		 * @return
		 */
		List<Notice> selectAll();
}	
