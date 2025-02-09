package com.example.GetRide.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.GetRide.Model.Cab;



public interface CabRepository extends JpaRepository<Cab,Integer>{

    @Query(value = "select * from cab where booked = 0 order by rand() limit 1",nativeQuery = true) //this query will give any random 1 cab which is available 
    Optional<Cab> getRandomAvailableCab();

    
}
