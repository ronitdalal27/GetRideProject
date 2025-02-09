package com.example.GetRide.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.GetRide.Service.CuponService;

@RestController
@RequestMapping("/api/v1/cupon")
public class CuponController {

    @Autowired
    CuponService cuponService;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping
    public ResponseEntity addCupon(@RequestParam("code") String cuponCode , @RequestParam("discount") int percentageDiscount){
        String response = cuponService.addCupon(cuponCode,percentageDiscount);
        return new ResponseEntity(response,HttpStatus.ACCEPTED);
    }
    
}