package com.example.GetRide.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "fullname") //now name column will be set as fullname in database
    String name;

    int age;

    @Column(unique = true,nullable = false)
    String drivingLicense;

    @Column(unique = true,nullable = false)
    long mobileNo;

    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    Cab cab;
    
    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    @JsonIgnore
    List<BookingCab> bookingCabs;
}
