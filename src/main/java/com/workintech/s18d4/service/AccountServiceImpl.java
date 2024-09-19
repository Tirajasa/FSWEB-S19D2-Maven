package com.workintech.s18d4.service;

import com.workintech.s18d4.dao.AccountDao;
import com.workintech.s18d4.entity.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account find(long id) {
        return accountDao.findById(id).orElse(null);
    }

    @Override
    public Account delete(long id) {
        Account account=find(id);
         accountDao.delete(account);
        return account;
    }

    @Override
    public Account save(Account account) {
        return accountDao.save(account);
    }
}
