package com.sowatec.addressbook.data.persistence.service;

import org.springframework.stereotype.Service;

import com.sowatec.addressbook.data.persistence.repository.Person2VereinRepository;
import com.sowatec.addressbook.data.persistence.type.Person2Verein;

//@Service

public class Person2VereinService extends BaseService<Person2VereinRepository, Person2Verein> {

	public Person2VereinService(Person2VereinRepository repository) {
		super(repository);
	}
}
