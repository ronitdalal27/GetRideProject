package com.example.GetRide.Model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.example.GetRide.Enum.BookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class BookingCab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String bookingId; //UUID,while setting this typecast to String

    @Enumerated(EnumType.STRING)
    BookingStatus bookingStatus;

    @CreationTimestamp
    Date bookedAt; //no need to set this bcoz Database will set this

    int totalDistance;
    double totalFare;
    String pickUpLoc;
    String droploc;  
    
    @ManyToOne
    @JoinColumn
    Customer customer;

    @ManyToOne
    @JoinColumn
    Driver driver;
}
