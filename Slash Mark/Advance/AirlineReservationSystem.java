package Advance;

import java.io.*;
import java.util.*;

class Flight {
    private String flightNumber;
    private String airline;
    private String origin;
    private String destination;
    private int availableSeats;

    public Flight(String flightNumber, String airline, String origin, String destination, int availableSeats) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        } else {
            System.out.println("No available seats!");
        }
    }

    public void cancelBooking() {
        availableSeats++;
    }

    @Override
    public String toString() {
        return flightNumber + "," + airline + "," + origin + "," + destination + "," + availableSeats;
    }
}

class Booking {
    private String passengerName;
    private String email;
    private String phoneNumber;
    private String panCard;
    private String address;
    private String zipCode;
    private String flightNumber;
    private String airline;

    public Booking(String passengerName, String email, String phoneNumber, String panCard, String address, String zipCode, String flightNumber, String airline) {
        this.passengerName = passengerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.panCard = panCard;
        this.address = address;
        this.zipCode = zipCode;
        this.flightNumber = flightNumber;
        this.airline = airline;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPanCard() {
        return panCard;
    }

    @Override
    public String toString() {
        return passengerName + "," + email + "," + phoneNumber + "," + panCard + "," + address + "," + zipCode + "," + flightNumber + "," + airline;
    }
}

public class AirlineReservationSystem {

    private List<Flight> flights;
    private List<Booking> bookings;

    public AirlineReservationSystem() {
        flights = new ArrayList<>();
        bookings = new ArrayList<>();
        loadFlightsFromCSV("flights.csv");
        loadBookingsFromCSV("bookings.csv");
    }

    private void loadFlightsFromCSV(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                String flightNumber = details[0];
                String airline = details[1];
                String origin = details[2];
                String destination = details[3];
                int availableSeats = Integer.parseInt(details[4]);
                flights.add(new Flight(flightNumber, airline, origin, destination, availableSeats));
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file.");
            e.printStackTrace();
        }
    }

    private void loadBookingsFromCSV(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                String passengerName = details[0];
                String email = details[1];
                String phoneNumber = details[2];
                String panCard = details[3];
                String address = details[4];
                String zipCode = details[5];
                String flightNumber = details[6];
                String airline = details[7];
                bookings.add(new Booking(passengerName, email, phoneNumber, panCard, address, zipCode, flightNumber, airline));
            }
        } catch (IOException e) {
            System.out.println("Error reading the bookings CSV file.");
            e.printStackTrace();
        }
    }

    private void saveFlightsToCSV(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Flight flight : flights) {
                bw.write(flight.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving to the CSV file.");
            e.printStackTrace();
        }
    }

    private void saveBookingsToCSV(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Booking booking : bookings) {
                bw.write(booking.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving bookings to the CSV file.");
            e.printStackTrace();
        }
    }

    public void displayAvailableFlights() {
        System.out.println("\n***************************\n***************************\n");
        System.out.println("Available Flights:");
        for (Flight flight : flights) {
            System.out.println(flight.getFlightNumber() + " | " + flight.getAirline() + " | " + flight.getOrigin() +
                               " -> " + flight.getDestination() + " | Seats: " + flight.getAvailableSeats());

        }
        System.out.println("\n***************************\n***************************\n");

    }

    public void bookFlight(String flightNumber, String passengerName, String email, String phoneNumber, String panCard, String address, String zipCode) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                flight.bookSeat();
                bookings.add(new Booking(passengerName, email, phoneNumber, panCard, address, zipCode, flightNumber, flight.getAirline()));
                System.out.println("\nBooking successful for " + passengerName + "! Remaining seats: " + flight.getAvailableSeats());
                saveFlightsToCSV("flights.csv");
                saveBookingsToCSV("bookings.csv");
                return;
            }
        }
        System.out.println("\nFlight not found!");
    }

    public void cancelBooking(String passengerName, String panCard) {
        boolean bookingFound = false;
        String flightNumberToCancel = null;
        
        // Iterate through bookings to find the match
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.getPassengerName().equals(passengerName) && booking.getPanCard().equals(panCard)) {
                flightNumberToCancel = booking.toString().split(",")[6]; // Extract flight number
                iterator.remove();
                bookingFound = true;
                System.out.println("\nPassenger's details are removed....");
                break;
            }
        }
        
        if (bookingFound && flightNumberToCancel != null) {
            // Update flight seat availability
            for (Flight flight : flights) {
                if (flight.getFlightNumber().equals(flightNumberToCancel)) {
                    flight.cancelBooking();
                    System.out.println("\nBooking canceled for " + passengerName + "! Available seats: " + flight.getAvailableSeats());
                    saveFlightsToCSV("flights.csv");
                    saveBookingsToCSV("bookings.csv");
                    return;
                }
            }
        }
        
        if (!bookingFound) {
            System.out.println("Booking not found for the provided name and PAN card.");
        }
    }

    public void displayBookingDetails() {
        System.out.println("\n***************************\n***************************\n");

        if (bookings.isEmpty()) {
            System.out.println("No Booking is avilable...!!");
        }
        else{
            System.out.println("Booking Details:");
            for (Booking booking : bookings) {
                System.out.println("Passenger Name: " + booking.getPassengerName() + " | Flight: " + booking.toString().split(",")[6] +
                                " | Airline: " + booking.toString().split(",")[7] + " | PAN Card: " + booking.getPanCard());
                        
            }
        }
        System.out.println("\n***************************\n***************************\n");
    }

    public static void main(String[] args) {
        AirlineReservationSystem system = new AirlineReservationSystem();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nAirline Reservation System:\n");

            System.out.print("Enter your name : ");
            String User = scanner.nextLine();

        
            System.out.println("1. Display available flights");
            System.out.println("2. Book a flight");
            System.out.println("3. Cancel a booking");
            System.out.println("4. Display booking details");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    system.displayAvailableFlights();
                    break;
                case 2:
                    System.out.print("\nEnter flight number to book: ");
                    String flightToBook = scanner.nextLine();
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter PAN card: ");
                    String panCard = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter ZIP code: ");
                    String zipCode = scanner.nextLine();
                    system.bookFlight(flightToBook, passengerName, email, phoneNumber, panCard, address, zipCode);
                    break;
                case 3:
                    System.out.print("Enter passenger name: ");
                    String nameToCancel = scanner.nextLine();
                    System.out.print("Enter PAN card: ");
                    String panCardToCancel = scanner.nextLine();
                    system.cancelBooking(nameToCancel, panCardToCancel);
                    break;
                case 4:
                    system.displayBookingDetails();
                    break;
                case 5:
                    System.out.printf("\nThank you %s visit again...:)\n",User);
                    scanner.close();
                    return;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
        }
    }
}
