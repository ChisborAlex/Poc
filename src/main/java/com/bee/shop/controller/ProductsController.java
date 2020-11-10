package com.bee.shop.controller;

import com.bee.shop.domain.Product;
import com.bee.shop.model.ProductEntity;
import com.bee.shop.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
@Slf4j
public class ProductsController {
	@NonNull
	private final ProductService productService;


	@GetMapping
	public List<ProductEntity> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping(path = "/{product-id}")
	public ProductEntity getProductById(@PathVariable("product-id") String productId) {
		return productService.getProductById(productId);
	}

	@PostMapping(path = "/create")
	public ProductEntity addProduct(@RequestBody @Valid Product product) {
		return productService.addProduct(product);
	}
}