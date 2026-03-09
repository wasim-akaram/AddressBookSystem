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
    
 // UC9 : count contacts by city
    @GetMapping("/city/{city}/count")
    public long countByCity(@PathVariable String city) {

        return contactService.countByCity(city);
    }


    // UC9 : count contacts by state
    @GetMapping("/state/{state}/count")
    public long countByState(@PathVariable String state) {

        return contactService.countByState(state);
    }
    
 // UC10 : get contacts sorted by name
    @GetMapping("/sorted/name")
    public List<Contact> sortContactsByName() {

        return contactService.sortContactsByName();
    }
    
 // UC11 : sort contacts by city
    @GetMapping("/sorted/city")
    public List<Contact> sortContactsByCity() {

        return contactService.sortContactsByCity();
    }


    // UC11 : sort contacts by state
    @GetMapping("/sorted/state")
    public List<Contact> sortContactsByState() {

        return contactService.sortContactsByState();
    }


    // UC11 : sort contacts by zip
    @GetMapping("/sorted/zip")
    public List<Contact> sortContactsByZip() {

        return contactService.sortContactsByZip();
    }
    
 // UC12 : write contacts to file
    @GetMapping("/write")
    public String writeContactsToFile() {

        return contactService.writeContactsToFile();
    }
 // UC13 : read contacts from file
    @GetMapping("/read")
    public String readContactsFromFile() {

        return contactService.readContactsFromFile();
    }
    
 // UC14 : write contacts to CSV
    @GetMapping("/write/csv")
    public String writeContactsToCSV() {

        return contactService.writeContactsToCSV();
    }
    
 // UC15 : read contacts from CSV
    @GetMapping("/read/csv")
    public String readContactsFromCSV() {

        return contactService.readContactsFromCSV();
    }
    
 // UC16 : write contacts to JSON
    @GetMapping("/write/json")
    public String writeContactsToJSON() {

        return contactService.writeContactsToJSON();
    }
    
 // UC17 : read contacts from JSON
    @GetMapping("/read/json")
    public String readContactsFromJSON() {

        return contactService.readContactsFromJSON();
    }
    
 // UC18 : save contact to database
    @PostMapping("/db")
    public String saveContactToDatabase(@RequestBody Contact contact) {

        return contactService.saveContactToDatabase(contact);
    }
    
 // UC19 : fetch contacts from database
    @GetMapping("/db")
    public List<Contact> getContactsFromDatabase() {

        return contactService.getContactsFromDatabase();
    }
    
 // UC20 : update contact in database
    @PutMapping("/db/{firstName}")
    public String updateContactInDatabase(@PathVariable String firstName,
                                          @RequestBody Contact contact) {

        return contactService.updateContactInDatabase(firstName, contact);
    }
    
 // UC21 : delete contact from database
    @DeleteMapping("/db/{firstName}")
    public String deleteContactFromDatabase(@PathVariable String firstName) {

        return contactService.deleteContactFromDatabase(firstName);
    }
    
 // UC22 : add multiple contacts
    @PostMapping("/multi")
    public String addMultipleContacts(@RequestBody List<Contact> contacts) {

        return contactService.addMultipleContacts(contacts);
    }
    
 // UC23 : performance measurement
    @PostMapping("/multi/performance")
    public String addContactsWithPerformance(@RequestBody List<Contact> contacts) {

        return contactService.addContactsWithPerformance(contacts);
    }
    
 // UC24 : thread-safe API
    @PostMapping("/multi/threadsafe")
    public String addContactsThreadSafe(@RequestBody List<Contact> contacts) {

        return contactService.addContactsThreadSafe(contacts);
    }
}