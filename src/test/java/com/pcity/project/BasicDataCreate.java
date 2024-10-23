package com.pcity.project;

import com.pcity.project.domain.Customer;
import com.pcity.project.domain.Room;
import com.pcity.project.domain.RoomType;
import com.pcity.project.domain.enums.BedType;
import com.pcity.project.domain.enums.RoomCate;
import com.pcity.project.domain.enums.ViewType;
import com.pcity.project.dto.CustomerRegisterDTO;
import com.pcity.project.dto.RoomTypeCreateDTO;
import com.pcity.project.repository.RoomRepository;
import com.pcity.project.repository.RoomTypeRepository;
import com.pcity.project.service.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BasicDataCreate {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private ModelMapper modelMapper;

    //객실 타입 생성
    @Test
    public void createRoomType() {

        //디럭스
        RoomTypeCreateDTO D1KS = RoomTypeCreateDTO.builder()
                                                  .roomCate(RoomCate.DELUXE)
                                                  .bedType(BedType.KING)
                                                  .viewType(ViewType.SEA_VIEW)
                                                  .roomTypeName("디럭스 킹")
                                                  .roomTypeStrId("D1KS")
                                                  .standardPeople(2L)
                                                  .maximumPeople(4L)
                                                  .build();
        roomTypeRepository.save(modelMapper.map(D1KS, RoomType.class));

        RoomTypeCreateDTO D1KA = RoomTypeCreateDTO.builder()
                                                  .roomCate(RoomCate.DELUXE)
                                                  .bedType(BedType.KING)
                                                  .viewType(ViewType.AIRPORT_VIEW)
                                                  .roomTypeName("디럭스 킹")
                                                  .roomTypeStrId("D1KA")
                                                  .standardPeople(2L)
                                                  .maximumPeople(4L)
                                                  .build();
        roomTypeRepository.save(modelMapper.map(D1KA, RoomType.class));

        RoomTypeCreateDTO D2KS = RoomTypeCreateDTO.builder()
                                                  .roomCate(RoomCate.DELUXE)
                                                  .bedType(BedType.KING)
                                                  .viewType(ViewType.SEA_VIEW)
                                                  .roomTypeName("프리미어 디럭스 킹")
                                                  .roomTypeStrId("D2KS")
                                                  .standardPeople(2L)
                                                  .maximumPeople(4L)
                                                  .build();
        roomTypeRepository.save(modelMapper.map(D2KS, RoomType.class));

        RoomTypeCreateDTO D2KA = RoomTypeCreateDTO.builder()
                                                  .roomCate(RoomCate.DELUXE)
                                                  .bedType(BedType.KING)
                                                  .viewType(ViewType.AIRPORT_VIEW)
                                                  .roomTypeName("프리미어 디럭스 킹")
                                                  .roomTypeStrId("D2KA")
                                                  .standardPeople(2L)
                                                  .maximumPeople(4L)
                                                  .build();
        roomTypeRepository.save(modelMapper.map(D2KA, RoomType.class));


        //디럭스
        RoomTypeCreateDTO D1TS = RoomTypeCreateDTO.builder()
                                                  .roomCate(RoomCate.DELUXE)
                                                  .bedType(BedType.TWIN)
                                                  .viewType(ViewType.SEA_VIEW)
                                                  .roomTypeName("디럭스 트윈")
                                                  .roomTypeStrId("D1TS")
                                                  .standardPeople(2L)
                                                  .maximumPeople(4L)
                                                  .build();
        roomTypeRepository.save(modelMapper.map(D1TS, RoomType.class));

        RoomTypeCreateDTO D1TA = RoomTypeCreateDTO.builder()
                                                  .roomCate(RoomCate.DELUXE)
                                                  .bedType(BedType.TWIN)
                                                  .viewType(ViewType.AIRPORT_VIEW)
                                                  .roomTypeName("디럭스 트윈")
                                                  .roomTypeStrId("D1TA")
                                                  .standardPeople(2L)
                                                  .maximumPeople(4L)
                                                  .build();
        roomTypeRepository.save(modelMapper.map(D1TA, RoomType.class));

        RoomTypeCreateDTO D2TS = RoomTypeCreateDTO.builder()
                                                  .roomCate(RoomCate.DELUXE)
                                                  .bedType(BedType.TWIN)
                                                  .viewType(ViewType.SEA_VIEW)
                                                  .roomTypeName("프리미어 디럭스 트윈")
                                                  .roomTypeStrId("D2TS")
                                                  .standardPeople(2L)
                                                  .maximumPeople(4L)
                                                  .build();
        roomTypeRepository.save(modelMapper.map(D2TS, RoomType.class));

        RoomTypeCreateDTO D2TA = RoomTypeCreateDTO.builder()
                                                  .roomCate(RoomCate.DELUXE)
                                                  .bedType(BedType.TWIN)
                                                  .viewType(ViewType.AIRPORT_VIEW)
                                                  .roomTypeName("프리미어 디럭스 트윈")
                                                  .roomTypeStrId("D2TA")
                                                  .standardPeople(2L)
                                                  .maximumPeople(4L)
                                                  .build();
        roomTypeRepository.save(modelMapper.map(D2TA, RoomType.class));

    }

    //객실 생성
    @Test
    public void createRoom(){
        
        //501
        Room room501 = new Room();
        room501.setRoomType(roomTypeRepository.findRoomTypeByRoomTypeStrId("D1KS").get());
        room501.setRoomNumber("501");
        roomRepository.save(room501);

        //502
        Room room502 = new Room();
        room502.setRoomType(roomTypeRepository.findRoomTypeByRoomTypeStrId("D1TA").get());
        room502.setRoomNumber("502");
        roomRepository.save(room502);

        //503
        Room room503 = new Room();
        room503.setRoomType(roomTypeRepository.findRoomTypeByRoomTypeStrId("D2KS").get());
        room503.setRoomNumber("503");
        roomRepository.save(room503);

        //504
        Room room504 = new Room();
        room504.setRoomType(roomTypeRepository.findRoomTypeByRoomTypeStrId("D2TA").get());
        room504.setRoomNumber("504");
        roomRepository.save(room504);


    }

    //Customer 생성
    @Test
    public void createCustomer(){

        //user03
        CustomerRegisterDTO user03 = CustomerRegisterDTO.builder()
                                             .firstName("Yuwon")
                                             .lastName("Kim")
                                             .email("user03@user.com")
                                             .phoneNumber("010-1111-2222")
                                             .build();

        Customer savedCustomer = customerService.register(user03);

        System.out.println(savedCustomer);

    }



}

































