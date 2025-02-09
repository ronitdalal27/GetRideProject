package com.example.GetRide.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.GetRide.DTO.request.CustomerRequest;
import com.example.GetRide.DTO.response.CustomerResponse;
import com.example.GetRide.Service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse customerResponse =  customerService.addCustomer(customerRequest);
        return new ResponseEntity(customerResponse,HttpStatus.CREATED);
    }

    @GetMapping
    public CustomerResponse getCustomer(@RequestParam("email") String email){
        return customerService.getCustomer(email);
    }

    @GetMapping("/gender/{gender}/age/{age}")
    public List<CustomerResponse> getCustomersByGenderAndAge(@PathVariable("gender") String gender,@PathVariable("age") int age){
        return customerService.getCustomersByGenderAndAge(gender,age);
    }

    /*
        get all customers of a particular age and gender
        get all the customers with maximum/minimum bookings
         
    */
}
