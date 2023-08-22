import enums.ModeOfPayment;
import enums.SizeCategory;
import models.*;
import services.*;

import java.util.List;

public class ParkingLotMain {
    public static void main(String[] args) {
        System.out.println("Pass the capacity of the spots in the parkingLot in the initializeValues() below this print statement");
        initializeValues(100);
        ParkingLot parkingLot = new ParkingLot("Park A Lot", "abc road, xyz nagar, near pqr", 100, "7886387922");
//----------------------------------------------------------------------------------------------------------------------------

//        creating sample owners

        Owner owner1 = OwnerService.createOwner("Akash", "8888888888", "M", 34);
        Owner owner2 = OwnerService.createOwner("Aakansha", "9999999999", "F", 28);
        Owner owner3 = OwnerService.createOwner("Rajesh", "9123456709", "M", 29);
        Owner owner4 = OwnerService.createOwner("Priya", "8888456709", "M", 25);
        Owner owner5 = OwnerService.createOwner("Aditya", "9999912349", "M", 33);

//----------------------------------------------------------------------------------------------------------------------------

//        creating sample vehicles

        Vehicle vehicle1 = VehicleService.createCar("White", "Maharashtra", SizeCategory.MEDIUM, owner1, EntranceService.getEntrances().get(0), "Hundai", 4);
        Vehicle vehicle2 = VehicleService.createCar("Blue", "Gujrat", SizeCategory.MEDIUM, owner2, EntranceService.getEntrances().get(0), "Maruti Suzuki", 4);
        Vehicle vehicle3 = VehicleService.createVehicle("","White", "Punjab", SizeCategory.HUGE, owner3, EntranceService.getEntrances().get(2), "Tata", 8);
        Vehicle vehicle4 = VehicleService.createCar("Black", "Karnataka", SizeCategory.LARGE, owner4, EntranceService.getEntrances().get(1), "Bajaj", 7);
        Vehicle vehicle5 = VehicleService.createCar("Black", "TamilNadu", SizeCategory.MEDIUM, owner5, EntranceService.getEntrances().get(3), "Thar", 6);

//----------------------------------------------------------------------------------------------------------------------------

//        find nearest spot for the vehicles

        Spot spot1 = SpotService.findNearestSpot(vehicle1);
        try{
            SpotService.setVehicleOnSpot(spot1, vehicle1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Spot spot2 = SpotService.findNearestSpot(vehicle2);
        try{
            SpotService.setVehicleOnSpot(spot2, vehicle2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Spot spot3 = SpotService.findNearestSpot(vehicle3);
        try{
            SpotService.setVehicleOnSpot(spot3, vehicle3);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Spot spot4 = SpotService.findNearestSpot(vehicle4);
        try{
            SpotService.setVehicleOnSpot(spot4, vehicle4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Spot spot5 = SpotService.findNearestSpot(vehicle5);
        try{
            SpotService.setVehicleOnSpot(spot5, vehicle5);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


//----------------------------------------------------------------------------------------------------------------------------

//        create tickets for the vehicles

        Ticket ticket1 = TicketService.createTicket(vehicle1, spot1);
        Ticket ticket2 = TicketService.createTicket(vehicle2, spot2);
        Ticket ticket3 = TicketService.createTicket(vehicle3, spot3);
        Ticket ticket4 = TicketService.createTicket(vehicle4, spot4);
        Ticket ticket5 = TicketService.createTicket(vehicle5, spot5);

//----------------------------------------------------------------------------------------------------------------------------

//        create tickets for the vehicles

        Payment payment1 = PaymentService.makePayment(ticket1, ModeOfPayment.CASH);
        Payment payment2 = PaymentService.makePayment(ticket2, ModeOfPayment.CREDIT_CARD);
        Payment payment3 = PaymentService.makePayment(ticket3, ModeOfPayment.CASH);
        Payment payment4 = PaymentService.makePayment(ticket4, ModeOfPayment.UPI);
        Payment payment5 = PaymentService.makePayment(ticket5, ModeOfPayment.DEBIT_CARD);

//----------------------------------------------------------------------------------------------------------------------------

//        OWNER TESTS
//        trying to create same owner again
        System.out.println("\n\n OWNER TESTS");
        try{
            Owner owner = OwnerService.createOwner("Rajesh", "9123456709", "M", 29);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //        trying to create owner illegal age
        try{
            Owner owner = OwnerService.createOwner("Rohit", "8394755670", "M", 15);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //        trying to create owner invalid phone no length
        try{
            Owner owner = OwnerService.createOwner("Rohit", "8394422755670", "M", 15);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


//----------------------------------------------------------------------------------------------------------------------------

//        VEHICLE TESTS

//        trying to create vehicle invalid sizeCategory
        System.out.println("\n\n VEHICLE TESTS");
        try{
            Vehicle JCB = VehicleService.createVehicle("","White", "Punjab", null, owner3, EntranceService.getEntrances().get(2), "Tata", 8);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //        trying to create vehicle with empty entrance value
        try{
            Vehicle Bus = VehicleService.createVehicle("Bus","Red", "Assam", SizeCategory.HUGE, owner2, null, "Tata", 30);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //        trying to create vehicle with no owner
        try{
            Vehicle audi = VehicleService.createVehicle("Car","Red", "Punjab", SizeCategory.MEDIUM, null, EntranceService.getEntrances().get(3), "Audi", 5);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


//----------------------------------------------------------------------------------------------------------------------------

//        SPOT TESTS

//        trying to get spot of vehicle with null value
        System.out.println("\n\n SPOT TESTS");
        try{
            Spot spot = SpotService.findNearestSpot(null);
            SpotService.setVehicleOnSpot(spot, vehicle1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

//        Overloading spots capacity. Reduce initialCapacity to 6 or 7 to get test this testcase
        try{
//            Vehicle Bus = VehicleService.createVehicle("Bus","Red", "Assam", SizeCategory.HUGE, owner2, null, "Tata", 30);
            Spot spot = SpotService.findNearestSpot(vehicle2);
            SpotService.setVehicleOnSpot(spot, vehicle2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

//        Overloading spots capacity Reduce initialCapacity to 6 or 7 to get test this testcase
        try{
//            Vehicle audi = VehicleService.createVehicle("Car","Red", "Punjab", SizeCategory.MEDIUM, null, EntranceService.getEntrances().get(3), "Audi", 5);
            Spot spot = SpotService.findNearestSpot(vehicle3);
            SpotService.setVehicleOnSpot(spot, vehicle1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

//----------------------------------------------------------------------------------------------------------------------------


//        TICKET TESTS

//        trying to create ticket for null spot
        System.out.println("\n\n TICKET TESTS");
        try{
            Ticket ticket = TicketService.createTicket(vehicle1, null);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

//        trying to create ticket for null vehicle
        try{
            Ticket ticket = TicketService.createTicket(null, spot2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
//----------------------------------------------------------------------------------------------------------------------------


//        PAYMENT TESTS

//        trying to create ticket for null spot

        System.out.println("\n\n PAYMENT TESTS");
        try{
            Payment payment = PaymentService.makePayment(ticket1, null);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

//        trying to create ticket for null vehicle
        try{
            Payment payment = PaymentService.makePayment(null, ModeOfPayment.CASH);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

//----------------------------------------------------------------------------------------------------------------------------

//        QUERIES
//        * Registration numbers of all cars of a particular Color.
//        * Ticket number in which a car with a given registration number is placed.
//        * Ticket numbers of all ticket where a car of a particular color is placed.
        System.out.println("\n\n\n");

        Vehicle vehicle6 = VehicleService.createCar("White", "WestBengal", SizeCategory.MEDIUM, owner5, EntranceService.getEntrances().get(2), "Thar", 6);
        // Attendant recevies the car and generates ticket and calls the Payment Service and park the vehicle
        AttendantService.receiveVehicle(vehicle6);


//        1. Registration numbers of all cars of a particular Color.
        try {
            System.out.println();
            System.out.println("1. Registration numbers of all cars of a particular Color:");
            List<String> registrationNos = VehicleService.getRegistrationOfVehicleByColor("White");
            registrationNos.forEach(regNo -> System.out.println(regNo));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        //        2. Ticket number in which a car with a given registration number is placed.
        try {
            System.out.println();
            System.out.println("2. Ticket number in which a car with a given registration number is placed:");
            System.out.println(TicketService.getTicketNoByRegistrationNo(vehicle6.getRegistrationNo()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        //        3. Ticket numbers of all ticket where a car of a particular color is placed.
        try {
            System.out.println();
            System.out.println("3. Ticket numbers of all ticket where a car of a particular color is placed:");
            List<Integer> ticketNos =  TicketService.getTicketNoByVehicleColor("white");
            ticketNos.forEach(ticketNo -> System.out.println(ticketNo));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    public static void initializeValues(int spotCapacity){
        EntranceService.initializeEntrances();
        SpotService.initializeSpots(spotCapacity);
    }


}