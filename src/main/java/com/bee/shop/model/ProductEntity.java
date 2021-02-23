package com.bee.shop.model;

import com.bee.shop.domain.ProductType;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity extends BasicEntity {

	private String name;
	private BigDecimal price;
	private String availability;
	private ProductType productType;
}