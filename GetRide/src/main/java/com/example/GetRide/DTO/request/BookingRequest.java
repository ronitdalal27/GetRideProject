package com.example.GetRide.DTO.request;

import com.example.GetRide.Enum.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingRequest {

    BookingStatus bookingStatus;
    int totalDistance;
    String pickUpLoc;
    String droploc;  
    String customerEmail;
}
