package com.picc.dao;

import java.util.List;

import com.picc.bean.dic.DicCode;

public interface DicCodeMapper {

	List<DicCode> listAcntTypeByDicConfigId(String configId);
}
