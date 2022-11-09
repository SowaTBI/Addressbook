package com.sowatec.addressbook.data.persistence.type;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public abstract class BaseType {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
}
