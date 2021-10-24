package com.mycompany.wholesale.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycompany.wholesale.dto.TransactionDTO;
import com.mycompany.wholesale.model.Account;
import com.mycompany.wholesale.model.Transaction;
import com.mycompany.wholesale.repository.TransactionRepository;
import com.mycompany.wholesale.service.AccountService;
import com.mycompany.wholesale.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionRepository repository;

	@Autowired
	private ModelMapper modelMapper;


	@Override
	public Map<String, Object> findAllTransaction(Long account_id,Pageable pagingSort) {
		// accountService.findById(account_id);
		Account account = new Account(account_id);
		Page<Transaction> pageTuts = repository.findByAccount(account,pagingSort);
		List<TransactionDTO> transactions =  convertToCompanyDto(pageTuts.getContent());
		Map<String, Object> response = new HashMap<>();
	      response.put("transactions", transactions);
	      response.put("currentPage", pageTuts.getNumber());
	      response.put("totalItems", pageTuts.getTotalElements());
	      response.put("totalPages", pageTuts.getTotalPages());
	      return response;
	}

	private List<TransactionDTO> convertToCompanyDto(List<Transaction> transactions) {
		List<TransactionDTO> companiesDTO = new ArrayList<>();
		for (Transaction transaction : transactions) {
			TransactionDTO companyDTO = modelMapper.map(transaction, TransactionDTO.class);
			companiesDTO.add(companyDTO);
		}
		return companiesDTO;
	}

}
