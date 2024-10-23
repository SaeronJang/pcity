package com.pcity.project.service;

import com.pcity.project.domain.Customer;
import com.pcity.project.dto.CustomerRegisterDTO;

public interface CustomerService {
    public Customer register(CustomerRegisterDTO customerRegisterDTO);

    public Customer getCustomer(String fullName, String phoneNumber, String email);
}
