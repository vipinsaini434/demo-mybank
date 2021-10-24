package com.mycompany.wholesale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.wholesale.dto.AccountDTO;
import com.mycompany.wholesale.exception.AccountNotFoundException;
import com.mycompany.wholesale.model.Account;
import com.mycompany.wholesale.repository.AccountRepository;
import com.mycompany.wholesale.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private AccountRepository repository;
	

	@Override
	public AccountDTO findById(Long id) {
		return convertToDto(repository.findById(id).orElseThrow(() -> new AccountNotFoundException(id)));
	}

	@Override
	public List<AccountDTO> findAll() {
		return convertToDtoList(repository.findAll());
	}

	
	private AccountDTO convertToDto(Account account) {
		AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
		return accountDTO;
	}
	
	private List<AccountDTO> convertToDtoList(List<Account> accounts) {
		List<AccountDTO> accountsDTO = new ArrayList<AccountDTO>();
		for (Account account : accounts) {
			AccountDTO accountDTO = convertToDto(account);
			accountsDTO.add(accountDTO);
		}
		return accountsDTO;
	}
}
