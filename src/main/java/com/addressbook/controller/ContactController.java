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

        contactService.addContact(contact);
        return "Contact added successfully";
    }

    @GetMapping
    public List<Contact> getContacts() {
        return contactService.getAllContacts();
    }
}