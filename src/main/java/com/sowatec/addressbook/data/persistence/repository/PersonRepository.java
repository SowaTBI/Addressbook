package com.sowatec.addressbook.data.persistence.repository;

import org.springframework.stereotype.Repository;

import com.sowatec.addressbook.data.persistence.type.Person;

@Repository
public interface PersonRepository extends BaseRepository<Person>  {


/*
 * Example from the internet
    @Query("SELECT new com.example.projectx.UserDto(u,s.name) FROM UserProfile u INNER JOIN u.status s")
    public List<UserDto> getUserDtos();
 */
}
