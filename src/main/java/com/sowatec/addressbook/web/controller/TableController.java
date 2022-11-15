package com.sowatec.addressbook.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sowatec.addressbook.data.persistence.service.AddressService;
import com.sowatec.addressbook.data.persistence.service.ClubService;
import com.sowatec.addressbook.data.persistence.service.CompanyService;
import com.sowatec.addressbook.data.persistence.service.ContactService;
import com.sowatec.addressbook.data.persistence.service.PersonService;
import com.sowatec.addressbook.data.persistence.type.Address;
import com.sowatec.addressbook.data.persistence.type.Club;
import com.sowatec.addressbook.data.persistence.type.Company;
import com.sowatec.addressbook.data.persistence.type.Contact;
import com.sowatec.addressbook.data.persistence.type.Person;

@Controller

public class TableController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ClubService clubService;

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
	
	@GetMapping("/table-person")
	public String tablePerson(Model model) {

		Iterable<Person> iterable = personService.findAll();
		List<Person> persons = new ArrayList<>();

		Iterator<Person> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			persons.add(iterator.next());
		}

		model.addAttribute("persons", persons.toArray());

		return "page-table-person";
	}
	
	@GetMapping("/table-club")
	public String tableClub(Model model) {

		Iterable<Club> iterable = clubService.findAll();
		List<Club> clubs = new ArrayList<>();

		Iterator<Club> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			clubs.add(iterator.next());
		}

		model.addAttribute("clubs", clubs.toArray());

		return "page-table-club";
	}
	
	@GetMapping("/create-company")
	public String createCompany() {

		return "page-create-company";
	}
	
	
	// Noch zu machen
	
	@GetMapping("/create-contact")
	public String createContact() {

		return "page-create-contact";
	}
	
	@GetMapping("/create-address")
	public String createAddress() {

		return "page-create-address";
	}
	
	@GetMapping("/create-person")
	public String createPerson() {

		return "page-create-person";
	}
	
	@GetMapping("/create-club")
	public String createClub() {

		return "page-create-club";
	}
	
}
