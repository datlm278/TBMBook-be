package com.example.tbmbookbe.repositories;

import com.example.tbmbookbe.models.InvoiceImport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceImportRepository extends JpaRepository<InvoiceImport, Integer> {
}
