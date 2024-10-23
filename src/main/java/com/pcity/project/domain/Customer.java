package com.pcity.project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString(callSuper = true)
public class Customer extends BaseEntity {
//고객정보

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genId;                //자동생성 number타입 id

    private String firstName;       //이름
    private String lastName;        //성
    private String fullName;        //전체 성명

    private String phoneNumber;     //휴대폰번호
    private String email;           //이메일

}
