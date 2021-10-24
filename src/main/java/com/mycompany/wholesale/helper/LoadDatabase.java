package com.mycompany.wholesale.helper;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.mycompany.wholesale.model.Account;
import com.mycompany.wholesale.model.Transaction;
import com.mycompany.wholesale.repository.AccountRepository;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	private static final String[] CARD_TYPE={"CREDIT", "DEBIT"};
	private static final int NUMBER_OF_TRANSACTION = 50;
	private static final String ACCOUTNTS_FILE = "accounts.csv"; 
	
	
	@Autowired
	ResourceLoader resourceLoader;

	@Bean
	CommandLineRunner initDatabase(AccountRepository repository) {

		try {
			Resource resource = resourceLoader.getResource("classpath:"+ACCOUTNTS_FILE);
		    InputStream inputStream = resource.getInputStream();
			Reader in = new InputStreamReader(inputStream);
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
			for (CSVRecord record : records) {
				String accountNumber = record.get("accountNumber");
				String accountType = record.get("accountType");
				Account acc = new Account(accountNumber, accountType);
				for (int index = 0; index < NUMBER_OF_TRANSACTION; index++) {
					Random rd = new Random();
					Random r=new Random(); 
					Transaction t = new Transaction();
					int randomNumber=r.nextInt(CARD_TYPE.length);
					t.setCardType(CARD_TYPE[randomNumber]);
					BigDecimal bd = new BigDecimal(rd.nextDouble()).setScale(2, RoundingMode.HALF_UP);
					t.setTransactionAmount(bd.doubleValue());
					acc.addTransaction(t);
				}
				log.info("Number of transactinos for account "+ accountNumber );
				repository.save(acc);
			}
		} catch (Exception ex) {
			log.error("**********Error occurs while uploading data from csv file***********");
		}finally {
			Account acc1 = new Account("11111111", "Credit");
			Transaction t1 = new Transaction();
			Transaction t2 = new Transaction();
			
			t1.setTransactionAmount(100.00);
			t1.setCardType("Digital");
			
			t2.setTransactionAmount(200.00);
			t2.setCardType("Physical Card");
			
			acc1.addTransaction(t1);
			acc1.addTransaction(t2);
			repository.save(acc1);
		}

		return args -> {			
			log.info("Successful preloading of data");
		};
	}

	// this can be go in different configuration class.
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}