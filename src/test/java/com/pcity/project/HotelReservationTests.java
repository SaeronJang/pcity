package com.pcity.project;

import com.pcity.project.dto.hotelReservation.HotelReservationCreateDTO;
import com.pcity.project.service.CustomerServiceImpl;
import com.pcity.project.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class HotelReservationTests {

    @Autowired
    public CustomerServiceImpl customerService;

    @Autowired
    public ReservationService reservationService;

    @Test
    public void createReservationServiceTest(){
        String firstName="Yuwon";
        String lastName = "Kim";
        String phoneNumber="01011112222";
        String email = "user03@user.com";

        HotelReservationCreateDTO createDTO = HotelReservationCreateDTO.builder()
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .email(email)
                .roomTypeStrId("D1KS")
                .checkInDate(LocalDate.of(2024,10,31))
                .checkOutDate(LocalDate.of(2024,11,1))
                .build();

        System.out.println( reservationService.createReservation(createDTO));

    }


}
