package com.workintech.s18d4.service;

import com.workintech.s18d4.dao.CustomerDao;
import com.workintech.s18d4.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer findById(long id) {
        return customerDao.findById(id).orElse(null) ;
    }

    @Override
    public Customer save(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public Customer delete(long id) {
        Customer customer=findById(id);
       customerDao.delete(customer);
        return customer;
    }

    @Override
    public Customer update(long id) {
        Customer customer=findById(id);
        if(customer!=null){
            customer.setFirstName("newFN");
            customer.setLastName("newLN");
            customer.setSalary((long) 300);
        }
        return customer;
    }
}
