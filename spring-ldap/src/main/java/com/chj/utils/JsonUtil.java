/************************************************************************************
 * @File name   :      JsonUtil.java
 *
 * @Author      :      YSHANG
 *
 * @Date        :      2012-11-20
 *
 * @Copyright Notice: 
 * Copyright (c) 2012 Shanghai OnStar, Inc. All  Rights Reserved.
 * This software is published under the terms of the Shanghai OnStar Software
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 * 
 * ----------------------------------------------------------------------------------
 * Date								Who					Version				Comments
 * 2012-11-20 下午4:37:13			YSHANG			1.0				Initial Version
 ************************************************************************************/
package com.chj.utils;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

/**
 * class util to process json data.
 */
public class JsonUtil {

	public static final ObjectMapper om = new ObjectMapper();

	/**
	 * @Author : JUNJZHU
	 * @Date : 2012-11-21
	 * @param data
	 * @param clazz
	 * @return null
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getEntity(Object data, Class<T> clazz) {
		if (data.getClass() == clazz) {
			return (T) data;
		}
		try {
			om.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			String json = om.writeValueAsString(data);
			return om.readValue(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @Author : HEAXIE
	 * @Date : 2012-11-21
	 * @param data
	 * @return null
	 */
	public static String getJson(Object data) {
		try {
			return om.writeValueAsString(data);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @Author : XIAOXCHE
	 * @Date : 2012-12-10
	 * @param json
	 * @param clazz
	 * @return null
	 */
	public static <T> T getEntity(String json, Class<T> clazz) {
		try {
			om.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return om.readValue(json, clazz);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @Author : HEAXIE
	 * @Date : 2012-12-7
	 * @param json
	 * @param javatype
	 * @return null
	 */
	public static <T> T getEntity(String json, JavaType javatype) {
		try {
			om.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return om.readValue(json, javatype);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
