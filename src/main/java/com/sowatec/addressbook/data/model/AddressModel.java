package com.sowatec.addressbook.data.model;

import com.sowatec.addressbook.data.persistence.type.Address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddressModel {

	private String street;
	private String city;
	private int zip;
	private String country;
	private long id;
	
	public boolean isValid() {
		
		String zipNew = String.valueOf(zip);
		
		if (street.isEmpty() || city.isEmpty() || country.isEmpty() || zipNew.isEmpty()) {

			return false;
		}
		else {
			return true;	
		}
	}
	
	
	public AddressModel(Address address) {
		setCity(address.getCity());
		setCountry(address.getCountry());
		setZip(address.getZip());
		setStreet(address.getStreet());
		setId(address.getId());
	}
}
