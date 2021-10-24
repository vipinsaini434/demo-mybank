package com.mycompany.wholesale.repo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mycompany.wholesale.helper.DataHelper;
import com.mycompany.wholesale.repository.AccountRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TestAccountRepository {
	
	 @Autowired
	 private AccountRepository accountRepository;
	 
	 @BeforeEach
	 void initUseCase() {
			accountRepository.save(DataHelper.getAccount());
	    }
	 
	  @AfterEach
	  public void destroyAll(){
		  accountRepository.deleteAll();
	    }
	  
	  @Test
	  void findAll_success() {
		  Assertions.assertThat(accountRepository.findAll()).hasSize(1);
	    }
	  

}