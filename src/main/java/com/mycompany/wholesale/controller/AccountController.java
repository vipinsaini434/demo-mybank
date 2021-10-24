package com.mycompany.wholesale.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.wholesale.dto.AccountDTO;
import com.mycompany.wholesale.helper.PageUtilHelper;
import com.mycompany.wholesale.service.AccountService;
import com.mycompany.wholesale.service.TransactionService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/accounts")
	List<AccountDTO> all() {
		return accountService.findAll();
	}

	@GetMapping("/accounts/{id}")
	AccountDTO one(@PathVariable Long id) {
		return accountService.findById(id);
	}

	@GetMapping("/accounts/{id}/transactions")
	Map<String, Object> getTransactions(@PathVariable Long id, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String[] sort) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order(PageUtilHelper.getSortDirection(sort[0]), sort[0]));
		Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
		return transactionService.findAllTransaction(id, pagingSort);
	}
}