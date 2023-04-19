package com.sowatec.addressbook.data.model;

import com.sowatec.addressbook.data.persistence.type.Contact;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ContactModel {

	private String email;
	private String phone;
	private long id;
	
	public boolean isValid() {
		

		if (email.isEmpty() || phone.isEmpty()) {

			return false;
		}
		else {
			return true;
		}
	}
	
	public ContactModel(Contact contact) {
		setEmail(contact.getEmail());
		setPhone(contact.getPhone());
		setId(contact.getId());
	}
}