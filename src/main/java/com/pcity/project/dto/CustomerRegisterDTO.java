package com.pcity.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerRegisterDTO {

    private String firstName;       //이름
    private String lastName;        //성

    private String email;           //이메일
    private String phoneNumber;     //휴대폰번호

    @Builder
    public CustomerRegisterDTO(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
