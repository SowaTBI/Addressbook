package com.sowatec.addressbook.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sowatec.addressbook.data.model.AddressModel;
import com.sowatec.addressbook.data.model.ClubModel;
import com.sowatec.addressbook.data.model.CompanyModel;
import com.sowatec.addressbook.data.model.ContactModel;
import com.sowatec.addressbook.data.model.PersonModel;
import com.sowatec.addressbook.data.persistence.repository.AddressRepository;
import com.sowatec.addressbook.data.persistence.repository.ClubRepository;
import com.sowatec.addressbook.data.persistence.repository.CompanyRepository;
import com.sowatec.addressbook.data.persistence.repository.ContactRepository;
import com.sowatec.addressbook.data.persistence.repository.PersonRepository;
import com.sowatec.addressbook.data.persistence.service.AddressService;
import com.sowatec.addressbook.data.persistence.service.CompanyService;
import com.sowatec.addressbook.data.persistence.service.ContactService;
import com.sowatec.addressbook.data.persistence.type.Address;
import com.sowatec.addressbook.data.persistence.type.Club;
import com.sowatec.addressbook.data.persistence.type.Company;
import com.sowatec.addressbook.data.persistence.type.Contact;
import com.sowatec.addressbook.data.persistence.type.Person;
import com.sowatec.addressbook.util.Util;

@Controller
public class UpdateController {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private ClubRepository clubRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private AddressService addressService;
	
	
	@GetMapping("/update-address/{id}")
	public String updateAddressForm(@PathVariable("id") long id, Model model) {
		
	    Address address = addressRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    
	    model.addAttribute("AddressModel", new AddressModel(address));
	    return "page-update-address";
	}
	
	@GetMapping("/update-contact/{id}")
	public String updateContactForm(@PathVariable("id") long id, Model model) {
		
	    Contact contact = contactRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    
	    model.addAttribute("ContactModel", new ContactModel(contact));
	    return "page-update-contact";
	}
	
	@GetMapping("/update-club/{id}")
	public String updateClubForm(@PathVariable("id") long id, Model model) {
		
	    Club club = clubRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    
	    model.addAttribute("ClubModel", new ClubModel(club));
	    return "page-update-club";
	}
	
	@GetMapping("/update-company/{id}")
	public String updateCompanyForm(@PathVariable("id") long id, Model model) {
		
	    Company company = companyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    
	    model.addAttribute("CompanyModel", new CompanyModel(company));
		model.addAttribute("Addresses", Util.iterableToList(addressService.findAll()));
	    
	    return "page-update-company";
	}
	
	@GetMapping("/update-person/{id}")
	public String updatePersonForm(@PathVariable("id") long id, Model model) {
		
	    Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    
	    model.addAttribute("PersonModel", new PersonModel(person));
		model.addAttribute("Contacts", Util.iterableToList(contactService.findAll()));
		model.addAttribute("Addresses", Util.iterableToList(addressService.findAll()));
		model.addAttribute("Companies", Util.iterableToList(companyService.findAll()));
	    
	    return "page-update-person";
	}
	
	
	
	
	
	@PostMapping("/update-address/{id}/submit")
	public String updateAddressSubmit(@PathVariable("id") long id, @ModelAttribute AddressModel addressModel, BindingResult result, Model model) {
	    
		Address address = addressRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		address.apply(addressModel);
		addressRepository.save(address);
		
	    return "redirect:/table-address";
	}
	
	
	@PostMapping("/update-contact/{id}/submit")
	public String updateContactSubmit(@PathVariable("id") long id, @ModelAttribute ContactModel contactModel, BindingResult result, Model model) {
	    
		Contact contact = contactRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		contact.apply(contactModel);
		contactRepository.save(contact);
		
	    return "redirect:/table-contact";
	}
	
	
	@PostMapping("/update-club/{id}/submit")
	public String updateContactSubmit(@PathVariable("id") long id, @ModelAttribute ClubModel clubModel, BindingResult result, Model model) {
	    
		Club club = clubRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		club.apply(clubModel);
		clubRepository.save(club);
		
	    return "redirect:/table-club";
	}
	
	
	@PostMapping("/update-company/{id}/submit")
	public String updateCompanySubmit(@PathVariable("id") long id, @ModelAttribute CompanyModel companyModel, BindingResult result, Model model) {
	    
		Company company = companyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		Address address = addressService.findById(companyModel.getAddressId()).get();
		
		companyModel.setAddress(address);
		company.apply(companyModel);

		companyRepository.save(company);
		
	    return "redirect:/table-company";
	    
	}
	
	
	@PostMapping("/update-person/{id}/submit")
	public String updatePersonSubmit(@PathVariable("id") long id, @ModelAttribute PersonModel personModel, BindingResult result, Model model) {
	    
		Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		
		Contact contact = contactService.findById(personModel.getContactId()).get();
		Address address = addressService.findById(personModel.getAddressId()).get();
		Company company = companyService.findById(personModel.getCompanyId()).get();
		
		personModel.setContact(contact);
		personModel.setAddress(address);
		personModel.setCompany(company);
		
		person.apply(personModel);

		personRepository.save(person);
		
	    return "redirect:/table-person";
	    
	}
	
	
}
