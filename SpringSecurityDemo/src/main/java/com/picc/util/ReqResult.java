package com.picc.util;


public class ReqResult {
    private int resultCode = ResultCode.RC_9999;
    private Object returnObject = null;

    public ReqResult() {}

    public ReqResult(int code) {
        this.resultCode = code;
        this.returnObject = ResultCode.getResultText(code);
    }

    public ReqResult(int resultCode, String message) {
        this.resultCode = resultCode;
        if (StringUtil.isEmpty(message)) {
            message = "未知消息";
        }
        if (resultCode != ResultCode.RC_1000) {
            this.returnObject = message;
        }
    }

    public ReqResult(int resultCode, Object returnObject) {
        this.resultCode = resultCode;
        this.returnObject = returnObject;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Object getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

}
