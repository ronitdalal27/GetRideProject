package com.example.GetRide.Transformers;

import java.util.UUID;

import com.example.GetRide.DTO.request.BookingRequest;
import com.example.GetRide.DTO.response.BookingResponse;
import com.example.GetRide.Enum.BookingStatus;
import com.example.GetRide.Model.BookingCab;
import com.example.GetRide.Model.Cab;

public class BookingTransformer {

    public static BookingCab bookingRequestToBooking(BookingRequest bookingRequest,Cab cab){
        return BookingCab.builder()
                         .bookingId(String.valueOf(UUID.randomUUID()))
                         .bookingStatus(BookingStatus.CONFIRMED)
                         .pickUpLoc(bookingRequest.getPickUpLoc())
                         .droploc(bookingRequest.getDroploc())
                         .totalFare(cab.getFarePerKm() * bookingRequest.getTotalDistance())
                         .totalDistance(bookingRequest.getTotalDistance())
                         .build();
    }

    public static BookingResponse bookingToBookingResponse(BookingCab booking) {
        return BookingResponse.builder()
                              .bookingId(booking.getBookingId())
                              .bookedAt(booking.getBookedAt())
                              .bookingStatus(booking.getBookingStatus())
                              .totalDistance(booking.getTotalDistance())
                              .droploc(booking.getDroploc())
                              .pickUpLoc(booking.getPickUpLoc())
                              .totalFare(booking.getTotalFare())
                              .customerResponse(CustomerTransformer.customerToCustomerResponse(booking.getCustomer()))
                              .driverResponse(DriverTransformer.driverToDriverResponse(booking.getDriver()))
                              .build();
    }
    
}
