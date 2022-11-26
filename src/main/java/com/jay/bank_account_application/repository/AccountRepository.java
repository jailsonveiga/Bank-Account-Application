package com.jay.bank_account_application.repository;

import com.jay.bank_account_application.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long>{

    // create a method to find account by account number
//    Account findByAccountNumber(int accountNumber);

    // create a method to find account by name
    Account findByName(String name);

    // create a method to find account by balance
    Account findByBalance(double balance);

    // create a method to find account by balance between two values
//    Account findByBalanceBetween(double balance1, double balance2);

    // create a method to find account by age
    Account findByAge(int age);

    Account searchByAccountNumber(int accountNumber);

    // create a method to find all account by account number
    List<Account> findAllByAccountNumber(int accountNumber);
}
