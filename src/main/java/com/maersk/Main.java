package com.maersk;


public class Main {

    public static void main(String[] args) {
        BookingService bookingService = new BookingService();
        try {
            bookingService.saveBooking(new Container(Container.containerType.DIY,20,"Southampton","Singapore",5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
