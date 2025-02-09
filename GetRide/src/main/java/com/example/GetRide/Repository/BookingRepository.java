package com.example.GetRide.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GetRide.Model.BookingCab;

public interface BookingRepository extends JpaRepository<BookingCab,Integer>{

    
}
