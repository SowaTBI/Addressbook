package com.sowatec.addressbook.data.persistence.service;

import org.springframework.stereotype.Service;

import com.sowatec.addressbook.data.persistence.repository.VereinRepository;
import com.sowatec.addressbook.data.persistence.type.Verein;

@Service

public class VereinService extends BaseService<VereinRepository, Verein> {

	public VereinService(VereinRepository repository) {
		super(repository);
	}

}
