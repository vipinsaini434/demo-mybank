package com.mycompany.wholesale.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {

	private @Id @GeneratedValue Long id;
	private String accountNumber;
	private String accountType;

	public Account() {
	}
	
	public Account(String accountNumber, String accountType) {

		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	
	public Account(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Transaction> transactions = new HashSet<>();

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
		transaction.setAccount(this);
	}

	public void removeTransaction(Transaction transaction) {
		transactions.remove(transaction);
		transaction.setAccount(null);
	}

	

	@Override
	public String toString() {
		return "Account{" + "id=" + this.id + ", accountNumber='" + this.accountNumber + '\'' + ", accountType='" + this.accountType + '\'' + '}';
	}
}