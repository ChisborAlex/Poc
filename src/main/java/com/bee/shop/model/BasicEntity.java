package com.bee.shop.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@Accessors(chain = true)
public abstract class BasicEntity {
	@Column(name = "created_at")
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(name = "updated_at")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
