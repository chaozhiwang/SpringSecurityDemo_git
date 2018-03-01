package com.picc.util;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Configuration {
	
	private static Logger log = LoggerFactory.getLogger(Configuration.class);
	/**
	 * 读取配置文件信息
	 * 
	 * @param name
	 *            读取节点名
	 * @param fileName
	 *            文件名
	 * @return 读取的节点值
	 */
	public static String readConfigString(String name, String fileName) {
		try {
			String result = "";
			ResourceBundle rb = ResourceBundle.getBundle(fileName);
			result = rb.getString(name);
			return result;
		} catch (Exception e) {
			log.error("读取" + fileName + "配置文件" + name + "属性出错",e);
		}
		return null;
	}
}
