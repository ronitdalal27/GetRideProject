package com.example.GetRide.Transformers;

import com.example.GetRide.DTO.request.CabRequest;
import com.example.GetRide.DTO.response.CabResponse;
import com.example.GetRide.Model.Cab;

public class CabTransformer {

    public static Cab CabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                  .CabType(cabRequest.getCabType())
                  .cabNumber(cabRequest.getCabNumber())
                  .farePerKm(cabRequest.getFarePerKm())
                  .booked(false)
                  .build();
    }

    public static CabResponse cabToCabResponse(Cab cab) {
        return CabResponse.builder()
                          .cabNumber(cab.getCabNumber())
                          .CabType(cab.getCabType())
                          .booked(cab.isBooked())
                          .farePerKm(cab.getFarePerKm())
                          .build();
    }
    
}
