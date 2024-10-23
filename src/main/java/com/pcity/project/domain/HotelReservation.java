package com.pcity.project.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pcity.project.domain.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Getter
@Setter
@Entity
public class HotelReservation extends BaseEntity{

    @Id
    private String reservationNum;          //예약번호

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;              //예약자

    @ManyToOne
    @JoinColumn(name = "room_type_str_id")
    private RoomType roomType;              //객실타입

    private LocalDate checkInDate;          //체크인일자
    private LocalDate checkOutDate;         //체크아웃일자

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;       //예약 상태

    @ManyToOne
    @JoinColumn(name = "room_number")
    @JsonBackReference
    private Room assignedRoom;


    private int numberOfNights; //숙박일수


    //setter
    public void setCheckInDate(LocalDate checkInDate){
        this.checkInDate = checkInDate;
        updateNights();
    }
    public void setCheckOutDate(LocalDate checkOutDate){
        this.checkOutDate = checkOutDate;
        updateNights();
    }

    //숙박일수 계산
    public void updateNights(){
        if(checkInDate!=null && checkOutDate!=null){
            if(checkOutDate.isAfter(checkInDate)){
                int nights = (int) checkInDate.until(checkOutDate, DAYS);
                System.out.println("=====================================");
                System.out.println("nights : " + nights+"nights");
                this.numberOfNights = nights;
            }
        }
    }


}
