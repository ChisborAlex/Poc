package com.bee.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@NonNull
	private String name;
	@NonNull
	private BigDecimal price;
	@NonNull
	private String availability;
}
