package com.sowatec.addressbook.data.persistence.type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sowatec.addressbook.data.model.CompanyModel;

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


public class Company extends BaseType {
	
	@Column(name="name")
	private String name;
    
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;
	
	
	public void apply(CompanyModel companyModel) {
		setName(companyModel.getName());
		setAddress(companyModel.getAddress());
	}
	
}
