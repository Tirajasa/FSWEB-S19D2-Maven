package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CustomerService {

    List<Customer> findAll();
    Customer findById(long id);
    Customer save(Customer customer);
    Customer delete(long id);
    Customer update(long id);
}
