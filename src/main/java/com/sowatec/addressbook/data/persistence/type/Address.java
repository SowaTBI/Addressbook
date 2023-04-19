package com.sowatec.addressbook.data.persistence.type;


import javax.persistence.Column;
import javax.persistence.Entity;

import com.sowatec.addressbook.data.model.AddressModel;

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
	
	public String getString() {
		
		return street + " " + zip + " " + city + " " + country;
	}

	public void apply(AddressModel addressModel) {
		
		setStreet(addressModel.getStreet());
		setCity(addressModel.getCity());
		setZip(addressModel.getZip());
		setCountry(addressModel.getCountry());
		
	}
}
