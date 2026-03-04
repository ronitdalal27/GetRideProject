package com.example.GetRide.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.example.GetRide.DTO.request.DriverRequest;
import com.example.GetRide.DTO.response.DriverResponse;
import com.example.GetRide.Model.Cab;
import com.example.GetRide.Model.Driver;
import com.example.GetRide.Repository.DriverRepository;
import com.example.GetRide.Transformers.CabTransformer;
import com.example.GetRide.Transformers.DriverTransformer;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public String addDriverAndCab(DriverRequest driverRequest) {
        

        System.out.println("MOBILE RECEIVED FROM DTO = " + driverRequest.getMobileNo());
       //step 1 - convert DTO to Entity
        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);
        Cab cab = CabTransformer.CabRequestToCab(driverRequest.getCabRequest());
        //two entities involed i.e. driver and cab ,in driver class everything is set but cab attribute is not set so set it
        driver.setCab(cab);
        //now check for cab class,every attribute is set but driver attribute in not set so set it
        cab.setDriver(driver);


        //step-2 save both driver and cab,but no need so save both just save driver,cab will be automatically save in repo
        //bcoz driver has cascading relationship with cab,changes will automatically reflect in cab
        driverRepository.save(driver);
        
        return "Driver Registered Successsfully !!!";
    }

    public DriverResponse getDriver(String mobileNo) {
        Driver savedDriver = driverRepository.findByMobileNo(mobileNo);

        //convert Driver entity to DriverResponse DTO
        return DriverTransformer.driverToDriverResponse(savedDriver);
    }
    
    /*
        make following apis
        get all the drivers above a particular age
        get the driver with maximum number of bookings
        update the dirver license
        update drivers mobile number
        driver with least number of bookings
        get all the drivers with less than 10 bookings
     */
}
