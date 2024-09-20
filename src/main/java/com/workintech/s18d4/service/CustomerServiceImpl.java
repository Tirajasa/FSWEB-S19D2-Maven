package com.workintech.s18d4.service;

import com.workintech.s18d4.dao.CustomerRepository;
import com.workintech.s18d4.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerDao;

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer find(long id) {
        return customerDao.findById(id).orElse(null) ;
    }

    @Override
    public Customer save(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public Customer delete(long id) {
        Customer customer=find(id);
       customerDao.delete(customer);
        return customer;
    }

    @Override
    public Customer update(long id) {
        Customer customer=find(id);
        if(customer!=null){
            customer.setFirstName("newFN");
            customer.setLastName("newLN");
            customer.setSalary(300.00);
        }
        return customer;
    }
}
