package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> findAll();
    Optional<Account> find(long id);
    Account delete(long id);
    Account save(Account account);
   // Account update(long id);
}
