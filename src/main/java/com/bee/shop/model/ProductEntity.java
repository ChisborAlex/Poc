package com.bee.shop.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "product")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity extends BasicEntity{
	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private BigDecimal price;
	private String availability;
}