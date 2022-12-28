package com.example.tbmbookbe.repositories;

import com.example.tbmbookbe.models.InvoiceImportDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceImportDetailRepository extends JpaRepository<InvoiceImportDetails, Integer> {
}
