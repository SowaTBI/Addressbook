package com.sowatec.addressbook.data.persistence.service;

import java.util.Optional;

import com.sowatec.addressbook.data.persistence.repository.BaseRepository;
import com.sowatec.addressbook.data.persistence.type.BaseType;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j

public abstract class BaseService<Repository extends BaseRepository<Type>, Type extends BaseType>
		implements BaseRepository<Type> {

	protected Repository repository;

	@Override
	public <S extends Type> S save(S entity) {
		log.info("{}::save", this.getClass().getSimpleName());
		return repository.save(entity);
	}

	@Override
	public <S extends Type> Iterable<S> saveAll(Iterable<S> entities) {
		log.info("{}::saveAll", this.getClass().getSimpleName());
		return repository.saveAll(entities);
	}

	@Override
	public Optional<Type> findById(Long id) {
		log.info("{}::findById", this.getClass().getSimpleName());
		return repository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		log.info("{}::existsById", this.getClass().getSimpleName());
		return repository.existsById(id);
	}

	@Override
	public Iterable<Type> findAll() {
		log.info("{}::findAll", this.getClass().getSimpleName());
		return repository.findAll();
	}

	@Override
	public Iterable<Type> findAllById(Iterable<Long> ids) {
		log.info("{}::findAllById", this.getClass().getSimpleName());
		return repository.findAllById(ids);
	}

	@Override
	public long count() {
		log.info("{}::count", this.getClass().getSimpleName());
		return repository.count();
	}

	@Override
	public void deleteById(Long id) {
		log.info("{}::deleteById", this.getClass().getSimpleName());
		repository.deleteById(id);
	}

	@Override
	public void delete(Type entity) {
		log.info("{}::delete", this.getClass().getSimpleName());
		repository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		log.info("{}::deleteAllById", this.getClass().getSimpleName());
		repository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Type> entities) {
		log.info("{}::deleteAll", this.getClass().getSimpleName());
		repository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		log.info("{}::deleteAll", this.getClass().getSimpleName());
		repository.deleteAll();
	}

}
