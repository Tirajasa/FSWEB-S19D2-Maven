package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;

import java.util.List;

public interface AdressService {

   List<Address> findAll();
   Address find(long id);
   Address save(long id);

}
