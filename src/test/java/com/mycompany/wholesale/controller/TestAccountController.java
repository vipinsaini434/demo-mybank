package com.mycompany.wholesale.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.mycompany.wholesale.helper.DataHelper;
import com.mycompany.wholesale.service.impl.AccountServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class TestAccountController {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountServiceImpl service;
	
	
	@Test
	public void shouldReturnAllAccounts() throws Exception {
		
		when(service.findAll()).thenReturn(DataHelper.getAccountDTOList());
			
		this.mockMvc.perform(get("/accounts") 
                .accept(MediaType.APPLICATION_JSON)) 
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
				.andExpect(jsonPath("$[1].id").value("2"));
				
		
	}
	
	@Test
	public void shouldReturnOneAccount() throws Exception {
		
		when(service.findById(1L)).thenReturn(DataHelper.getAccountDTOList().get(0));
			
		this.mockMvc.perform(get("/accounts/1") 
                .accept(MediaType.APPLICATION_JSON)) 
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));
	}


}
