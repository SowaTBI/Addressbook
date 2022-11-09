package com.sowatec.addressbook;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sowatec.addressbook.data.persistence.type.Address;
import com.sowatec.addressbook.data.persistence.type.Company;
import com.sowatec.addressbook.data.persistence.type.Contact;
import com.sowatec.addressbook.data.persistence.type.Person;

@SpringBootTest
class AddressbookApplicationTests {
	
	static Contact contact = new Contact("tim@sowatec.ch", "123-345-65454", null);
	static Address address = new Address("Neuwiesenstrasse 4", "Wallisellen", 8304, "Schweiz", null, null);
	static Address address2 = new Address("Neuwiesenstrasse 10", "Pfäffikon", 8904, "Australien", null, null);
	static Person personA = new Person("Toni", "Pirosa", null, null, null, null);
	static Person personB = new Person("Mark", "Eisen", null, null, null, null);
	
	static Company company = new Company("Sowatec", null, null);
	
	@Before
	public void before() throws IOException {
		System.out.println("\n");
	}
	
	@Test // One to One -> Person - Contact
	public void test1() throws IOException {
		
		// Get Contact
		assertNotNull("Contact has Phone ", contact.getPhone());
		System.out.println(contact.getPhone());
		
		// Person sets Contact
		personA.setContact(contact);

		// Get Person
		assertNotNull("Person has Firstname: ", personA.getFirstName());
		System.out.println(personA.getFirstName());
		
		// Person gets Contact
		assertNotNull(personA.getContact().getId());
		System.out.println(personA.getContact().getId() + ": " + personA.getContact().getEmail());
	}
	
	@Test // Many To One / One To Many -> Person to Address
	public void test2() throws IOException {
		
		// Person sets Address
		personA.setAddress(address2);
		personB.setAddress(address2);
		
		// Person gets Address
		assertNotNull(personA.getAddress().getId());
		System.out.println(personA.getFirstName() + " with address id: " + personA.getAddress().getId());
		System.out.println(personA.getAddress().getCity());
		
		// Person gets Address
		assertNotNull(personB.getAddress().getId());
		System.out.println(personB.getFirstName() + " with address id: " + personB.getAddress().getId());
		System.out.println(personB.getAddress().getCity());
	}
	
	
	@Test // One To Many / Many To One -> Company To Address
	public void test3() throws IOException {
		
		Set<Address> addressSet = new HashSet<>();
		addressSet.add(address);
		addressSet.add(address2);
		
		// Person sets Address
		company.setAddress(addressSet);
		
		
		assertNotNull(company.getName());
		System.out.println(company.getName());
		
		for (Address a : company.getAddress()) {
			
			System.out.println("Adresse: " + a.getCity());
		}
	}
	
	@Test // Many To One / One To Many -> Person To Company
	public void test4() throws IOException {
		
		// Person sets Company
		personA.setCompany(company);
		personB.setCompany(company);
		
		// Person gets Company
		assertNotNull(personA.getCompany().getId());
		System.out.println(personA.getFirstName() + ": " + personA.getCompany().getName());
		
		// Person gets Company
		assertNotNull(personB.getAddress().getId());
		System.out.println(personB.getFirstName() + ": " + personB.getCompany().getAddress());
	}
}
