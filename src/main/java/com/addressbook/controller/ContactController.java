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


    // UC2 : add contact
    @PostMapping
    public String addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }


    // UC5 : get all contacts
    @GetMapping
    public List<Contact> getContacts() {
        return contactService.getAllContacts();
    }


    // UC3 : update contact
    @PutMapping("/{firstName}")
    public String updateContact(@PathVariable String firstName,
                                @RequestBody Contact contact) {

        return contactService.updateContact(firstName, contact);
    }


    // UC4 : delete contact
    @DeleteMapping("/{firstName}")
    public String deleteContact(@PathVariable String firstName) {

        return contactService.deleteContact(firstName);
    }


    // UC6 : add contact to address book
    @PostMapping("/addressbook/{bookName}")
    public String addContactToAddressBook(@PathVariable String bookName,
                                          @RequestBody Contact contact) {

        return contactService.addContactToAddressBook(bookName, contact);
    }


    // UC6 : get contacts from address book
    @GetMapping("/addressbook/{bookName}")
    public List<Contact> getContactsFromAddressBook(@PathVariable String bookName) {

        return contactService.getContactsFromAddressBook(bookName);
    }
    
 // UC8 : search contacts by city
    @GetMapping("/city/{city}")
    public List<Contact> searchByCity(@PathVariable String city) {

        return contactService.searchByCity(city);
    }


    // UC8 : search contacts by state
    @GetMapping("/state/{state}")
    public List<Contact> searchByState(@PathVariable String state) {

        return contactService.searchByState(state);
    }
}