package com.picc.controller;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.picc.service.DicService;
import com.picc.util.ReqResultUtil;

@Controller
@RequestMapping("/dic")
public class DicController {
	private static final Logger log = Logger.getLogger(DicController.class);
	@Autowired
	private DicService dicCodeService;

	//获取账号类型
	@RequestMapping(value = "listAcntType", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> listAcntType(
			HttpServletRequest request) {
		log.info("获取账号类型[listAcntType]");
		try {
			return ReqResultUtil.genSuccessResultResponse(dicCodeService.listAcntType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
