package com.example.GetRide.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GetRide.Model.Cupon;
import com.example.GetRide.Repository.CuponRepository;

@Service
public class CuponService {

    @Autowired
    CuponRepository cuponRepository;

    public String addCupon(String cuponCode, int percentageDiscount) {
        Cupon c = Cupon.builder()
                       .cuponCode(cuponCode)
                       .precentageDiscount(percentageDiscount)
                       .build();

        cuponRepository.save(c);

        return "cupon added !!!";
    }
    
}
