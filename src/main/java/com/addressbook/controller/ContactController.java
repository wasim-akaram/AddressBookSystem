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
    private ContactService service;

    @PostMapping
    public String addContact(@RequestBody Contact contact) {
        service.addContact(contact);
        return "Contact Added Successfully";
    }

    @GetMapping
    public List<Contact> getContacts() {
        return service.getContacts();
    }
}