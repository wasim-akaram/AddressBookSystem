package com.addressbook.service;

import com.addressbook.model.Contact;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContactService {

    // Existing list for UC2–UC5
    private List<Contact> contacts = new ArrayList<>();

    // New structure for UC6
    private Map<String, List<Contact>> addressBooks = new HashMap<>();


    // UC2 - Add contact
    public String addContact(Contact contact) {
        contacts.add(contact);
        return "Contact added successfully";
    }

    // UC5 - Get all contacts
    public List<Contact> getAllContacts() {
        return contacts;
    }

    // UC3 - Update contact
    public String updateContact(String firstName, Contact updatedContact) {

        for (Contact contact : contacts) {

            if (contact.getFirstName().equalsIgnoreCase(firstName)) {

                contact.setLastName(updatedContact.getLastName());
                contact.setAddress(updatedContact.getAddress());
                contact.setCity(updatedContact.getCity());
                contact.setState(updatedContact.getState());
                contact.setZip(updatedContact.getZip());
                contact.setPhoneNumber(updatedContact.getPhoneNumber());
                contact.setEmail(updatedContact.getEmail());

                return "Contact updated successfully";
            }
        }

        return "Contact not found";
    }

    // UC4 - Delete contact
    public String deleteContact(String firstName) {

        Iterator<Contact> iterator = contacts.iterator();

        while (iterator.hasNext()) {

            Contact contact = iterator.next();

            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                iterator.remove();
                return "Contact deleted successfully";
            }
        }

        return "Contact not found";
    }

    // UC6 - Add contact to specific address book
    public String addContactToAddressBook(String bookName, Contact contact) {

        addressBooks
                .computeIfAbsent(bookName, k -> new ArrayList<>())
                .add(contact);

        return "Contact added to " + bookName + " address book";
    }

    // UC6 - Get contacts from address book
    public List<Contact> getContactsFromAddressBook(String bookName) {

        return addressBooks.getOrDefault(bookName, new ArrayList<>());
    }
}