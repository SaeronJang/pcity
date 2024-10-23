package com.pcity.project.service;

import com.pcity.project.domain.Customer;
import com.pcity.project.domain.HotelReservation;
import com.pcity.project.domain.enums.ReservationStatus;
import com.pcity.project.dto.CustomerRegisterDTO;
import com.pcity.project.dto.hotelReservation.HotelReservationCreateDTO;
import com.pcity.project.dto.hotelReservation.HotelReservationCreateResultDTO;
import com.pcity.project.repository.ReservationRepository;
import com.pcity.project.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservationService {

    public final ReservationRepository reservationRepository;
    public final RoomTypeRepository roomTypeRepository;
    public final CustomerService customerService;
    public final ModelMapper modelMapper;

    /*호텔 신규 예약 건 생성*/
    public HotelReservationCreateResultDTO createReservation(HotelReservationCreateDTO reservationCreateDTO){
        HotelReservation hotelReservation = modelMapper.map(reservationCreateDTO, HotelReservation.class);

        String fullName = reservationCreateDTO.getFirstName()+" "+reservationCreateDTO.getLastName();

        //기존에 등록된 Customer있는지 확인
        Customer customer = customerService.getCustomer(fullName, reservationCreateDTO.getPhoneNumber(), reservationCreateDTO.getEmail());

        //없다면 Customer 신규등록
        if(customer == null){
            CustomerRegisterDTO customerRegisterDTO = CustomerRegisterDTO.builder()
                                                         .firstName(reservationCreateDTO.getFirstName())
                                                         .lastName(reservationCreateDTO.getLastName())
                                                         .phoneNumber(reservationCreateDTO.getPhoneNumber())
                                                         .email(reservationCreateDTO.getEmail())
                                                         .build();
            customer = customerService.register(customerRegisterDTO);
        }

        hotelReservation.setCustomer(customer);

        hotelReservation.setAssignedRoom(null);                     //객실번호입력(체크인 시)
        hotelReservation.setStatus(ReservationStatus.PENDING);      //예약상태(대기PENDING으로지정)
        hotelReservation.setReservationNum(createReservationNum()); //예약번호입력
        hotelReservation.setRoomType(roomTypeRepository.findRoomTypeByRoomTypeStrId(
                reservationCreateDTO.getRoomTypeStrId()).get()); //객실유형입력

        HotelReservation createdHotelReservation = reservationRepository.save(hotelReservation);

        HotelReservationCreateResultDTO resultDTO = modelMapper.map(createdHotelReservation, HotelReservationCreateResultDTO.class);

        resultDTO.setFullName(createdHotelReservation.getCustomer().getFullName());
        resultDTO.setEmail(createdHotelReservation.getCustomer().getEmail());
        resultDTO.setRoomTypeName(createdHotelReservation.getRoomType().getRoomTypeName());

        return resultDTO;

    }

    /*예약번호 생성*/
    public String createReservationNum(){
        String reservationNum = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))+"-"+UUID.randomUUID().toString().substring(0, 8);
        System.out.println(reservationNum);
        return reservationNum;
    }

}
