package com.sowatec.addressbook.data.persistence.type;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
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

public class Address extends BaseType {
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip")
	private Integer zip;
	
	@Column(name="country")
	private String country;
	
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Person> person = new HashSet<>();
    
	// Objekt Address
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    
    
    
}
