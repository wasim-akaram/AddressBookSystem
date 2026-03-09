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
