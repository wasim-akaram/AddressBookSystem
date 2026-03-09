package com.addressbook.service;

import com.addressbook.model.Contact;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
    
 // UC10 : sort contacts by name
    public List<Contact> sortContactsByName() {

        List<Contact> sortedContacts = new ArrayList<>(contacts);

        sortedContacts.sort(Comparator.comparing(Contact::getFirstName));

        return sortedContacts;
    }
    
 // UC11 : sort contacts by city
    public List<Contact> sortContactsByCity() {

        List<Contact> sortedContacts = new ArrayList<>(contacts);

        sortedContacts.sort(Comparator.comparing(Contact::getCity));

        return sortedContacts;
    }


    // UC11 : sort contacts by state
    public List<Contact> sortContactsByState() {

        List<Contact> sortedContacts = new ArrayList<>(contacts);

        sortedContacts.sort(Comparator.comparing(Contact::getState));

        return sortedContacts;
    }


    // UC11 : sort contacts by zip
    public List<Contact> sortContactsByZip() {

        List<Contact> sortedContacts = new ArrayList<>(contacts);

        sortedContacts.sort(Comparator.comparing(Contact::getZip));

        return sortedContacts;
    }
    
 // UC12 : write contacts to file
    public String writeContactsToFile() {

        String fileName = "contacts.txt";

        try {

            FileWriter writer = new FileWriter(fileName);

            for (Contact contact : contacts) {

                writer.write(
                        contact.getFirstName() + "," +
                        contact.getLastName() + "," +
                        contact.getCity() + "," +
                        contact.getState() + "\n"
                );
            }

            writer.close();

            return "Contacts successfully written to file";

        } catch (IOException e) {

            return "Error writing contacts to file";
        }
    }
    
 // UC13 : read contacts from file
    public String readContactsFromFile() {

        String fileName = "contacts.txt";

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Contact contact = new Contact();
                contact.setFirstName(data[0]);
                contact.setLastName(data[1]);
                contact.setCity(data[2]);
                contact.setState(data[3]);

                contacts.add(contact);
            }

            reader.close();

            return "Contacts loaded successfully from file";

        } catch (IOException e) {

            return "Error reading contacts from file";
        }
    }
    
 // UC14 : write contacts to CSV file
    public String writeContactsToCSV() {

        String fileName = "contacts.csv";

        try {

            FileWriter writer = new FileWriter(fileName);

            // header
            writer.append("firstName,lastName,city,state\n");

            for (Contact contact : contacts) {

                writer.append(contact.getFirstName())
                      .append(",")
                      .append(contact.getLastName())
                      .append(",")
                      .append(contact.getCity())
                      .append(",")
                      .append(contact.getState())
                      .append("\n");
            }

            writer.close();

            return "Contacts successfully written to CSV file";

        } catch (IOException e) {

            return "Error writing contacts to CSV file";
        }
    }
    
 // UC15 : read contacts from CSV
    public String readContactsFromCSV() {

        String fileName = "contacts.csv";

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            // skip header
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Contact contact = new Contact();

                contact.setFirstName(data[0]);
                contact.setLastName(data[1]);
                contact.setCity(data[2]);
                contact.setState(data[3]);

                contacts.add(contact);
            }

            reader.close();

            return "Contacts successfully loaded from CSV file";

        } catch (IOException e) {

            return "Error reading contacts from CSV file";
        }
    }
 // UC16 : write contacts to JSON
    public String writeContactsToJSON() {

        String fileName = "contacts.json";

        try {

            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.writeValue(new File(fileName), contacts);

            return "Contacts successfully written to JSON file";

        } catch (IOException e) {

            return "Error writing contacts to JSON file";
        }
    }
    
 // UC17 : read contacts from JSON
    public String readContactsFromJSON() {

        String fileName = "contacts.json";

        try {

            ObjectMapper objectMapper = new ObjectMapper();

            Contact[] loadedContacts =
                    objectMapper.readValue(new File(fileName), Contact[].class);

            contacts.addAll(Arrays.asList(loadedContacts));

            return "Contacts successfully loaded from JSON file";

        } catch (IOException e) {

            return "Error reading contacts from JSON file";
        }
    }
    
 // UC18 : save contact to database
    public String saveContactToDatabase(Contact contact) {

        String url = "jdbc:mysql://localhost:3306/addressbook_db";
        String user = "root";
        String password = "yourpassword";

        try {

            Connection connection =
                    DriverManager.getConnection(url, user, password);

            String sql =
                    "INSERT INTO contacts(first_name, last_name, city, state) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, contact.getFirstName());
            statement.setString(2, contact.getLastName());
            statement.setString(3, contact.getCity());
            statement.setString(4, contact.getState());

            statement.executeUpdate();

            connection.close();

            return "Contact saved to database successfully";

        } catch (Exception e) {

            return "Error saving contact to database";
        }
    }
    
 // UC19 : fetch contacts from database
    public List<Contact> getContactsFromDatabase() {

        String url = "jdbc:mysql://localhost:3306/addressbook_db";
        String user = "root";
        String password = "yourpassword";

        List<Contact> dbContacts = new ArrayList<>();

        try {

            Connection connection =
                    DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM contacts";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Contact contact = new Contact();

                contact.setFirstName(resultSet.getString("first_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setCity(resultSet.getString("city"));
                contact.setState(resultSet.getString("state"));

                dbContacts.add(contact);
            }

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return dbContacts;
    }
    
 // UC20 : update contact in database
    public String updateContactInDatabase(String firstName, Contact updatedContact) {

        String url = "jdbc:mysql://localhost:3306/addressbook_db";
        String user = "root";
        String password = "yourpassword";

        try {

            Connection connection =
                    DriverManager.getConnection(url, user, password);

            String sql =
                    "UPDATE contacts SET last_name=?, city=?, state=? WHERE first_name=?";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, updatedContact.getLastName());
            statement.setString(2, updatedContact.getCity());
            statement.setString(3, updatedContact.getState());
            statement.setString(4, firstName);

            int rowsUpdated = statement.executeUpdate();

            connection.close();

            if (rowsUpdated > 0) {
                return "Contact updated successfully in database";
            } else {
                return "Contact not found in database";
            }

        } catch (Exception e) {

            return "Error updating contact in database";
        }
    }
    
 // UC21 : delete contact from database
    public String deleteContactFromDatabase(String firstName) {

        String url = "jdbc:mysql://localhost:3306/addressbook_db";
        String user = "root";
        String password = "yourpassword";

        try {

            Connection connection =
                    DriverManager.getConnection(url, user, password);

            String sql = "DELETE FROM contacts WHERE first_name=?";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, firstName);

            int rowsDeleted = statement.executeUpdate();

            connection.close();

            if (rowsDeleted > 0) {
                return "Contact deleted successfully from database";
            } else {
                return "Contact not found in database";
            }

        } catch (Exception e) {

            return "Error deleting contact from database";
        }
    }
    
 // UC22 : add multiple contacts using threads
    public String addMultipleContacts(List<Contact> newContacts) {

        List<Thread> threads = new ArrayList<>();

        for (Contact contact : newContacts) {

            Thread thread = new Thread(() -> {

                synchronized (this) {
                    contacts.add(contact);
                    System.out.println("Added contact: " + contact.getFirstName());
                }

            });

            threads.add(thread);
            thread.start();
        }

        // wait for all threads
        for (Thread thread : threads) {

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "All contacts added using multithreading";
    }
    
 // UC23 : add contacts with performance measurement
    public String addContactsWithPerformance(List<Contact> newContacts) {

        long startTime = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<>();

        for (Contact contact : newContacts) {

            Thread thread = new Thread(() -> {

                synchronized (this) {
                    contacts.add(contact);
                    System.out.println("Added contact: " + contact.getFirstName());
                }

            });

            threads.add(thread);
            thread.start();
        }

        // wait for all threads to complete
        for (Thread thread : threads) {

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;

        return "Contacts added in " + duration + " ms using multithreading";
    }
 
    
}