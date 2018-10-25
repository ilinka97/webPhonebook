package org.bildit.dao;

import java.util.ArrayList;
import org.bildit.model.Contact;
import org.bildit.model.User;

public interface ContactDAO {

	boolean addContact(Contact contact);
	boolean editContact(Contact contact);
	boolean deleteContact(Contact contact);
	ArrayList<Contact> getAllContactsByUser(User user);
	Contact getContactByName(String contactName);
	Contact getContactById(int id);
}
