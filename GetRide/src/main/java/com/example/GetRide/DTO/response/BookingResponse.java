package com.example.GetRide.DTO.response;

import java.util.Date;

import com.example.GetRide.Enum.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {

    BookingStatus bookingStatus;
    String bookingId;
    Date bookedAt;
    int totalDistance;
    double totalFare;
    String pickUpLoc;
    String droploc;  
    
    CustomerResponse customerResponse;

    DriverResponse driverResponse;
}
