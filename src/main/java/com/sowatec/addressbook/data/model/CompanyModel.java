package com.sowatec.addressbook.data.model;

import com.sowatec.addressbook.data.persistence.type.Address;
import com.sowatec.addressbook.data.persistence.type.Company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CompanyModel {
	
	private String name;
	private long addressId;
	private long id;
	private Address address;
	
	public boolean isValid() {
		

		if (name.isEmpty()) {
			
			return false;
		}
		else {
			return true;
		}
	}
	
	public CompanyModel(Company company) {
		setName(company.getName());
		setAddressId(company.getAddress().getId());
		setId(company.getId());
		setAddress(company.getAddress());
	}
}
