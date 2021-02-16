package com.bee.shop.service;

import com.bee.shop.model.UserEntity;
import com.bee.shop.repo.UserEntityRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

	@NonNull
	private final UserEntityRepository userRepository;

	public List<UserEntity> getUsers() {
		return userRepository.findAll();
	}
}
