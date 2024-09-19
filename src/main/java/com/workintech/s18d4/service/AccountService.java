package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface AccountService {

    List<Account> findAll();
    Account find(long id);
    Account delete(long id);
    Account save(Account account);
     Account update(long id);
}
