package com.sowatec.addressbook.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sowatec.addressbook.data.persistence.service.AddressService;
import com.sowatec.addressbook.data.persistence.service.CompanyService;
import com.sowatec.addressbook.data.persistence.service.ContactService;
import com.sowatec.addressbook.data.persistence.type.Address;
import com.sowatec.addressbook.data.persistence.type.Company;
import com.sowatec.addressbook.data.persistence.type.Contact;

@Controller

public class TableController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private CompanyService companyService;

	@GetMapping("/table-contact")
	public String tableContact(Model model) {

		Iterable<Contact> iterable = contactService.findAll();
		List<Contact> contacts = new ArrayList<>();

		Iterator<Contact> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			contacts.add(iterator.next());
		}

		model.addAttribute("contacts", contacts.toArray());

		return "page-table-contact";
	}
	
	@GetMapping("/table-address")
	public String tableAddress(Model model) {

		Iterable<Address> iterable = addressService.findAll();
		List<Address> addresses = new ArrayList<>();

		Iterator<Address> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			addresses.add(iterator.next());
		}

		model.addAttribute("addresses", addresses.toArray());

		return "page-table-address";
	}
	
	@GetMapping("/table-company")
	public String tableCompany(Model model) {

		Iterable<Company> iterable = companyService.findAll();
		List<Company> companies = new ArrayList<>();

		Iterator<Company> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			companies.add(iterator.next());
		}

		model.addAttribute("companies", companies.toArray());

		return "page-table-company";
	}
}
