package com.example.tbmbookbe.controller;

import com.example.tbmbookbe.dto.request.InvoiceImportRequest;
import com.example.tbmbookbe.services.invoice_import.InvoiceImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("invoice-import")
public class InvoiceImportController {
    private final InvoiceImportService invoiceImportService;

    @Autowired
    public InvoiceImportController(InvoiceImportService invoiceImportService) {
        this.invoiceImportService = invoiceImportService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createInvoiceImport(@RequestBody InvoiceImportRequest invoiceImportRequest) {
        invoiceImportService.createInvoiceImport(invoiceImportRequest);
        return ResponseEntity.ok().body("Successfully!");
    }
}
