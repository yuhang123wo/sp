package com.yh.st.base.config.shiro;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yh.st.base.domain.Auth;
import com.yh.st.base.service.UserinfoService;

@Component("shiroService")
public class ShiroService {
	@Autowired
	private ShiroFilterFactoryBean shiroFilterFactoryBean;
	@Resource
	private UserinfoService userinfoService;

	private Logger logger = LoggerFactory.getLogger(ShiroService.class);

	/**
	 * 初始化权限
	 */
	public Map<String, String> loadFilterChainDefinitions() {
		// 权限控制map.从数据库获取
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/img/**", "anon");
		filterChainDefinitionMap.put("/font-awesome/**", "anon");
		filterChainDefinitionMap.put("/login", "loginAuth");// 表示需要认证才可以访问
		List<Auth> list = userinfoService.findAuthAll();
		if (CollectionUtils.isNotEmpty(list)) {
			for (Auth auth : list) {
				filterChainDefinitionMap.put(auth.getAuthUrl(),
						"perms[" + auth.getAuthUrl() + "]");
			}
		}
		filterChainDefinitionMap.put("/**", "anon");
		return filterChainDefinitionMap;
	}

	/**
	 * 重新加载权限
	 */
	public void updatePermission() {

		synchronized (shiroFilterFactoryBean) {

			AbstractShiroFilter shiroFilter = null;
			try {
				shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean
						.getObject();
			} catch (Exception e) {
				throw new RuntimeException(
						"get ShiroFilter from shiroFilterFactoryBean error!");
			}

			PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter
					.getFilterChainResolver();
			DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver
					.getFilterChainManager();

			// 清空老的权限控制
			manager.getFilterChains().clear();

			shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
			shiroFilterFactoryBean
					.setFilterChainDefinitionMap(loadFilterChainDefinitions());
			// 重新构建生成
			Map<String, String> chains = shiroFilterFactoryBean
					.getFilterChainDefinitionMap();
			for (Map.Entry<String, String> entry : chains.entrySet()) {
				String url = entry.getKey();
				String chainDefinition = entry.getValue().trim()
						.replace(" ", "");
				manager.createChain(url, chainDefinition);
			}

			logger.info("更新权限成功！！");
		}
	}
}
