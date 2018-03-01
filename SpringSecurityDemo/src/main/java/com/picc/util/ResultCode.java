package com.picc.util;

public class ResultCode {

	/** 操作成功 */
	@Result(text = "操作成功")
	public static final int RC_1000 = 1000;

	/** 操作失败（如没有明确的错误原因，则返回此错误码） */
	@Result(text = "操作失败")
	public static final int RC_9999 = 9999;
	
	/** 操作失败（错误描述可以自定义） */
    @Result(text = "操作失败")
    public static final int RC_9998 = 9998;

	/* ————————————————————————————全局模块—————————————————————————————————————— */

	/** 必填参数存在空值 */
	@Result(text = "必填参数存在空值")
	public static final int RC_1001 = 1001;

	/** 参数长度、格式不合法 */
	@Result(text = "参数长度、格式不合法")
	public static final int RC_1002 = 1002;

	/** 非法请求（安全校验不合法）——或被T */
	@Result(text = "非法请求（安全校验不合法）——或被T")
	public static final int RC_1003 = 1003;

	/** 非法请求（数据校验不合法） */
	@Result(text = "非法请求（数据校验不合法）")
	public static final int RC_1004 = 1004;

	/** 时间戳过期 */
	@Result(text = "时间戳过期")
	public static final int RC_1005 = 1005;

	/** 帐号被锁定 */
	@Result(text = "帐号被锁定")
	public static final int RC_1006 = 1006;

	/** 用户状态不正确 */
	@Result(text = "用户状态不正确")
	public static final int RC_1007 = 1007;

	/** 用户已存在 */
	@Result(text = "用户已存在")
	public static final int RC_1008 = 1008;

	/** 无新版本 */
	@Result(text = "无新版本")
	public static final int RC_1009 = 1009;
	
	/** 未分配角色 */
	@Result(text = "未分配角色")
	public static final int RC_1010 = 1010;
	
	/** 登陆失败 */
	@Result(text = "登陆失败")
	public static final int RC_1011 = 1011;
	
	/** 登陆失效 */
	@Result(text = "登陆失效")
	public static final int RC_1012 = 1012;
	
	/** 禁止操作 */
	@Result(text = "禁止操作")
	public static final int RC_1013 = 1013;
	

	/* ————————————————————————————用户模块—————————————————————————————————————— */
	/** 手机验证码错误 */
	@Result(text = "手机验证码错误")
	public static final int RC_2001 = 2001;

	/** 验证码不存在 */
	@Result(text = "验证码不存在")
	public static final int RC_2002 = 2002;

	/** 忘记密码非法请求，未按流程请求接口 */
	@Result(text = "忘记密码非法请求，未按流程请求接口")
	public static final int RC_2003 = 2003;

	/** 短信发送次数过多 */
	@Result(text = "短信发送次数过多")
	public static final int RC_2004 = 2004;

	/** 用户帐号验证不通过 */
	@Result(text = "用户帐号验证不通过")
	public static final int RC_2005 = 2005;
	
	/** 用户未登陆 */
	@Result(text = "用户未登陆")
	public static final int RC_2006 = 2006;
	
	/** 密码错误 */
	@Result(text = "密码错误")
	public static final int RC_2007 = 2007;
	
	/** 用户不存在 */
	@Result(text = "用户不存在")
	public static final int RC_2008 = 2008;
	
	/** 号码不正确*/
	@Result(text = "号码不正确")
	public static final int RC_2009 = 2009;
	
	/** 验证码已失效 */
	@Result(text = "验证码已失效")
	public static final int RC_2010 = 2010;
	
	/** 图片验证码错误 */
	@Result(text = "图片验证码错误")
	public static final int RC_2011 = 2011;

	/* ————————————————————————————文件模块—————————————————————————————————————— */
	/** 非法的文件类型 */
	@Result(text = "非法的文件类型")
	public static final int RC_3001 = 3001;

	/** 文件大小不正确 */
	@Result(text = "文件大小不正确")
	public static final int RC_3002 = 3002;

	
	/*—————————————————————————————————活动模块————————————————————————————————————*/
	/**可用余额不足*/
	@Result(text="可用余额不足")
	public static final int RC_4001 = 4001;
	
	/**未查询到数据*/
	@Result(text="未查询到数据")
	public static final int RC_4002 = 4002;
	
	/**活动不存在*/
	@Result(text="活动不存在")
	public static final int RC_4003 = 4003;
	
	/**活动未预付*/
	@Result(text="活动未预付")
	public static final int RC_4004 = 4004;
	
	/**活动部分预付*/
	@Result(text="活动部分预付")
	public static final int RC_4005 = 4005;
	
	/**活动未开始*/
	@Result(text="活动未开始")
	public static final int RC_4006 = 4006;
	
	/**活动已结束*/
	@Result(text="活动已结束")
	public static final int RC_4007 = 4007;
	
	/**活动未开启*/
	@Result(text="活动未开启")
	public static final int RC_4008 = 4008;
	
	/**有未领取的奖项*/
	@Result(text="有未领取的奖项")
	public static final int RC_4009 = 4009;
	
	/**领奖号码错误*/
	@Result(text="领奖号码错误")
	public static final int RC_4010 = 4010;
	
	
	/**用户已参与过本活动*/
	@Result(text="用户已参与过本活动")
	public static final int RC_4100 = 4100;
	
	/**用户未中奖*/
	@Result(text="用户未中奖")
	public static final int RC_4101 = 4101;
	
	/**已超过领奖时限*/
	@Result(text="已超过领奖时限")
	public static final int RC_4102 = 4102;
	
	
	/**活动数据异常*/
	@Result(text="活动数据异常")
	public static final int RC_4999 = 4999;
	
	
	/*—————————————————————————————————银行模块————————————————————————————————————*/
	/**sign签名错误*/
	@Result(text="sign签名错误")
	public static final int RC_5001 = 5001;
	
	/**无效appKey*/
	@Result(text="无效appKey")
	public static final int RC_5002 = 5002;
	
	@Result(text="该手机号无转赠记录")
	public static final int RC_5101 = 5101;
	
	@Result(text="转赠已过期")
	public static final int RC_5102 = 5102;
	
	@Result(text="转赠已领取")
	public static final int RC_5103 = 5103;
	
	@Result(text="流量余额不足")
	public static final int RC_5104 = 5104;
	
	@Result(text="流量转赠次数超限")
	public static final int RC_5105 = 5105;
	
	@Result(text="流量领取失败")
	public static final int RC_5106 = 5106;
	
	@Result(text="流量提取次数超限")
	public static final int RC_5107 = 5107;
	
	@Result(text="流量发放大小限制")
	public static final int RC_5108 = 5108;
	
	/**
	 * 根据返回码取返回文本
	 * 
	 * @param resultCode
	 * @return
	 */
	public static String getResultText(int resultCode) {
		Result rst = null;
		try {
			rst = ResultCode.class.getField("RC_" + resultCode).getAnnotation(Result.class);
		} catch (Exception e) {
			return null;
		}
		return rst == null ? null : rst.text();
	}

}
