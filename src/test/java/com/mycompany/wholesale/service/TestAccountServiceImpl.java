package com.mycompany.wholesale.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.mycompany.wholesale.dto.AccountDTO;
import com.mycompany.wholesale.helper.DataHelper;
import com.mycompany.wholesale.model.Account;
import com.mycompany.wholesale.repository.AccountRepository;
import com.mycompany.wholesale.service.impl.AccountServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestAccountServiceImpl{
	
	 @InjectMocks
	 AccountServiceImpl service;
	 
	 @Mock
	 private ModelMapper modelMapper;
	      
	      
	 @Mock
	 AccountRepository accountRepository;
	 
	 
	 @Test
	    public void testFindAllAccounts()
	    {

			Account account = DataHelper.getAccount();
			List<Account> accounts = new ArrayList<Account>();
			accounts.add(account);

	        when(accountRepository.findAll()).thenReturn(accounts);
	        when(modelMapper.map(account, AccountDTO.class)).thenReturn(DataHelper.getAccountDTO());
			
	        //test
	        List<AccountDTO> accountList = service.findAll();
	          
	        assertEquals(1, accountList.size());
	        verify(accountRepository, times(1)).findAll();
	    }
}