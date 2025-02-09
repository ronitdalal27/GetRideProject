package com.example.GetRide.DTO.response;

import com.example.GetRide.Enum.Gender;

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
public class CustomerResponse {
    
    private String name;
    private Gender gender;
    private String emailID;
}
