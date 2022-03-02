package com.maersk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;


@RestController
@RequestMapping("/api/bookings")
public class BookingController<RestController> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);


    @Autowired
    private BookingService  bookingService;

    @PostMapping
    public ResponseDto saveBooking(@RequestBody Container container) throws Exception{
        LOGGER.info("save booking");
        ResponseDto response = bookingService.saveBooking(container);
        LOGGER.info("Booking saved successfully");
        return response;
    }
}
