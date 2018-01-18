package com.yh.st.strage;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class GeneralMember implements Strategy {
	@Override
	public BigDecimal calculatePrice() {
		// 普通会员没有折扣，直接返回原价
		return new BigDecimal("100");
	}
}
