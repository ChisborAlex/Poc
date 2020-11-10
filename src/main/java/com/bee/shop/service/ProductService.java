package com.bee.shop.service;

import com.bee.shop.domain.Product;
import com.bee.shop.model.ProductEntity;
import com.bee.shop.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public List<ProductEntity> getAllProducts() {
		return productRepository.findAll();
	}

	public ProductEntity getProductById(String productId) {
		return productRepository.findById(UUID.fromString(productId)).orElseThrow(ResourceNotFoundException::new);
	}

	public ProductEntity addProduct(@RequestBody @Valid Product product) {
		return productRepository.save(ProductEntity.builder()
				                              .name(product.getName())
				                              .price(product.getPrice())
				                              .availability(product.getAvailability())
				                              .build());
	}
}
