package com.example.GetRide.DTO.response;

import com.example.GetRide.Enum.CabType;

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
public class CabResponse {
    String cabNumber;

    CabType CabType;

    double farePerKm;
    boolean booked;
    
}
