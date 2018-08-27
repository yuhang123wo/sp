package com.yh.st.web.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.st.strage.StrategyContext;

public class StratgeController {
	@Autowired
	private StrategyContext strategyContext;

	@RequestMapping("calculatePrice")
	public @ResponseBody BigDecimal calculatePrice(String memberLevel) {
		return strategyContext.calculatePrice(memberLevel);
	}

}
