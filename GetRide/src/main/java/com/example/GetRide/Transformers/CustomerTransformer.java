package com.example.GetRide.Transformers;

import com.example.GetRide.DTO.request.CustomerRequest;
import com.example.GetRide.DTO.response.CustomerResponse;
import com.example.GetRide.Model.Customer;


public class CustomerTransformer {
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder().name(customerRequest.getName())
                                 .age(customerRequest.getAge())
                                 .emailID(customerRequest.getEmailID())
                                 .gender(customerRequest.getGender())
                                 .build();
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer){
      return CustomerResponse.builder().name(customer.getName())
                                       .gender(customer.getGender())
                                       .emailID(customer.getEmailID())
                                       .build();
    }
}
