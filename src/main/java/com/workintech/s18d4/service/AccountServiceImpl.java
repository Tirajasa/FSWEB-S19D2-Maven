package com.workintech.s18d4.service;

import com.workintech.s18d4.dao.AccountDao;
import com.workintech.s18d4.dao.CustomerDao;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import jakarta.persistence.EntityNotFoundException;
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

    @Override
    public Account update(long id) {
        Account account = find(id);
        if (account != null) {
            // Account'a bağlı olan Customer nesnesini güncelleyebilirsiniz (örneğin):
            Customer customer = account.getCustomer();
            // Müşteriyi güncellemek istiyorsanız burada set edebilirsiniz
            customer.setFirstName("New Customer Name");
            customer.setLastName("Last");

            // Account'u güncelleyip kaydetmek için accountDao.save() kullanıyoruz
            return accountDao.save(account); // Account nesnesi güncellenip kaydediliyor
        } else {
            throw new EntityNotFoundException("Account not found with id: " + id);
        }
    }
}
