package com.pcity.project.repository;

import com.pcity.project.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //비회원+휴대폰번호 조회
    Optional<Customer> findCustomerByFullNameAndPhoneNumberAndEmail(String fullName, String phoneNumber, String email);


}
