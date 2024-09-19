package com.workintech.s18d4.service;

import com.workintech.s18d4.dao.AddressDao;
import com.workintech.s18d4.entity.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;

    @Override
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    public Address find(long id) {
        return addressDao.findById(id).orElse(null);
    }

    @Override
    public Address save(long id) {
        Address address=find(id);
        return addressDao.save(address);
    }

    @Override
    public Address delete(long id) {
        Address address=find(id);
        addressDao.delete(address);
        return address;
    }
}
