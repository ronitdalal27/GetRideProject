package com.example.GetRide.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import com.example.GetRide.Enum.Gender;
import com.example.GetRide.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    Customer findByEmailID(String emailID);
    //List<Customer> findByName(String name);

    @Query(value = "select * from customer_details where gender = :gender and age >= :age",nativeQuery=true)
    public List<Customer> getCustomersByGenderAndAge(String gender,int age);

    
    /*
    HQL query 
    @Query(value = "select c from Customer c where c.gender = :gender and c.age >= :age")
    public List<Customer> getCustomersByGenderAndAge(Gender gender,int age);
    if running this query take gender as Enum everywhere
    */
    
}
