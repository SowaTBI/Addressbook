package com.sowatec.addressbook.data.persistence.service;

import org.springframework.stereotype.Service;

import com.sowatec.addressbook.data.persistence.repository.ClubRepository;
import com.sowatec.addressbook.data.persistence.type.Club;

@Service

public class ClubService extends BaseService<ClubRepository, Club> {

	public ClubService(ClubRepository repository) {
		super(repository);
	}

}
