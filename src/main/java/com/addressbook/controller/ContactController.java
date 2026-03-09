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

    @PostMapping
    public String addContact(@RequestBody Contact contact) {

        return contactService.addContact(contact);
        
    }

    @GetMapping
    public List<Contact> getContacts() {
        return contactService.getAllContacts();
    }
    
    @PutMapping("/{firstName}")
    public String updateContact(@PathVariable String firstName,
                                @RequestBody Contact contact) {

        return contactService.updateContact(firstName, contact);
    }
    
    @DeleteMapping("/{firstName}")
    public String deleteContact(@PathVariable String firstName) {
        return contactService.deleteContact(firstName);
    }
}