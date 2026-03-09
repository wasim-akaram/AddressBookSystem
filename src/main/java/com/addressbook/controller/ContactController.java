package com.addressbook.controller;

import com.addressbook.model.Contact;
import com.addressbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    // UC2 - Add contact
    @PostMapping
    public String addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    // UC5 - Get all contacts
    @GetMapping
    public List<Contact> getContacts() {
        return contactService.getAllContacts();
    }

    // UC3 - Update contact
    @PutMapping("/{firstName}")
    public String updateContact(@PathVariable String firstName,
                                @RequestBody Contact contact) {

        return contactService.updateContact(firstName, contact);
    }

    // UC4 - Delete contact
    @DeleteMapping("/{firstName}")
    public String deleteContact(@PathVariable String firstName) {

        return contactService.deleteContact(firstName);
    }

    // UC6 - Add contact to specific address book
    @PostMapping("/addressbook/{bookName}")
    public String addContactToAddressBook(@PathVariable String bookName,
                                          @RequestBody Contact contact) {

        return contactService.addContactToAddressBook(bookName, contact);
    }

    // UC6 - Get contacts from specific address book
    @GetMapping("/addressbook/{bookName}")
    public List<Contact> getContactsFromAddressBook(@PathVariable String bookName) {

        return contactService.getContactsFromAddressBook(bookName);
    }
}