package com.example.tbmbookbe.services.invoice_import;

import com.example.tbmbookbe.dto.request.InvoiceImportRequest;

public interface IInvoiceImportService {

    String createInvoiceImport(InvoiceImportRequest request);
}
