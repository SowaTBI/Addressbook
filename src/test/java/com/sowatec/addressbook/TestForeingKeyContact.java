package com.sowatec.addressbook;

import java.io.IOException;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.context.IContext;

import com.sowatec.addressbook.data.persistence.service.PersonService;
import com.sowatec.addressbook.data.persistence.type.Contact;
import com.sowatec.addressbook.data.persistence.type.Person;

public class TestForeingKeyContact implements IContext {

	private static boolean setUpIsDone = false;

	@Autowired
    private PersonService service;
	
	@Before
	public void setUp() {

		if (setUpIsDone) {
			System.out.println("Setup");
			return;
		} else {
			setUpIsDone = true;
		}
	}

	@Test
	public void test1() throws IOException {
		
		Contact contact = new Contact();
		contact.setPhone("123-345-65454");

		// Add new Employee object
		Person person = new Person();
		person.setFirstName("Mark");
		person.getContact().getPhone();

		// Save Contact
		service.save(person);
		Assertions.assertNotNull(contact.getId());

		// Save Employee
		person.setContact(contact);
		
		service.save(person);
		Assertions.assertNotNull(person.getId());
		Assertions.assertNotNull(person.getContact().getId());
	}
	

	@After
	public void after() {
		System.out.println("Everything went well\n");
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsVariable(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<String> getVariableNames() {
		// TODO Auto-generated method stub
		return Collections.emptySet();
	}

	@Override
	public Object getVariable(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Test
	public void test2() throws IOException {
		System.out.println("mach was");
	}
}
