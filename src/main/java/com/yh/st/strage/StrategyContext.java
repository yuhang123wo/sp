package com.yh.st.strage;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrategyContext {
	private final Map<String, Strategy> strategyMap = new ConcurrentHashMap<>();

	/**
	 * 注入所以实现了Strategy接口的Bean
	 * 
	 * @param strategyMap
	 */
	@Autowired
	public StrategyContext(Map<String, Strategy> strategyMap) {
		this.strategyMap.clear();
		strategyMap.forEach((k, v) -> this.strategyMap.put(k, v));
	}

	/**
	 * 计算价格
	 * 
	 * @param memberLevel
	 *            会员等级
	 * @return 价格
	 */
	public BigDecimal calculatePrice(String memberLevel) {
		return strategyMap.get(memberLevel).calculatePrice();
	}
}
