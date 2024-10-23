package com.pcity.project.service;

import com.pcity.project.domain.RoomType;
import com.pcity.project.dto.RoomTypeCreateDTO;
import com.pcity.project.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;
    private final ModelMapper modelMapper;

    public RoomType createRoomType(RoomTypeCreateDTO roomTypeCreateDTO){

        Optional<RoomType> optionalRoomType = roomTypeRepository.findRoomTypeByRoomTypeStrId(
                roomTypeCreateDTO.getRoomTypeStrId());

        if(optionalRoomType.isPresent()){ //중복 id가 존재하는 경우
            //todo : 중복id처리
            return null;
        } else { //중복이 아닌 경우, 리포지토리 저장 후 결과 리턴
            return roomTypeRepository.save( modelMapper.map(roomTypeCreateDTO, RoomType.class));
        }
    }

}
