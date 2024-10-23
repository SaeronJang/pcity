package com.pcity.project.dto.hotelReservation;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class HotelReservationCreateDTO {
//호텔 예약 신규 건 생성

    //private String fullName;        //전체 성명
    private String firstName;       //이름
    private String lastName;        //성

    private String phoneNumber;     //휴대폰번호
    private String email;           //이메일

    private String roomTypeStrId;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    @Builder
    HotelReservationCreateDTO(String firstName, String lastName, String phoneNumber, String email, String roomTypeStrId, LocalDate checkInDate, LocalDate checkOutDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.roomTypeStrId = roomTypeStrId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }




}
