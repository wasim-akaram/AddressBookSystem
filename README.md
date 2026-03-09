# Address Book – UC24

## Description

UC24 implements the functionality to **ensure thread-safe operations while adding multiple contacts concurrently**.
This use case improves the multithreading implementation by using a synchronized list to safely handle concurrent modifications to the contact collection.

The system ensures that when multiple threads attempt to add contacts simultaneously, the shared data structure remains consistent and free from race conditions.

## API Endpoint

**POST /contacts/multi/threadsafe**
Adds multiple contacts to the address book using thread-safe operations.

## Components Involved

**Service**

* `ContactService` – Implements thread-safe contact addition using a synchronized list.

**Controller**

* `ContactController` – Provides the API endpoint for submitting contacts to be processed concurrently in a thread-safe manner.

## Status

UC24 implemented successfully.


# Address Book – UC23

## Description

UC23 implements the functionality to **measure the performance of adding multiple contacts using multithreading**.
This use case evaluates how concurrent processing affects the time taken to add multiple contacts to the Address Book.

The system records the start and end time of the operation and calculates the total duration required to add all contacts using threads.

## API Endpoint

**POST /contacts/multi/performance**
Adds multiple contacts using multithreading and returns the time taken to complete the operation.

## Components Involved

**Service**

* `ContactService` – Contains the logic for creating threads and measuring the execution time of concurrent contact additions.

**Controller**

* `ContactController` – Provides the API endpoint for triggering the multithreaded operation and returning the performance result.

## Status

UC23 implemented successfully.


# Address Book – UC22

## Description

UC22 implements the functionality to **add multiple contacts to the Address Book using multithreading**.
This use case demonstrates how the system can handle concurrent operations by creating separate threads to process multiple contact additions simultaneously.

The system creates multiple threads, each responsible for adding a contact, and ensures thread-safe operations while updating the contact list.

## API Endpoint

**POST /contacts/multi**
Adds multiple contacts to the address book concurrently using threads.

## Components Involved

**Service**

* `ContactService` – Contains the logic to create and manage threads for adding multiple contacts.

**Controller**

* `ContactController` – Provides the API endpoint for submitting multiple contacts to be processed concurrently.

## Status

UC22 implemented successfully.


# Address Book – UC21

## Description

UC21 implements the functionality to **delete an existing contact from the database using JDBC**.
This use case allows users to remove a contact record stored in the database.

The system connects to the database, executes a delete query on the contacts table, and removes the corresponding record if the contact exists.

## API Endpoint

**DELETE /contacts/db/{firstName}**
Deletes a contact from the database based on the provided first name.

## Components Involved

**Service**

* `ContactService` – Contains the JDBC logic to delete contact data from the database.

**Controller**

* `ContactController` – Provides the API endpoint for deleting contacts from the database.

## Status

UC21 implemented successfully.


# Address Book – UC20

## Description

UC20 implements the functionality to **update an existing contact in the database using JDBC**.
This use case allows users to modify stored contact information such as last name, city, or state directly in the database.

The system connects to the database, executes an update query on the contacts table, and updates the corresponding record if the contact exists.

## API Endpoint

**PUT /contacts/db/{firstName}**
Updates the details of a contact stored in the database.

## Components Involved

**Service**

* `ContactService` – Contains the JDBC logic to update contact data in the database.

**Controller**

* `ContactController` – Provides the API endpoint for updating contacts in the database.

## Status

UC20 implemented successfully.


# Address Book – UC19

## Description

UC19 implements the functionality to **retrieve contacts stored in the database using JDBC**.
This use case allows the application to fetch contact records from the database and return them to the user.

The system connects to the database, executes a query to retrieve contact information from the contacts table, converts the result into contact objects, and returns the list of contacts.

## API Endpoint

**GET /contacts/db**
Retrieves all contacts stored in the database.

## Components Involved

**Service**

* `ContactService` – Contains the JDBC logic to fetch contact data from the database.

**Controller**

* `ContactController` – Provides the API endpoint for retrieving contacts from the database.

## Status

UC19 implemented successfully.



