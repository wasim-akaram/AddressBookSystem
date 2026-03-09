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
