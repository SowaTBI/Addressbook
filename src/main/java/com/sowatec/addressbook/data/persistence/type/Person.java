package com.sowatec.addressbook.data.persistence.type;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

public class Person extends BaseType {

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	// Object Contact
	@OneToOne
	@JoinColumn(name = "contact_id")
	private Contact contact;

	// Object Address
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	// Object Company
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;

	// Verein
	@ManyToMany(mappedBy = "members")
	private List<Club> verein;

	public String getClubsAsString() {

		String[] clubNames = new String[verein.size()];
		
		for (int i = 0; i < verein.size(); i++) {
			
			clubNames[i] = verein.get(i).getName();
		}
		
		return String.join(", ", clubNames);
	}
}
