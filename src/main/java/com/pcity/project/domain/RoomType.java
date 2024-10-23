package com.pcity.project.domain;

import com.pcity.project.domain.enums.BedType;
import com.pcity.project.domain.enums.RoomCate;
import com.pcity.project.domain.enums.ViewType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString(exclude = "rooms")
public class RoomType {
//객실타입

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomTypeId;

    @Enumerated(EnumType.STRING)
    private RoomCate roomCate;    //디럭스/스위트/풀빌라

    private BedType bedType;    //침대유형

    @Enumerated(EnumType.STRING)
    private ViewType viewType;  //뷰 타입(Sea/Airport)

    private String roomTypeName; //룸 타입명

    private Long standardPeople;    //기준 인원
    private Long maximumPeople;     //최대 인원

    @Column(unique = true)
    private String roomTypeStrId; //룸타입 고유id

    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();

}
