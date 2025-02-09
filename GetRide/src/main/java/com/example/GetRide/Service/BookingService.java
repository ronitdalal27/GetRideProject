package com.example.GetRide.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.GetRide.DTO.request.BookingRequest;
import com.example.GetRide.DTO.response.BookingResponse;
import com.example.GetRide.Exception.CustomerNotFoundException;
import com.example.GetRide.Exception.CabNotAvailableException;
import com.example.GetRide.Model.BookingCab;
import com.example.GetRide.Model.Cab;
import com.example.GetRide.Model.Customer;
import com.example.GetRide.Model.Driver;
import com.example.GetRide.Repository.BookingRepository;
import com.example.GetRide.Repository.CabRepository;
import com.example.GetRide.Repository.CustomerRepository;
import com.example.GetRide.Repository.DriverRepository;
import com.example.GetRide.Transformers.BookingTransformer;

@Service
public class BookingService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CabRepository cabRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public BookingResponse bookCab(BookingRequest bookingRequest) { 
        //as we get bookingRequest as a Input first check bookingRequest's attribute customer email is valid or not
        Customer customer = customerRepository.findByEmailID(bookingRequest.getCustomerEmail());

        if(ObjectUtils.isEmpty(customer)){ //to check whether customer is empty or not
            throw new CustomerNotFoundException("Invalid EmailID");
        }

        //when customer email is found then search whether the cab is available or not
        Optional<Cab> optionalcab = cabRepository.getRandomAvailableCab();
        if(optionalcab.isEmpty()){ //when no cab is available
            throw new CabNotAvailableException("sorry no cab is available at the moment");
        }

        //when randomly 1 cab is available convert that optionalCab to Cab
        Cab cab = optionalcab.get();
        Driver driver = cab.getDriver();
        cab.setBooked(true);

        //once you have customer and cab,now make booking
        BookingCab booking = BookingTransformer.bookingRequestToBooking(bookingRequest,cab); //cab just to calculate total fare of bookingrequest coz cabrequest has fareperkm

        //now after having a booking object with your cross check all the entities involved in booking are set or not
        // so here entities involved in booking are Customer and cab(driver bydefault involved)  , they need to set

        //now goto booking
        //everything is set just set customer n driver
        booking.setCustomer(customer);
        booking.setDriver(driver);

        BookingCab savedBooking = bookingRepository.save(booking);

        //now goto customers first 
        //nothing to set in customer,just add this booking to bookinglist attribute of customer
        customer.getBookingCab().add(savedBooking);

        //now goto cab
        //no need to set cab differently coz driver will set cab coz there is cascading relationship of driver and cab ,but driver also has booking list we need to set through cab
        driver.getBookingCabs().add(savedBooking);

        //now everything is set so finally save them
        //just save driver n customer,booking will be automatically saved
        customerRepository.save(customer); //will save customer + booking
        driverRepository.save(driver); //driver + booking

        //before sending response to client send email also
        sendEmail(savedBooking);
                
        return BookingTransformer.bookingToBookingResponse(savedBooking);
    }
        
    private void sendEmail(BookingCab savedBooking) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("ronitaccio131@gmail.com");
        simpleMailMessage.setTo(savedBooking.getCustomer().getEmailID());
        simpleMailMessage.setSubject("Booking Confirmed!!!");
        simpleMailMessage.setText("Congrats! "+savedBooking.getCustomer().getName()+" your ride is confirmed! and your booking id is : "+savedBooking.getBookingId());
        javaMailSender.send(simpleMailMessage);
    }
    
}
