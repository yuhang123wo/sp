package com.yh.st.common.util;

/**
 * 
 * @author yh
 * @Date 2017年11月1日
 * @desc
 */
public class StringUtil {

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static String objAddLike(Object obj) {
		if (obj == null)
			return null;
		return "%" + obj.toString().trim() + "%";
	}

	/**
	 * 开始时间
	 * 
	 * @param obj
	 * @return
	 */
	public static String addStartTime(Object obj) {
		if (obj == null)
			return null;
		return obj.toString().trim() + " 00:00:00";
	}

	// 结束时间
	public static String addEndTime(Object obj) {
		if (obj == null)
			return null;
		return obj.toString().trim() + " 23:59:59";
	}
}
