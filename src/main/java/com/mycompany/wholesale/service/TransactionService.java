package com.mycompany.wholesale.service;

import java.util.Map;

import org.springframework.data.domain.Pageable;

public interface TransactionService {
	Map<String, Object> findAllTransaction(Long account_id,Pageable pagingSort);
	// List<TransactionDTO> findAllTransaction(Long account_id);

}
