package com.sowatec.addressbook.data.model;

import com.sowatec.addressbook.data.persistence.type.Address;
import com.sowatec.addressbook.data.persistence.type.Club;
import com.sowatec.addressbook.data.persistence.type.Company;
import com.sowatec.addressbook.data.persistence.type.Contact;
import com.sowatec.addressbook.data.persistence.type.Person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PersonModel {
	
	private String firstName;
	private String lastName;
	private long contactId;
	private Contact contact;
	private long addressId;
	private Address address;
	private long companyId;
	private Company company;
	private long clubId;
	private Club club;
	private long id;
	
	public boolean isValid() {

		if (firstName.isEmpty() || lastName.isEmpty()) {

			return false;
		}
		else {
			return true;
		}
	}
	
	public PersonModel(Person person) {
		
		setFirstName(person.getFirstName());
		setLastName(person.getLastName());
		setContactId(person.getContact().getId());
		setContact(person.getContact());
		setAddressId(person.getAddress().getId());
		setAddress(person.getAddress());
		setCompanyId(person.getCompany().getId());
		setCompany(person.getCompany());
		
		
		
		setId(person.getId());
	}
}