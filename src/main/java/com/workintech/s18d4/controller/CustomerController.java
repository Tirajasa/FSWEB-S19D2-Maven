package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/workintech/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    List<Customer> getAll(){
        return customerService.findAll();
    }
    @GetMapping("/{id}")
    Customer get(@PathVariable("id") long id){
        return customerService.findById(id);
    }
    @PostMapping
    Customer save(Customer customer){
        return customerService.save(customer);
    }
    @PutMapping("/{id}")
    Customer update(@PathVariable("id") long id){

        return customerService.save(c)
    }
}
