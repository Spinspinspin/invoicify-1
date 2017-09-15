package com.theironyard.invoicify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theironyard.invoicify.models.BillingRecord;
import com.theironyard.invoicify.models.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
		
	Long countByCompany(String company);
	
	
}

