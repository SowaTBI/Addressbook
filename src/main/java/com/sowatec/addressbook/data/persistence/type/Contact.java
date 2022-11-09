package com.sowatec.addressbook.data.persistence.type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

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

public class Contact extends BaseType {
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
    @OneToOne(mappedBy = "contact")
    private Person person;
}
