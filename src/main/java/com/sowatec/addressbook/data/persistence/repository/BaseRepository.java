package com.sowatec.addressbook.data.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.sowatec.addressbook.data.persistence.type.BaseType;

public interface BaseRepository <Type extends BaseType> extends CrudRepository<Type, Long> {
	
}
