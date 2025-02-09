package com.example.GetRide.Model;
import com.example.GetRide.Enum.CabType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String cabNumber;

    @Enumerated(EnumType.STRING)
    CabType CabType;

    double farePerKm;
    boolean booked;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    Driver driver;

}
