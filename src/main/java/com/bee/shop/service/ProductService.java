package com.bee.shop.service;

import com.bee.shop.domain.ProductMapper;
import com.bee.shop.model.ProductEntity;
import com.bee.shop.repo.ProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

	@NonNull
	private final ProductRepository productRepository;
	@NonNull
	private final ProductMapper productMapper;

	public List<ProductEntity> getAllProducts() {
		return productRepository.findAll().stream().map(productMapper::toProduct).collect(Collectors.toList());
	}

	public ProductEntity getProductById(String productId) {
		var entity = productRepository.findById(UUID.fromString(productId)).orElseThrow(ResourceNotFoundException::new);
		return productMapper.toProduct(entity);
	}

	public ProductEntity addProduct(@NonNull ProductEntity productEntity) {
		var savedProduct = productRepository.save(productMapper.toEntity(productEntity));
		return productMapper.toProduct(savedProduct);
	}

	public ProductEntity updateProduct(@NonNull ProductEntity productEntity) {
		var storedProduct = productRepository.findById(productEntity.getId()).orElseThrow(ResourceNotFoundException::new);
		storedProduct.setName(productEntity.getName() != null ? productEntity.getName() : storedProduct.getName());
		storedProduct.setPrice(productEntity.getPrice() != null ? productEntity.getPrice() : storedProduct.getPrice());
		storedProduct.setAvailability(productEntity.getAvailability() != null ? productEntity.getAvailability() : storedProduct.getAvailability());
		return productMapper.toProduct(productRepository.save(storedProduct));
	}

	public void deleteProduct(UUID productId) {
		var storedProduct = productRepository.findById(productId).orElseThrow(ResourceNotFoundException::new);
		productRepository.delete(storedProduct);
	}
}