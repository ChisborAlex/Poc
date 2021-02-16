package com.bee.shop.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "address")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddressEntity extends BasicEntity{

	private String houseNumber;
	private String streetName;
	private String cityName;
	private String postalCode;
}
