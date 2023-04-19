package com.sowatec.addressbook.data.model;

import com.sowatec.addressbook.data.persistence.type.Club;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ClubModel {

	private String name;
	private long id;

	public boolean isValid() {

		if (name == null) {

			return false;
		}
		else if (name.length() < 3) {

			return false;
		}

		else if (name.length() > 30) {

			return false;
		}
		else {
			return true;
		}
	}
	
	public ClubModel(Club club) {
		setName(club.getName());
		setId(club.getId());
	}
	
}
