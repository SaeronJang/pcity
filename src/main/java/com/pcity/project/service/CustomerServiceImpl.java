package com.pcity.project.service;

import com.pcity.project.domain.Customer;
import com.pcity.project.dto.CustomerRegisterDTO;
import com.pcity.project.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    //Customer 등록
    public Customer register(CustomerRegisterDTO customerRegisterDTO){

        //기존 Customer 등록 여부 확인
        String fullName = customerRegisterDTO.getFirstName() + " " + customerRegisterDTO.getLastName();


        //성명+휴대폰번호+Email로 확인
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByFullNameAndPhoneNumberAndEmail(fullName, customerRegisterDTO.getPhoneNumber(),customerRegisterDTO.getEmail());


        //이전 등록 내용 있는 경우 -> 해당 Customer 리턴
        if(optionalCustomer.isPresent()){
            return optionalCustomer.get();
        }

        //없는 경우 신규 등록 -> 등록된 Customer 리턴
        Customer customer = modelMapper.map(customerRegisterDTO, Customer.class);
        customer.setFullName(customer.getFirstName()+" "+customer.getLastName());
        //연락처는 숫자만 String형식으로 저장
        String orgPhoneNum = customer.getPhoneNumber().trim();

        int orgLen = orgPhoneNum.length();
        String newPhoneNum = "";

        for (int i = 0; i < orgLen; i++) {
            //낱글자가 0~9인경우, 변수 뒤에 추가
            if(orgPhoneNum.charAt(i)>=48 && orgPhoneNum.charAt(i)<=57){
                newPhoneNum += orgPhoneNum.charAt(i);
            }
        }
        customer.setPhoneNumber(newPhoneNum);
        return customerRepository.save(customer);
    }

    /*기존 등록된 Customer 리턴(비회원)*/
    public Customer getCustomer(String fullName, String phoneNumber, String email){
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByFullNameAndPhoneNumberAndEmail(fullName, phoneNumber, email);
        if(optionalCustomer.isPresent()) return optionalCustomer.get();
        else return null;
    }


}
