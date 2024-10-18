# FinalProject
Programming Patterns Final Project: Arena Ticket Booking System

The Arena Ticket Booking System is an application where users can search and buy tickets for different events at an arena. The price of a ticket will depend on the section of the seat and the event type. They can select events like sports, concerts and spectacles. Technicians will handle the availability and booking of a ticket by a user and handle the transactions. The user may refund a ticket and view the tickets they bought and their transactions. 

Functionalities:

User:
- Search for ticket 
- Book Ticket 
- Refund Ticket 
- View Ticket(s) 
- View Transactions 

Technician:
- Assign tickets 
- Validate Tickets
- Handle transactions
- View Total Tickets sold and users that bought them

Classes:
User
Technician
Arena
Section
Seat
Event
Ticket
Receipt

Output:
The program begins with a log in screen where, depending on the credentials entered, the program will determine whether the user is a regular user or a technician.
If it is a user, the program will display options for the user to pick their desired ticket(s). Once validated by the technician, the user will go through the transaction to buy the ticket then the program will output the full details of the ticket and the receipt.
When a user wants to do a refund, the program will ask which ticket they want to refund, and then the technician will execute the refund and display the transaction details.
At any time, the user may view the their purchased tickets and their transactions. The technician may also at any time view the total tickets sold and the users associated with those tickets.
The program ends once the current user logs out.
