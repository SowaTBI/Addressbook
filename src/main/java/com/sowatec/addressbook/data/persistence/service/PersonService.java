package com.sowatec.addressbook.data.persistence.service;

import org.springframework.stereotype.Service;

import com.sowatec.addressbook.data.persistence.repository.PersonRepository;
import com.sowatec.addressbook.data.persistence.type.Person;

@Service
public class PersonService extends BaseService<PersonRepository, Person> {
	
	public PersonService(PersonRepository repository) {
		super(repository);
	}

}

/*
@Service
public class ServiceUserProfile {
    @Autowired
    private RepoUserProfile repo;

    public List<UserProfile> listUserProfile() {
        return repo.listUserProfile();
    }
}
*/
