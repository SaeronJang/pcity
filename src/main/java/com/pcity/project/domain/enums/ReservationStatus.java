package com.pcity.project.domain.enums;

public enum ReservationStatus {
    PENDING,        //예약완료 & 체크인 전
    CHECKED_IN,     //체크인 완료
    CANCELLED,      //예약취소
    CHECKED_OUT,    //체크아웃 완료
}
