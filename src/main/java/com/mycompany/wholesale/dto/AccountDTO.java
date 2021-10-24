package com.mycompany.wholesale.dto;

public class AccountDTO {

	private Long id;
	private String accountNumber;
	private String accountType;

	public AccountDTO() {
	}
	
	public AccountDTO(Long id, String accountNumber, String accountType) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	
}