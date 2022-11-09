package com.sowatec.addressbook.data.persistence.service;

import java.util.Optional;

import com.sowatec.addressbook.data.persistence.repository.BaseRepository;
import com.sowatec.addressbook.data.persistence.type.BaseType;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public abstract class BaseService<Repository extends BaseRepository<Type>, Type extends BaseType>
		implements BaseRepository<Type> {

	protected Repository repository;

	@Override
	public <S extends Type> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public <S extends Type> Iterable<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public Optional<Type> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	@Override
	public Iterable<Type> findAll() {
		return repository.findAll();
	}

	@Override
	public Iterable<Type> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(Type entity) {
		repository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		repository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Type> entities) {
		repository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

}
