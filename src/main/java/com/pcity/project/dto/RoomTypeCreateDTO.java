package com.pcity.project.dto;

import com.pcity.project.domain.enums.BedType;
import com.pcity.project.domain.enums.RoomCate;
import com.pcity.project.domain.enums.ViewType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoomTypeCreateDTO {

    private RoomCate roomCate;    //디럭스/스위트/풀빌라
    private BedType bedType;    //침대유형
    private ViewType viewType;  //뷰 타입(Sea/Airport)
    private String roomTypeName; //룸 타입명

    private String roomTypeStrId; //룸타입 고유id

    private Long standardPeople;    //기준 인원
    private Long maximumPeople;     //최대 인원


    @Builder
    public RoomTypeCreateDTO(RoomCate roomCate, BedType bedType, ViewType viewType, String roomTypeName, String roomTypeStrId, Long standardPeople, Long maximumPeople){
        this.roomCate = roomCate;
        this.bedType = bedType;
        this.viewType = viewType;
        this.roomTypeName = roomTypeName;
        this.roomTypeStrId = roomTypeStrId;
        this.standardPeople=standardPeople;
        this.maximumPeople=maximumPeople;
    }

}
