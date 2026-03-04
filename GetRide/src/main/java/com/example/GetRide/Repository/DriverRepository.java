package com.example.GetRide.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GetRide.Model.Driver;

public interface DriverRepository extends JpaRepository<Driver,Integer>{

    Driver findByMobileNo(String mobileNo);

    
}
