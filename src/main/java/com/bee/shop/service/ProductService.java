package com.bee.shop.service;

import com.bee.shop.model.ProductEntity;
import com.bee.shop.repo.ProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService {

	@NonNull
	private final ProductRepository productRepository;

	public List<ProductEntity> getAllProducts() {
		return new ArrayList<>(productRepository.findAll());
	}

	public ProductEntity getProductById(String productId) {
		return productRepository.findById(UUID.fromString(productId)).orElseThrow(ResourceNotFoundException::new);
	}

	public ProductEntity addProduct(@NonNull ProductEntity productEntity) {
		return productRepository.save(productEntity);
	}

	public ProductEntity updateProduct(@NonNull ProductEntity productEntity) {
		var storedProduct = productRepository.findById(productEntity.getId()).orElseThrow(ResourceNotFoundException::new);
		storedProduct.setName(productEntity.getName() != null ? productEntity.getName() : storedProduct.getName());
		storedProduct.setPrice(productEntity.getPrice() != null ? productEntity.getPrice() : storedProduct.getPrice());
		storedProduct.setAvailability(productEntity.getAvailability() != null ? productEntity.getAvailability() : storedProduct.getAvailability());
		return productRepository.save(storedProduct);
	}

	public void deleteProduct(UUID productId) {
		var storedProduct = productRepository.findById(productId).orElseThrow(ResourceNotFoundException::new);
		productRepository.delete(storedProduct);
	}
}