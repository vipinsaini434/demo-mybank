package com.mycompany.wholesale.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	
	
	private String cardType;
	
	private Double transactionAmount;
	
	@ManyToOne(fetch = FetchType.EAGER)
    private Account account;
    
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction )) return false;
        return id != null && id.equals(((Transaction) o).getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}