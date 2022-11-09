package com.sowatec.addressbook.data.persistence.service;

import org.springframework.stereotype.Service;

import com.sowatec.addressbook.data.persistence.repository.CompanyRepository;
import com.sowatec.addressbook.data.persistence.type.Company;

@Service

public class CompanyService extends BaseService<CompanyRepository, Company> {

	public CompanyService(CompanyRepository repository) {
		super(repository);
	}

}
