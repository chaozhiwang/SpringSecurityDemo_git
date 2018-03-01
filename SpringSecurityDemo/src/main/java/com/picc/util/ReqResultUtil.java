package com.picc.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.alibaba.fastjson.JSON;

/**
 * 
 * 类描述： 接口返回json的公共处理类
 * 
 * @author wangkun
 * 
 */

public class ReqResultUtil {
	public static ResponseEntity<String> genSuccessResultResponse() {
		ReqResult rst = new ReqResult();
		rst.setResultCode(ResultCode.RC_1000);
		return genSuccessResultResponse("成功");
	}

	public static ResponseEntity<String> genSuccessResultResponse(Object resultObject) {
		ReqResult rst = new ReqResult();
		rst.setResultCode(ResultCode.RC_1000);
		rst.setReturnObject(resultObject);
		return genResultResponse(rst);
	}

	public static ResponseEntity<String> genFailResultResponse() {
		ReqResult rst = new ReqResult();
		rst.setResultCode(ResultCode.RC_9999);
		rst.setReturnObject("系统异常");
		return genFailResultResponse(rst);
	}

	public static ResponseEntity<String> genFailResultResponse(Object resultObject) {
		ReqResult rst = new ReqResult();
		rst.setResultCode(ResultCode.RC_9999);
		rst.setReturnObject(resultObject);
		return genFailResultResponse(rst);
	}

	public static ResponseEntity<String> genFailResultResponse(ReqResult rst) {
		return new ResponseEntity<String>(JSON.toJSONString(rst), HttpStatus.OK);
	}
	
	public static ResponseEntity<String> genResultResponse(ReqResult rst){
		return new ResponseEntity<String>(JSON.toJSONString(rst),HttpStatus.OK);
	}

}
