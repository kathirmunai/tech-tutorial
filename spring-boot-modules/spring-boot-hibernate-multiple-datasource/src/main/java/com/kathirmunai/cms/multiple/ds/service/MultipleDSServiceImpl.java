package com.kathirmunai.cms.multiple.ds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kathirmunai.cms.multiple.ds.dao.IMultipleDSDao;

@Service
public class MultipleDSServiceImpl implements IMultipleDSService {
	@Autowired
	private IMultipleDSDao dao;

	@Override
	public String getDs1Sysdate() {
		return dao.getDs1Sysdate();
	}

	@Override
	public String getDs2Sysdate() {
		return dao.getDs2Sysdate();
	}

}
