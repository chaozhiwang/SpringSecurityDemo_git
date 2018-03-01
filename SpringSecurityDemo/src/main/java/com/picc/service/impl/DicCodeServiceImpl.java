package com.picc.service.impl;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picc.bean.dic.DicCode;
import com.picc.dao.DicCodeMapper;
import com.picc.dao.DicConfigMapper;
import com.picc.service.DicService;
import com.picc.util.ConstantUtil;

@Service("dicCodeService")
public class DicCodeServiceImpl implements DicService {
	private static final Logger logger = Logger.getLogger(DicCodeServiceImpl.class);
	
	private static final String ACNT_TYPE = ConstantUtil.ACNT_TYPE;
	@Autowired
	private DicCodeMapper codeMapper;
	
	@Autowired
	private DicConfigMapper configMapper;


	@Override
	public List<DicCode> listAcntType() {
		String configId = configMapper.getDicConfigIdByAcntType(ACNT_TYPE);
		return codeMapper.listAcntTypeByDicConfigId(configId);
	}
}
