package com.pcity.project.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Room extends BaseEntity{
//객실 정보

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //자동생성id

    @Column(unique = true)
    private String roomNumber;      //객실 호수


    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;      //객실 타입

    @OneToMany(mappedBy = "assignedRoom")
    @JsonManagedReference
    private List<HotelReservation> hotelReservations;

}
