package com.pcity.project.controller.hotel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotel")
public class HotelReservationController {

    @GetMapping("/reservation")
    public String makeReservation(){
        return "/hotel/hotel_reservation";
    }
}
