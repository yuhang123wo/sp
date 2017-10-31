package com.yh.st.common.util;

import java.util.ArrayList;
import java.util.List;

import com.yh.st.base.domain.Auth;
import com.yh.st.base.vo.MenuVo;

public class MenuTool {
	/**
	 * 
	 * @param authList
	 * @return
	 */
	public static List<MenuVo> getMenu(List<Auth> authList) {
		List<MenuVo> list = new ArrayList<MenuVo>();
		for (int i = 0; i < authList.size(); i++) {
			Auth auth = authList.get(i);
			if (auth.getpId() == 0) {
				MenuVo menu = new MenuVo();
				menu.setAuth(auth);
				menu.setChild(getMenuSecond(auth.getId(), authList));
				list.add(menu);
			}
		}
		return list;
	}

	/**
	 * 二级菜单
	 * 
	 * @param pid
	 * @param authList
	 * @return
	 */
	private static List<Auth> getMenuSecond(long pid, List<Auth> authList) {
		List<Auth> list = new ArrayList<Auth>();
		for (int i = 0; i < authList.size(); i++) {
			Auth auth = authList.get(i);
			if (auth.getpId() > 0 && auth.getpId() == pid) {
				list.add(auth);
			}
		}
		return list;
	}
}
