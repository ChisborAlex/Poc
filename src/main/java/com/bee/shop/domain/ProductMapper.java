package com.bee.shop.domain;

import com.bee.shop.model.ProductEntity;
import lombok.NonNull;

public class ProductMapper {

	public Product toProduct(@NonNull ProductEntity entity) {
		return Product.builder()
				.id(entity.getId())
				.name(entity.getName())
				.price(entity.getPrice())
				.availability(entity.getAvailability())
				.build();
	}

	public ProductEntity toEntity(@NonNull Product product) {
		return ProductEntity.builder()
				.id(product.getId())
				.name(product.getName())
				.price(product.getPrice())
				.availability(product.getAvailability())
				.build();
	}
}