# Address Book – UC18

## Description

UC18 implements the functionality to **store Address Book contacts in a database using JDBC**.
This use case introduces database persistence, allowing contact information to be saved in a relational database instead of only being stored in memory or files.

The system establishes a connection to the database and inserts contact records into the contacts table.

## API Endpoint

**POST /contacts/db**
Saves a contact to the database.

## Components Involved

**Service**

* `ContactService` – Contains the JDBC logic to insert contact data into the database.

**Controller**

* `ContactController` – Provides the API endpoint for storing contacts in the database.

## Status

UC18 implemented successfully.


# Address Book – UC17

## Description

UC17 implements the functionality to **read contacts from a JSON file and load them into the Address Book**.
This use case enables the application to retrieve previously stored contact data from a JSON file and restore it into the system.

The system reads the JSON file, converts the stored data into contact objects, and adds them to the address book.

## API Endpoint

**GET /contacts/read/json**
Reads contacts from the JSON file and loads them into the address book.

## Components Involved

**Service**

* `ContactService` – Contains the logic to read and parse contact data from a JSON file.

**Controller**

* `ContactController` – Provides the API endpoint for triggering the JSON file read operation.

## Status

UC17 implemented successfully.


# Address Book – UC16

## Description

UC16 implements the functionality to **write Address Book contacts to a JSON file**.
This use case allows the application to export contact data in JSON format, which is widely used in modern web services and APIs.

The system converts the stored contacts into JSON and saves them to a file.

## API Endpoint

**GET /contacts/write/json**
Writes all contacts from the address book into a JSON file.

## Components Involved

**Service**

* `ContactService` – Contains the logic to convert contact data into JSON and write it to a file.

**Controller**

* `ContactController` – Provides the API endpoint for triggering the JSON file write operation.

## Status

UC16 implemented successfully.


# Address Book – UC15

## Description

UC15 implements the functionality to **read contacts from a CSV (Comma Separated Values) file and load them into the Address Book**.
This use case enables the application to retrieve previously stored contact information from a CSV file and restore it into the system.

The system reads the CSV file, processes each record, converts it into a contact object, and adds it to the address book.

## API Endpoint

**GET /contacts/read/csv**
Reads contacts from the CSV file and loads them into the address book.

## Components Involved

**Service**

* `ContactService` – Contains the logic to read and parse contact data from a CSV file.

**Controller**

* `ContactController` – Provides the API endpoint for triggering the CSV file read operation.

## Status

UC15 implemented successfully.


# Address Book – UC14

## Description

UC14 implements the functionality to **write Address Book contacts to a CSV (Comma Separated Values) file**.
This use case allows the application to export contact data in a structured format that can be easily used by tools such as spreadsheets or data processing systems.

The system converts the stored contact information into CSV format and writes it to a file.

## API Endpoint

**GET /contacts/write/csv**
Writes all contacts from the address book into a CSV file.

## Components Involved

**Service**

* `ContactService` – Contains the logic to convert contact data into CSV format and write it to a file.

**Controller**

* `ContactController` – Provides the API endpoint for triggering the CSV file write operation.

## Status

UC14 implemented successfully.


# Address Book – UC13

## Description

UC13 implements the functionality to **read contacts from a file and load them into the Address Book**.
This use case allows the application to retrieve previously stored contact data from a file and restore it into the system.

The system reads the file line by line, converts the stored data into contact objects, and adds them to the address book.

## API Endpoint

**GET /contacts/read**
Reads contacts from the file and loads them into the address book.

## Components Involved

**Service**

* `ContactService` – Contains the logic to read contact data from a file.

**Controller**

* `ContactController` – Provides the API endpoint for triggering the file read operation.

## Status

UC13 implemented successfully.


# Address Book – UC12

## Description

UC12 implements the functionality to **write Address Book contacts to a file**.
This use case enables the application to store contact information in a file, allowing the data to be saved outside the application's memory.

The system processes the list of stored contacts and writes their details into a text file.

## API Endpoint

**GET /contacts/write**
Writes all contacts from the address book into a file.

