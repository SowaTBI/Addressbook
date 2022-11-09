package com.sowatec.addressbook.data.persistence.service;

import org.springframework.stereotype.Service;

import com.sowatec.addressbook.data.persistence.repository.AddressRepository;
import com.sowatec.addressbook.data.persistence.type.Address;

@Service

public class AddressService extends BaseService<AddressRepository, Address> {

	public AddressService(AddressRepository repository) {
		super(repository);
	}

}
