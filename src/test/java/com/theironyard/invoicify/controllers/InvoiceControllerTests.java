package com.theironyard.invoicify.controllers;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Map;

import org.junit.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.ModelAndView;

import com.theironyard.invoicify.models.User;
import com.theironyard.invoicify.repositories.BillingRecordRepository;
import com.theironyard.invoicify.repositories.CompanyRepository;
import com.theironyard.invoicify.repositories.InvoiceRepository;

public class InvoiceControllerTests {
	
	private InvoiceController controller;
	private Authentication authentication;
	private CompanyRepository companyRepo;
	private InvoiceRepository invoiceRepo;
	private BillingRecordRepository billingRecordRepo;
	private User user;
	
	@Before
	public void setup() {
		this.companyRepo = mock(CompanyRepository.class);
		this.invoiceRepo = mock(InvoiceRepository.class);
		this.billingRecordRepo = mock(BillingRecordRepository.class);
		
		user = new User();
		authentication = mock(Authentication.class);
		when(authentication.getPrincipal()).thenReturn(user);
		controller = new InvoiceController(companyRepo, billingRecordRepo, invoiceRepo);
	}

	@Test
	public void test_list() {
		ModelAndView mv = controller.list(authentication);
		
		assertThat(mv.getViewName()).isEqualTo("invoices/list");
		Map<String, Object> model = mv.getModel();
		assertThat(model.get("user")).isSameAs(user);
	}
	
}