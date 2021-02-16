package com.bee.shop.controller;

import com.bee.shop.model.UserEntity;
import com.bee.shop.service.AdminService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
	@NonNull
	private final AdminService adminService;

	@GetMapping
	public List<UserEntity> getUsers() {
		return adminService.getUsers();
	}
}