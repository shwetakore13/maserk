package com.maersk;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class BookingService {

    public ResponseDto saveBooking(Container container) throws Exception{
        //call another web url
        URL url = new URL("https://www.maersk.com/api/bookings/checkAvailable");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        InputStream responseStream = connection.getInputStream();

        ObjectMapper mapper = new ObjectMapper();
        AvailableDto apod = mapper.readValue(responseStream, AvailableDto.class);

        if (apod.getAvailableSpace()==0){
            return new ResponseDto(false);
        }
        return new ResponseDto(true);
    }
}
