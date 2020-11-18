package com.bee.shop.controller;

import com.bee.shop.domain.Product;
import com.bee.shop.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
@Slf4j
public class ProductsController {
	@NonNull
	private final ProductService productService;


	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping(path = "/{product-id}")
	public Product getProductById(@PathVariable("product-id") String productId) {
		return productService.getProductById(productId);
	}

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);

	}

	@DeleteMapping("/{product-id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@PathVariable("product-id") UUID productId) {
		productService.deleteProduct(productId);
	}
}