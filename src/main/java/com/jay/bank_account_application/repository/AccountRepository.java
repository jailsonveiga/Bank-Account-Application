package com.jay.bank_account_application.repository;

import com.jay.bank_account_application.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{
}
