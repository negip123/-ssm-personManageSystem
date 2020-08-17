package com.neuedu.print.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.print.dao.ManagementMapper;
import com.neuedu.print.service.ManagementService;

/**
 * 业务接口实现类ManagementServiceImpl
 *
 */
@Service
public class ManagementServiceImpl implements ManagementService {
	@Autowired
	private ManagementMapper managementMapper;

	@Override
	public boolean login(String name, String password) {
		if (StringUtils.isBlank(name)) {
			return false;
		}
		if (StringUtils.isBlank(password)) {
			return false;
		}
		int count = managementMapper.login(name, password);
		if (count == 1) {
			return true;
		}
		return false;
	}

}
