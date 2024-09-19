package com.workintech.s18d4.controller;


import com.workintech.s18d4.entity.Account;

import com.workintech.s18d4.service.AccountService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/workintech/accounts")
public class AccountController {

    private final AccountService accountService;


    @GetMapping
    List<Account> getAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    Account get(@PathVariable("id") long id){
        return accountService.find(id);
    }

//    @PostMapping("/{customerId")
//    Account save(@PathVariable("customerId") long id){
////        Customer found=findById(id);
////
////        Account saved=this.accountService.save(found)
////        found.setAccounts(saved);
////        return
//    }
}
