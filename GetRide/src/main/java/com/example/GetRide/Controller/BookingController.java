package com.example.GetRide.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.GetRide.DTO.request.BookingRequest;
import com.example.GetRide.DTO.response.BookingResponse;
import com.example.GetRide.Service.BookingService;

@RestController
@RequestMapping("/api/v1/book")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping
    public ResponseEntity bookCab(@RequestBody BookingRequest bookingRequest){ //passing cabrequest just to calculate total fare of bookingrequest coz cabrequest has fareperkm
        try{
            BookingResponse response = bookingService.bookCab(bookingRequest);
            return new ResponseEntity(response,HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    
}
