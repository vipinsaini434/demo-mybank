package com.mycompany.wholesale.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.wholesale.model.Account;
import com.mycompany.wholesale.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	// List<Transaction> findByAccount(Account account);
	Page<Transaction> findByAccount(Account account,Pageable pageable);
}