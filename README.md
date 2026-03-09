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
