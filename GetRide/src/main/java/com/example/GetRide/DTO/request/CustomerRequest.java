package com.example.GetRide.DTO.request;

import com.example.GetRide.Enum.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 1, message = "Age must be greater than or equal to 1")
    @Max(value = 120, message = "Age cannot exceed 120")
    private int age;

    @NotNull(message = "Gender cannot be null")
    private Gender gender;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String emailID;
}