## Components Involved

**Service**

* `ContactService` – Contains the logic to write contact data to a file.

**Controller**

* `ContactController` – Provides the API endpoint for triggering the file write operation.

## Status

UC12 implemented successfully.


# Address Book – UC11

## Description

UC11 implements the functionality to **sort contacts in the Address Book based on City, State, or Zip code**.
This use case allows users to retrieve contacts in an organized order depending on the selected field.

The system processes the stored contacts and returns them sorted according to the specified attribute.

## API Endpoints

**GET /contacts/sorted/city**
Returns contacts sorted by city.

**GET /contacts/sorted/state**
Returns contacts sorted by state.

**GET /contacts/sorted/zip**
Returns contacts sorted by zip code.

## Components Involved

**Service**

* `ContactService` – Contains the logic to sort contacts by city, state, or zip.

**Controller**

* `ContactController` – Provides REST API endpoints for retrieving sorted contact lists.

## Status

UC11 implemented successfully.


# Address Book – UC10

## Description

UC10 implements the functionality to **sort contacts in the Address Book alphabetically by name**.
This use case allows users to retrieve contacts in a sorted order based on the contact's first name.

The system processes the stored contacts and returns them in ascending alphabetical order.

## API Endpoint

**GET /contacts/sorted/name**
Returns the list of contacts sorted alphabetically by first name.

## Components Involved

**Service**

* `ContactService` – Contains the logic to sort contacts.

**Controller**

* `ContactController` – Exposes the API endpoint for retrieving sorted contacts.

## Status

UC10 implemented successfully.


# Address Book – UC9

## Description

UC9 implements the functionality to **view the count of contacts based on City or State** in the Address Book.
This use case allows users to determine how many contacts belong to a particular city or state.

The system scans the stored contacts and returns the **total number of contacts** that match the specified city or state. This feature helps users quickly understand the distribution of contacts across different locations.

## API Endpoints

**GET /contacts/city/{city}/count**
Returns the number of contacts that belong to the specified city.

**GET /contacts/state/{state}/count**
Returns the number of contacts that belong to the specified state.

## Components Involved

**Model**

* `Contact` – Represents the structure of contact information.

**Service**

* `ContactService` – Contains the logic to count contacts by city or state.

**Controller**

* `ContactController` – Provides REST API endpoints for retrieving contact counts.

## Status

UC9 implemented successfully.


# Address Book – UC8

## Description

UC8 implements the functionality to **search contacts in the Address Book based on City or State**.
This use case allows users to filter and retrieve contacts by specifying a city or state value.

The system scans the stored contacts and returns the list of contacts that match the given city or state. This feature helps users quickly locate contacts belonging to a specific location.

## API Endpoints

**GET /contacts/city/{city}**
Retrieves all contacts that belong to the specified city.

**GET /contacts/state/{state}**
Retrieves all contacts that belong to the specified state.

## Components Involved

**Model**

* `Contact` – Represents the structure of contact information.

**Service**

* `ContactService` – Contains the logic to filter contacts by city or state.

**Controller**

* `ContactController` – Provides REST API endpoints for searching contacts.

## Status

UC8 implemented successfully.


# Address Book – UC7

## Description

UC7 implements the functionality to **prevent duplicate contacts from being added to the Address Book**.
Before adding a new contact, the system checks whether a contact with the same **first name already exists**.

If a duplicate contact is found, the system prevents the addition and returns an appropriate message. This validation ensures that the address book maintains unique contact entries and avoids storing repeated information.

Duplicate validation is applied both when adding contacts to the **main contact list** and when adding contacts to a **specific address book**.

## API Endpoints

**POST /contacts**
Adds a new contact to the address book after checking for duplicates.

**POST /contacts/addressbook/{bookName}**
Adds a new contact to a specific address book after validating that the contact does not already exist.

## Components Involved

**Model**

* `Contact` – Represents the contact data structure.

**Service**

* `ContactService` – Contains the logic to detect duplicate contacts before storing them.

**Controller**

* `ContactController` – Provides REST API endpoints for adding contacts.

