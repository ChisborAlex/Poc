package com.bee.shop.service;

import com.bee.shop.domain.Product;
import com.bee.shop.domain.ProductMapper;
import com.bee.shop.repo.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	public List<Product> getAllProducts() {
		return productRepository.findAll().stream().map(productMapper::toProduct).collect(Collectors.toList());
	}

	public Product getProductById(String productId) {
		var entity = productRepository.findById(UUID.fromString(productId)).orElseThrow(ResourceNotFoundException::new);
		return productMapper.toProduct(entity);
	}

	public Product addProduct(@NonNull Product product) {
		var savedProduct = productRepository.save(productMapper.toEntity(product));
		return productMapper.toProduct(savedProduct);
	}

	public Product updateProduct(@NonNull Product product) {
		var storedProduct = productRepository.findById(product.getId()).orElseThrow(ResourceNotFoundException::new);
		storedProduct.setName(product.getName() != null ? product.getName() : storedProduct.getName());
		storedProduct.setPrice(product.getPrice() != null ? product.getPrice() : storedProduct.getPrice());
		storedProduct.setAvailability(product.getAvailability() != null ? product.getAvailability() : storedProduct.getAvailability());
		return productMapper.toProduct(productRepository.save(storedProduct));
	}

	public void deleteProduct(UUID productId) {
		var storedProduct = productRepository.findById(productId).orElseThrow(ResourceNotFoundException::new);
		productRepository.delete(storedProduct);
	}
}