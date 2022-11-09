package com.sowatec.addressbook.data.persistence.type;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Verein extends BaseType {

	@Column(name = "name")
	private String name;

	// Objekt Person
    @ManyToMany()
    Set<Person> person;
}
