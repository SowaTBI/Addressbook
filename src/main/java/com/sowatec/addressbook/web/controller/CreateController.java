package com.sowatec.addressbook.web.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sowatec.addressbook.data.model.AddressModel;
import com.sowatec.addressbook.data.model.ClubModel;
import com.sowatec.addressbook.data.model.CompanyModel;
import com.sowatec.addressbook.data.model.ContactModel;
import com.sowatec.addressbook.data.model.PersonModel;
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
import com.sowatec.addressbook.util.Util;

@Controller
public class CreateController {

	@Autowired
	private ClubService clubService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private ContactService contactService;

	@Autowired
	private PersonService personService;

	@GetMapping("/create-company")
	public String createCompany(Model model) {

		model.addAttribute("CompanyModel", new CompanyModel());
		model.addAttribute("Addresses", Util.iterableToList(addressService.findAll()));
		return "page-create-company";
	}

	@GetMapping("/create-contact")
	public String createContact(Model model) {

		model.addAttribute("ContactModel", new ContactModel());
		return "page-create-contact";
	}

	@GetMapping("/create-address")
	public String createAddress(Model model) {

		model.addAttribute("AddressModel", new AddressModel());
		return "page-create-address";
	}

	@GetMapping("/create-person")
	public String createPerson(Model model) {
		
		model.addAttribute("PersonModel", new PersonModel());
		model.addAttribute("Contacts", Util.iterableToList(contactService.findAll()));
		model.addAttribute("Addresses", Util.iterableToList(addressService.findAll()));
		model.addAttribute("Companies", Util.iterableToList(companyService.findAll()));
		model.addAttribute("Clubs", Util.iterableToList(clubService.findAll()));
		return "page-create-person";
	}

	@GetMapping("/create-club")
	public String createClub(Model model) {

		model.addAttribute("ClubModel", new ClubModel());
		return "page-create-club";
	}

	@PostMapping("/create-club/submit")
	public String createClubSubmit(@ModelAttribute ClubModel clubModel, Model model) {

		if (clubModel.isValid()) {

			clubService.save(new Club(clubModel.getName(), Collections.emptySet()));
			return "redirect:/table-club";
		} else {
			return "redirect:/create-club";
		}
	}

	@PostMapping("/create-address/submit")
	public String createAddressSubmit(@ModelAttribute AddressModel addressModel, Model model) {

		if (addressModel.isValid()) {

			addressService.save(new Address(addressModel.getStreet(), addressModel.getCity(), addressModel.getZip(),
					addressModel.getCountry()));
			return "redirect:/table-address";
		} else {
			return "redirect:/create-address";
		}
	}

	@PostMapping("/create-contact/submit")
	public String createContactSubmit(@ModelAttribute ContactModel contactModel, Model model) {

		if (contactModel.isValid()) {

			contactService.save(new Contact(contactModel.getEmail(), contactModel.getPhone()));

			return "redirect:/table-contact";
		} else {
			return "redirect:/create-contact";
		}
	}

	@PostMapping("/create-company/submit")
	public String createCompanySubmit(@ModelAttribute CompanyModel companyModel, Model model) {

		if (companyModel.isValid()) {

			if (addressService.findById(companyModel.getAddressId()).isPresent()) {

				companyService.save(new Company(companyModel.getName(),
						addressService.findById(companyModel.getAddressId()).get()));
			} else {

				return "redirect:/create-company";
			}

			return "redirect:/table-company";

		} else {

			return "redirect:/create-company";
		}
	}

	@PostMapping("/create-person/submit")
	public String createPersonSubmit(@ModelAttribute PersonModel personModel, Model model) {

		if (personModel.isValid()) {

			if (contactService.findById(personModel.getContactId()).isPresent() ||
					addressService.findById(personModel.getAddressId()).isPresent() ||
					companyService.findById(personModel.getCompanyId()).isPresent() ||
					clubService.findById(personModel.getCompanyId()).isPresent()) {
				
				personService.save(new Person(personModel.getFirstName(), personModel.getLastName(),
						contactService.findById(personModel.getContactId()).get(),
						addressService.findById(personModel.getAddressId()).get(),
						companyService.findById(personModel.getCompanyId()).get(),
						List.of(clubService.findById(personModel.getClubId()).get())));

			}  

			else {

				return "redirect:/create-company";
			}

			return "redirect:/table-person";
		} else {
			return "redirect:/create-person";
		}
	}

}
