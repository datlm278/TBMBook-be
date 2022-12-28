package com.example.tbmbookbe.dto.request;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class InvoiceImportRequest {
    private Integer bookId;
    private Integer quantity;
    private Integer accountId;
    private Timestamp dateImport;
    private Integer producerId;

}
