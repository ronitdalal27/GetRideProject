package com.example.GetRide.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.GetRide.DTO.request.DriverRequest;
import com.example.GetRide.DTO.response.DriverResponse;
import com.example.GetRide.Service.DriverService;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping
    public ResponseEntity addDriverAndCab(@RequestBody DriverRequest driverRequest){
        String response = driverService.addDriverAndCab(driverRequest);
        return new ResponseEntity(response,HttpStatus.CREATED);
    }
    
    @GetMapping
    public DriverResponse getDriver(@RequestParam("mobileNo") long mobileNo){
        return driverService.getDriver(mobileNo);
    }
}