## Status

UC7 implemented successfully.


# Address Book – UC6

## Description

UC6 implements the functionality to **manage multiple Address Books within the application**.
Instead of storing all contacts in a single list, the system now supports multiple address books, each identified by a unique name.

Each address book can contain its own list of contacts. Users can add contacts to a specific address book and retrieve all contacts belonging to that address book.

This feature improves organization by allowing contacts to be grouped into categories such as **home, office, or friends**.

## API Endpoints

**POST /contacts/addressbook/{bookName}**
Adds a new contact to the specified address book.

**GET /contacts/addressbook/{bookName}**
Retrieves all contacts stored in the specified address book.

## Components Involved

**Model**

* `Contact` – Defines the structure of contact information.

**Service**

* `ContactService` – Manages multiple address books and handles storing and retrieving contacts.

**Controller**

* `ContactController` – Provides REST API endpoints for interacting with contacts within specific address books.

## Status

UC6 implemented successfully.


# Address Book – UC5

## Description

UC5 implements the functionality to **store and manage multiple contacts in the Address Book**.
This use case allows the system to handle multiple persons by storing contact details in a collection.

Each contact added through the API is stored in an in-memory list, allowing the address book to maintain and retrieve multiple contacts.

## API Endpoints

**POST /contacts**
Adds a new contact to the address book.

**GET /contacts**
Retrieves the list of all contacts stored in the address book.

## Components Involved

**Model**

* `Contact` – Defines the structure of contact information.

**Service**

* `ContactService` – Manages the list of contacts and handles the logic for adding and retrieving multiple contacts.

**Controller**

* `ContactController` – Provides REST API endpoints for adding and viewing contacts.

## Status

UC5 implemented successfully.


# Address Book – UC4

## Description

UC4 implements the functionality to **delete an existing contact from the Address Book**.
This use case allows users to remove a contact from the system when it is no longer needed.

The application searches for a contact using the **first name**. If the contact exists in the address book, it is removed from the stored contact list. If the contact does not exist, the system returns a message indicating that the contact was not found.

## API Endpoints

**DELETE /contacts/{firstName}**
Deletes an existing contact from the address book.

**GET /contacts**
Retrieves all contacts stored in the address book.

## Components Involved

**Model**

* `Contact` – Defines the structure of contact information.

**Service**

* `ContactService` – Contains the logic to locate and remove a contact from the list.

**Controller**

* `ContactController` – Exposes the REST API endpoint for deleting contacts.

## Status

UC4 implemented successfully.


# Address Book – UC3

## Description

UC3 implements the functionality to **edit or update an existing contact in the Address Book**.
This use case allows users to modify previously stored contact information such as address, city, state, zip code, phone number, or email.

The system searches for a contact using the **first name** and updates the corresponding fields with the new information provided. If the contact exists, the details are updated successfully; otherwise, the system returns a message indicating that the contact was not found.

## API Endpoints

**PUT /contacts/{firstName}**
Updates the details of an existing contact in the address book.

**GET /contacts**
Retrieves the list of all contacts stored in the address book.

## Components Involved

**Model**

* `Contact` – Defines the structure of contact information.

**Service**

* `ContactService` – Contains the logic to search and update an existing contact.

**Controller**

* `ContactController` – Exposes the REST API endpoint for updating contact details.

## Status

UC3 implemented successfully.
---





# Address Book – UC2

## Description

UC2 implements the functionality to **add a new contact to the Address Book**.
This use case allows users to create and store contact information in the system.

Each contact contains basic personal details such as first name, last name, address, city, state, zip code, phone number, and email. The contact is stored in memory and can be retrieved through the application's API.

## API Endpoints

**POST /contacts**
Adds a new contact to the address book.

**GET /contacts**
Retrieves all contacts stored in the address book.

## Components Involved

**Model**

* `Contact` – Represents the contact data structure.

**Service**

* `ContactService` – Handles the business logic for storing and retrieving contacts.

**Controller**

* `ContactController` – Exposes REST API endpoints for interacting with the address book.

## Status

UC2 implemented successfully.
