package com.example.GetRide.DTO.request;

import com.example.GetRide.Enum.CabType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CabRequest {
    String cabNumber;

    CabType CabType;

    double farePerKm;
    
}
