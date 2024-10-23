package com.pcity.project.dto.hotelReservation;

import com.pcity.project.domain.RoomType;
import com.pcity.project.domain.enums.ReservationStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class HotelReservationCreateResultDTO {
//호텔 예약 후 결과 응답 DTO

    private String reservationNum;

    private String fullName;        //전체 성명
    private String email;           //이메일

    private String roomTypeName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private ReservationStatus status;

    private int numberOfNights;     //숙박일수

    private LocalDateTime createdAt; //생성일시
}
