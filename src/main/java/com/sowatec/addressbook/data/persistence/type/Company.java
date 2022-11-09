package com.sowatec.addressbook.data.persistence.type;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Company extends BaseType {
	
	@Column(name="name")
	private String name;
	
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Address> locations = new HashSet<>();
    
}
