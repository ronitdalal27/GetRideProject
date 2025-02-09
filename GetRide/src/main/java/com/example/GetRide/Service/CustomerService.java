package com.example.GetRide.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GetRide.DTO.request.CustomerRequest;
import com.example.GetRide.DTO.response.CustomerResponse;
import com.example.GetRide.Model.Customer;
import com.example.GetRide.Repository.CustomerRepository;
import com.example.GetRide.Transformers.CustomerTransformer;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        //dto -> entity  
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);

        Customer savedCustomer = customerRepository.save(customer);

        //convert saved entity to response entity
        return  CustomerTransformer.customerToCustomerResponse(savedCustomer);

    }

    public CustomerResponse getCustomer(String email) {
        Customer savedCustomer =  customerRepository.findByEmailID(email);
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> getCustomersByGenderAndAge(String gender, int age) {
        List<Customer> customers =  customerRepository.getCustomersByGenderAndAge(gender, age);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer c : customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(c));
        }
        
        return customerResponses;
    }
    
}
