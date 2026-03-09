package com.addressbook.service;

import com.addressbook.model.Contact;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContactService {

    // UC2–UC5 : store contacts
    private List<Contact> contacts = new ArrayList<>();

    // UC6 : multiple address books
    private Map<String, List<Contact>> addressBooks = new HashMap<>();


    // UC2 + UC7 : Add contact with duplicate check
    public String addContact(Contact contact) {

        for (Contact existingContact : contacts) {

            if (existingContact.getFirstName()
                    .equalsIgnoreCase(contact.getFirstName())) {

                return "Duplicate contact found. Contact already exists.";
            }
        }

        contacts.add(contact);
        return "Contact added successfully";
    }


    // UC5 : get all contacts
    public List<Contact> getAllContacts() {
        return contacts;
    }


    // UC3 : update contact
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


    // UC4 : delete contact
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


    // UC6 + UC7 : add contact to address book with duplicate check
    public String addContactToAddressBook(String bookName, Contact contact) {

        List<Contact> bookContacts =
                addressBooks.computeIfAbsent(bookName, k -> new ArrayList<>());

        for (Contact existingContact : bookContacts) {

            if (existingContact.getFirstName()
                    .equalsIgnoreCase(contact.getFirstName())) {

                return "Duplicate contact found in " + bookName + " address book";
            }
        }

        bookContacts.add(contact);

        return "Contact added to " + bookName + " address book";
    }


    // UC6 : get contacts from address book
    public List<Contact> getContactsFromAddressBook(String bookName) {

        return addressBooks.getOrDefault(bookName, new ArrayList<>());
    }
    
 // UC8 : search contacts by city
    public List<Contact> searchByCity(String city) {

        List<Contact> result = new ArrayList<>();

        for (Contact contact : contacts) {

            if (contact.getCity().equalsIgnoreCase(city)) {
                result.add(contact);
            }
        }

        return result;
    }


    // UC8 : search contacts by state
    public List<Contact> searchByState(String state) {

        List<Contact> result = new ArrayList<>();

        for (Contact contact : contacts) {

            if (contact.getState().equalsIgnoreCase(state)) {
                result.add(contact);
            }
        }

        return result;
    }
    
 // UC9 : count contacts by city
    public long countByCity(String city) {

        long count = 0;

        for (Contact contact : contacts) {

            if (contact.getCity().equalsIgnoreCase(city)) {
                count++;
            }
        }

        return count;
    }


    // UC9 : count contacts by state
    public long countByState(String state) {

        long count = 0;

        for (Contact contact : contacts) {

            if (contact.getState().equalsIgnoreCase(state)) {
                count++;
            }
        }

        return count;
    }
    
}