package com.bee.shop.domain;

import com.bee.shop.model.ProductEntity;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

	public ProductEntity toProduct(@NonNull com.bee.shop.model.ProductEntity entity) {
		return ProductEntity.builder()
				.name(entity.getName())
				.price(entity.getPrice())
				.availability(entity.getAvailability())
				.build();
	}

	public com.bee.shop.model.ProductEntity toEntity(@NonNull ProductEntity productEntity) {
		return com.bee.shop.model.ProductEntity.builder()
				.name(productEntity.getName())
				.price(productEntity.getPrice())
				.availability(productEntity.getAvailability())
				.build();
	}
}