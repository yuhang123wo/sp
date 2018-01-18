package com.yh.st.strage;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class SuperMember implements Strategy {
	@Override
	public BigDecimal calculatePrice() {
		// 超级会员打1折
		return new BigDecimal("10");
	}
}
