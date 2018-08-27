package com.yh.st.strage;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class VipMember implements Strategy {
	@Override
	public BigDecimal calculatePrice() {
		// VIP会员打8折
		return new BigDecimal("80");
	}

}