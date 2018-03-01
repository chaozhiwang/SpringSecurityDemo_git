/**
 * =================================================
 *
 * @copyright 杭州龙骞科技有限公司 2012-1014
 * =================================================
 */
package com.picc.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * 字符串处理相关工具类
 *
 * @author qfq
 * @date 2012-10-16 15:37:14
 * @version 1.0
 */
public class StringUtil {
	/* Date类型转化到String类型 */
	public static String DateToString(java.util.Date date, int type) {
		String result = null;
		String format = "yyyy-MM-dd";
		if (type == 0) {
			format = "yyyy-MM-dd";
		}
		if (type == 1) {
			format = "yyyy/MM/dd";
		} else if (type == 2) {
			format = "yyyyMMdd";
		} else if (type == 21) {
			format = "yyyyMM";
		} else if (type == 3) {
			format = "MM/dd/yy";
		} else if (type == 4) {
			format = "yyyy-MM-dd HH:mm:ss";
		} else if (type == 5) {
			format = "yyyyMMddHHmmss";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		if (date != null) {
			result = formatter.format(date);
		} else {
			result = "";
		}
		return result;
	}
	
	/* String类型到Date类型转化 */

	public static java.util.Date StringToDate(String strDate, int type) {
		java.util.Date result = null;
		String format = "yyyy-MM-dd";
		if (type == 0) {
			format = "yyyy-MM-dd";
		}
		if (type == 1) {
			format = "yyyy/MM/dd";
		} else if (type == 2) {
			format = "yyyyMMdd";
		} else if (type == 21) {
			format = "yyyyMM";
		} else if (type == 3) {
			format = "MM/dd/yy";
		} else if (type == 4) {
			format = "yyyy-MM-dd HH:mm:ss";
		} else if (type == 5) {
			format = "yyyyMMddHHmm";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		if (strDate != null && !strDate.equals("")) {
			try {
				result = formatter.parse(strDate);
			} catch (ParseException ex) {
				result = null;
			}
		}
		return result;
	}
	
	public static String getUUID(){
		String s=UUID.randomUUID().toString();
		return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
	}

	
	
	//生成appid
	public static String getAppId(int i) {
		String s = UUID.randomUUID().toString();
		String appid = "hzlq_";
		if(i==2) {	//代理商
			appid+="dl_"+s.substring(0,8);
		}else if(i==3) {	//企业客户
			appid+="qy_"+s.substring(0,8);
		}else if(i==4) {	//个人
			appid+="gr_"+s.substring(0,8);
		}else {
			appid+=s.substring(0,8);
		}
		return appid;
	}
	
	//生成appKey
	public static String getAppKey() {
		String s = UUID.randomUUID().toString();
		return s.substring(0,8);
	}
	
    /**
     * 判断字符串是否为空或null，为空返回true
     *
     * @param str 待判定字符串
     * @return 是否为空或null
     */
    public static boolean isEmpty(String str) {
        return (str == null || "".equals(str.trim()));
    }
    
    /**
	 * 判断参数是否为空，只有其中有一个参数为空则返回true，否则返回false
	* @author:zzy 
	* @date 2013-11-26上午10:42:34 
	* @modifier: 
	* @modify_description:
	* @param objects
	* @return 
	* @version v1.0.0
	 */
	public static boolean isEmpty(Object...objects){
		boolean result = false;
		for(Object object:objects){
			if(object instanceof String){
				if(object==null||"".equals(object)){
					return true;
				}
			}
			if(object instanceof Integer){
				if(object==null||0==(Integer)object){
					return true;
				}
			}
			if(object instanceof Double){
				if(object==null||0==(Double)object){
					return true;
				}
			}
			if(object instanceof Float){
				if(object==null||0==(Float)object){
					return true;
				}
			}
			if(object instanceof Long){
				if(object==null||0==(Long)object){
					return true;
				}
			}
			if(object instanceof Date){
				if(object==null||null==(Date)object){
					return true;
				}
			}
			if(object instanceof Timestamp){
				if(object==null||null==(Timestamp)object){
					return true;
				}
			}
			if(object==null){
				return true;
			}
		}
		return result;
	}
    

    /**
     * 对象转为string格式，为空时，转为默认带入字符串
     *
     * @param obj 待转对象
     * @param defaultStr 默认字符串
     * @return 字符串
     */
    public static String objToString(Object obj, String defaultStr) {
        if (obj == null) {
            return defaultStr;
        } else {
            return obj.toString().trim();
        }
    }

    /**
     * 判断字符串长度是否合法
     *
     * @param instr 输入字符串
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @return true=合法
     */
    public static boolean chackStringLength(
            String instr, int minLength, int maxLength) {
        return !(instr.length() < minLength || instr.length() > maxLength);
    }

    /**
     * 判断字符串是否全是数字
     *
     * @param str 输入字符串
     * @return true=全是数字
     */
    public static boolean isNum(String str) {
        if (null == str) {
            return false;
        }
        return str.matches("\\d+");
    }

    /**
     * 字符串长度处理，过长切除，不足补空格.
     *
     * @param str 传入字符串
     * @param length 传入指定长度(字节数)
     * @param defaultStr 默认字符
     * @param isRight 是否右补齐
     * @return 返回指定长度的字符串
     */
    public static String supplyString(String str, int length, String defaultStr, boolean isRight) {
        if (str != null) {
            int len = str.length();
            if (len < length) {
                if (isRight) {
                    for (int i = 0; i < (length - len); i++) {
                        str = str + defaultStr;
                    }
                } else {
                    for (int i = 0; i < (length - len); i++) {
                        str = defaultStr + str;
                    }
                }
            } else {
                str = str.substring(0, length);
            }
        } else {//空字符串
            if (isRight) {
                for (int i = 0; i < length; i++) {
                    str = str + defaultStr;
                }
            } else {
                for (int i = 0; i < length; i++) {
                    str = defaultStr + str;
                }
            }
        }
        return str;
    }

    /**
     * 字符串倒转
     *
     * @param str 输入字符串
     * @return 倒转后字符串
     */
    public static String reverseStr(String str) {
        StringBuilder strbuff = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            strbuff.append(str.charAt(i));
        }
        return strbuff.toString();
    }

    /**
     * 生成随机几位数字
     *
     * @param k 生成位数
     * @return
     */
    public static String createRand(int k) {
        Random random = new Random();
        String sRand = "";
        for (int i = 0; i < k; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
        }
        return sRand;
    }
    

    
	public static Integer getInteger(String str) {
		Integer intTemp = 0;
		try {
			intTemp = Integer.valueOf(str);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return intTemp;
	}
    
	/**
	 * 获取本机IP
	 * @return
	 * @throws Exception
	 */
	public static List<String> getHostIp() throws Exception{
		List<String> li=new ArrayList<String>();
		Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
		InetAddress ip = null;
		while (allNetInterfaces.hasMoreElements()) {
			NetworkInterface netInterface = (NetworkInterface) allNetInterfaces
					.nextElement();
			Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements()) {
				ip = (InetAddress) addresses.nextElement();
				if (ip != null && ip instanceof Inet4Address) {
					System.out.println("本机的IP = " + ip.getHostAddress());
					li.add(ip.getHostAddress());
				}
			}
		}
		return li;
	}
    
	public static String generaterNextNumber() {
	    String id = null;
	    Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    id = formatter.format(date)+(int)(Math.random()*10000);
	    return id;
	}
	
	
	public static String generateRandomChar(int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			int intRand = (int) (Math.random() * 52);
			char base = (intRand < 26) ? 'A' : 'a';
			char c = (char) (base + intRand % 26);
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static String generaterFeeOrderNo(){
		return "ZH"+generaterNextNumber();
	}
	public static String generaterFlowOrderNo(){
		return "LL"+generaterNextNumber();
	}

	//天翼800字符转换
	public static String encodeBytes(byte[] bytes) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {

			buffer.append((char) (((bytes[i] >> 4) & 0xF) + ((int) 'a')));

			buffer.append((char) (((bytes[i]) & 0xF) + ((int) 'a')));
		}
		return buffer.toString();
	}

	/**
	 * @param <K>
	 * @param <V>
	 * @param pmap
	 */
	public static <K, V> List<V> map2list(Map<K, V> map) {
		List<V> li=new ArrayList<V>();
		for(Map.Entry<K, V> entry:map.entrySet()){
			li.add(entry.getValue());
		}
		return li;
	}
	
	public static void main(String[] args) {
		String appid = StringUtil.getAppId(3);
		String appKey = StringUtil.getAppKey();
		System.out.println(appid+"--"+appKey);
		
//		System.out.println( UUID.randomUUID().toString());
//		System.out.println(generaterNextNumber());
	}
}
