#Project_Overview:

Name: Airline Reservation System

Description:
The Airline Reservation System is a Java-based application designed to manage flight bookings. It allows users to view available flights, book and cancel flights, and view booking details. The system reads and writes flight and booking information to CSV files, enabling persistent data storage. It handles basic operations such as booking flights, canceling bookings, and displaying flight and booking details.

Features:

    Display available flights.
    Book a flight with passenger details.
    Cancel a booking using passenger name and PAN card.
    Display booking details.
    Persist flight and booking data in CSV files.

Algorithm

    Initialize System:
        Load flights from flights.csv.
        Load bookings from bookings.csv.

    Display Available Flights:
        Iterate through the list of flights.
        Print flight details (flight number, airline, origin, destination, available seats).

    Book a Flight:
        Prompt user for flight number and passenger details.
        Check if the flight exists.
        If available, book the seat and add the booking to the list.
        Update flight and booking CSV files.

    Cancel a Booking:
        Prompt user for passenger name and PAN card.
        Search for the booking.
        If found, remove the booking from the list and update seat availability.
        Update flight and booking CSV files.

    Display Booking Details:
        Check if there are bookings.
        Print details of all bookings.
        If no bookings, display "No Booking Details Available."

    Exit System:
        Close scanner and terminate the application.

Flowchart

Start
|
|---> Initialize System
| |
| |---> Load Flights from flights.csv
| |---> Load Bookings from bookings.csv
|
|---> Display Main Menu
| |
| |---> [1] Display Available Flights
| |---> [2] Book a Flight
| |---> [3] Cancel a Booking
| |---> [4] Display Booking Details
| |---> [5] Exit System
|
|---> Case [1]: Display Available Flights
| |
| |---> Print Flight Details
|
|---> Case [2]: Book a Flight
| |
| |---> Prompt User for Details
| |---> Find Flight and Book Seat
| |---> Add Booking to List
| |---> Update flights.csv and bookings.csv
|
|---> Case [3]: Cancel a Booking
| |
| |---> Prompt User for Name and PAN Card
| |---> Find and Remove Booking
| |---> Update Flight Seat Availability
| |---> Update flights.csv and bookings.csv
|
|---> Case [4]: Display Booking Details
| |
| |---> Check for Bookings
| |---> Print Booking Details or Display "No Booking Details Available"
|
|---> Case [5]: Exit System
| |
| |---> Close Scanner
| |---> Terminate Application
|
End
Key Points to Note:

    CSV File Handling: The system uses CSV files to store flight and booking data. Flights and bookings are loaded from and saved to these files.
    User Interaction: Users interact with the system through a command-line interface, making choices from a menu.
    Error Handling: Basic error handling is implemented for file operations and user input.