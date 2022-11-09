package com.sowatec.addressbook.data.persistence.repository;

import org.springframework.stereotype.Repository;

import com.sowatec.addressbook.data.persistence.type.Contact;

@Repository

public interface ContactRepository extends BaseRepository<Contact> {

}
