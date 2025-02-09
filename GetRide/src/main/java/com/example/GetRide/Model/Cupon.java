package com.example.GetRide.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "coupon_details")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Cupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String cuponCode;
    int precentageDiscount;    
}
