package com.mycompany.wholesale.helper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.mycompany.wholesale.dto.AccountDTO;
import com.mycompany.wholesale.dto.TransactionDTO;
import com.mycompany.wholesale.model.Account;
import com.mycompany.wholesale.model.Transaction;

public class DataHelper {
	
	
	public static Account getAccount(){
		 Account account = new Account("11111111", "Credit");
			Transaction t1 = new Transaction();
			Transaction t2 = new Transaction();
			
			t1.setTransactionAmount(100.00);
			t1.setCardType("Digital");
			
			t2.setTransactionAmount(200.00);
			t2.setCardType("Physical Card");
			
			account.addTransaction(t1);
			account.addTransaction(t2);
			
			return account;
	}
	
	public static AccountDTO getAccountDTO() {
		AccountDTO accountDTO = new AccountDTO(1L,"11111111", "Credit");
		return accountDTO;
	}
	
	public static List<AccountDTO> getAccountDTOList() {
		AccountDTO accountDTO1 = new AccountDTO(1L,"11111111", "Credit");
		AccountDTO accountDTO2 = new AccountDTO(2L,"22222222", "Debit");
		List<AccountDTO> list = new LinkedList<AccountDTO>();
		list.add(accountDTO1);list.add(accountDTO2);
		return list;
	}
	
	public static List<Transaction> getTransactions(){
		Account account = new Account("11111111", "Credit");
		List<Transaction> transactions = new ArrayList<Transaction>();
		Transaction t1 = new Transaction();
		Transaction t2 = new Transaction();
		
		t1.setTransactionAmount(100.00);
		t1.setCardType("Digital");
		t1.setAccount(account);
		
		t2.setTransactionAmount(200.00);
		t2.setCardType("Physical Card");
		t2.setAccount(account);
		transactions.add(t1);
		transactions.add(t2);
		return transactions;
		
	}
	
	public static Transaction getTransaction(){
		Account account = new Account("11111111", "Credit");
		Transaction t1 = new Transaction();
		t1.setTransactionAmount(100.00);
		t1.setCardType("Digital");
		t1.setAccount(account);
		return t1;
		
	}
	
	public static TransactionDTO getTransactionDTO(){
		TransactionDTO dto = new TransactionDTO();
		dto.setTransactionAmount(100.00);
		dto.setTransactionType("Digital");
		dto.setAccount(getAccount());
		return dto;
		
	}

}
