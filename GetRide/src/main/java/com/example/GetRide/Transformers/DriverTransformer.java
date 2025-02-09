package com.example.GetRide.Transformers;

import com.example.GetRide.DTO.request.DriverRequest;
import com.example.GetRide.DTO.response.DriverResponse;
import com.example.GetRide.Model.Driver;

public class DriverTransformer {

    public static Driver driverRequestToDriver(DriverRequest driverRequest){
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .drivingLicense(driverRequest.getDrivingLicense())
                .mobileNo(driverRequest.getMobileNo())
                .build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver){
        return DriverResponse.builder()
                             .name(driver.getName())
                             .mobileNo(driver.getMobileNo())
                             .cab(CabTransformer.cabToCabResponse(driver.getCab()))
                             .build();
    }
    
}
