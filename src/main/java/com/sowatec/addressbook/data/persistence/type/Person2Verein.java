package com.sowatec.addressbook.data.persistence.type;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
//@Entity
@Getter
@Setter
@ToString
@Embeddable

public class Person2Verein extends BaseType implements Serializable {
	
    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;

    @ManyToOne
    @JoinColumn(name = "verein_id")
    Verein verein;
}
