package com.sowatec.addressbook.data.persistence.service;

import org.springframework.stereotype.Service;

import com.sowatec.addressbook.data.persistence.repository.ContactRepository;
import com.sowatec.addressbook.data.persistence.type.Contact;

@Service

public class ContactService extends BaseService<ContactRepository, Contact> {

	public ContactService(ContactRepository repository) {
		super(repository);
	}

}
