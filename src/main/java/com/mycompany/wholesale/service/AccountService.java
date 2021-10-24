package com.mycompany.wholesale.service;

import java.util.List;

import com.mycompany.wholesale.dto.AccountDTO;

public interface AccountService {
	AccountDTO findById(Long id);
	List<AccountDTO> findAll();

}
