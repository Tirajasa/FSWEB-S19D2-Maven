package com.workintech.s18d4.controller;


import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Account;

import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.AccountService;

import com.workintech.s18d4.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/workintech/accounts")
public class AccountController {

    private final AccountService accountService;
    private final CustomerService customerService;


    @GetMapping
    List<Account> getAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    Account get(@PathVariable("id") long id){
        return accountService.find(id);
    }

  @PostMapping("/{customerId")
    AccountResponse save(@PathVariable("customerId") long customerId,@RequestBody Account account){
        Customer customer=customerService.find(customerId);
        if(customer!=null){
            customer.getAccounts().add(account);
            account.setCustomer(customer);
            accountService.save(account);
        }else{
            throw new RuntimeException("no customer found");
        }
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),new CustomerResponse(customer.getId(),customer.getFirstName(),customer.getSalary()));
    }
    @PutMapping("/{customerId}")
    AccountResponse update(@RequestBody Account account,@PathVariable("customerId")long customerId){
        Customer customer=customerService.find(customerId);
        Account toBeUpdatedAccount= null;
        for(Account account1:customer.getAccounts()){
            if(account.getId()==account1.getId()){
                toBeUpdatedAccount=account1;
            }
        }
            if(toBeUpdatedAccount==null){
                throw new RuntimeException("to be updated account("+account.getId()+") is not found for this customer: "+customerId);
            }
            int toBeUpdated=customer.getAccounts().indexOf(toBeUpdatedAccount);
            customer.getAccounts().set(toBeUpdated,account);
            account.setCustomer(customer);
            accountService.save(account);
        return new AccountResponse(account.getId(),account.getAccountName(),account.getMoneyAmount(),
                new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));
    }
    @DeleteMapping("/{id}")
    AccountResponse remove(@PathVariable ("id") Long id){
        Account account=accountService.find(id);
        //custom exception donmek asagidaki durum icin daha dogru olur.Globalden coz!!!
        if(account==null){
            throw new RuntimeException("account("+account.getId()+") is not found with this id");
        }
        accountService.delete(id);
        return new AccountResponse(account.getId(),account.getAccountName(),account.getMoneyAmount(),new CustomerResponse(account.getCustomer().getId(),account.getCustomer().getEmail(),account.getCustomer().getSalary()));
    }
}
