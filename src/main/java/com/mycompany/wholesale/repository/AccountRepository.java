package com.mycompany.wholesale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mycompany.wholesale.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}