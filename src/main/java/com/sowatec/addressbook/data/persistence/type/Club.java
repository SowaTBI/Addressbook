package com.sowatec.addressbook.data.persistence.type;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.sowatec.addressbook.data.model.ClubModel;

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

public class Club extends BaseType {

	@Column(name = "name")
	private String name;

	// Objekt Person
	@ManyToMany
	@JoinTable(name = "club_member", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "club_id"))
	Set<Person> members;
	
	public void apply(ClubModel clubModel) {
		setName(clubModel.getName());
	}
}
