package com.bee.shop.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity extends BasicEntity {

	private String lastName;
	private String firstName;
	@OneToMany
	private List<UserAddressEntity> addresses;
}
