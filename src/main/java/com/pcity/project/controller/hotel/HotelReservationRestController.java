package com.pcity.project.controller.hotel;

import com.pcity.project.dto.hotelReservation.HotelReservationCreateDTO;
import com.pcity.project.dto.hotelReservation.HotelReservationCreateResultDTO;
import com.pcity.project.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
public class HotelReservationRestController {

    public final ReservationService reservationService;
    public final ModelMapper modelMapper;

    /*호텔 신규 예약 건 생성 컨트롤러*/
    @PostMapping("/reservation/create")
    public ResponseEntity<HotelReservationCreateResultDTO> requestHotelReservation(@RequestParam(name = "hotelReservationCreateDTO")
                                                                                   HotelReservationCreateDTO hotelReservationCreateDTO){

        HotelReservationCreateResultDTO reservationResultDTO = reservationService.createReservation(hotelReservationCreateDTO); //생성된 Reservation

        return ResponseEntity.ok(reservationResultDTO);
    }

}
