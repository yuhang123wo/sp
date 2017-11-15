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

	/**
	 * 结束时间
	 * 
	 * @param obj
	 * @return
	 */
	public static String addEndTime(Object obj) {
		if (obj == null)
			return null;
		return obj.toString().trim() + " 23:59:59";
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean objIsNull(Object obj) {
		if (obj == null || isNull(obj.toString()))
			return true;
		return false;
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean objIsNotNull(Object obj) {
		return !objIsNull(obj);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		if (str == null || "".equals(str.trim()))
			return true;
		return false;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}
}
