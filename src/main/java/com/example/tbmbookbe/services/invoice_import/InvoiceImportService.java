package com.example.tbmbookbe.services.invoice_import;

import com.example.tbmbookbe.dto.request.InvoiceImportRequest;
import com.example.tbmbookbe.models.*;
import com.example.tbmbookbe.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceImportService implements IInvoiceImportService {

    private final InvoiceImportRepository importRepository;
    private final InvoiceImportDetailRepository importDetailRepository;
    private final AccountRepository accountRepository;
    private final BookRepository bookRepository ;
    private final ProducerRepository producerRepository;

    @Autowired
    public InvoiceImportService(InvoiceImportRepository importRepository, InvoiceImportDetailRepository importDetailRepository, AccountRepository accountRepository, BookRepository bookRepository, ProducerRepository producerRepository) {
        this.importRepository = importRepository;
        this.importDetailRepository = importDetailRepository;
        this.accountRepository = accountRepository;
        this.bookRepository = bookRepository;
        this.producerRepository = producerRepository;
    }

    @Override
    public String createInvoiceImport(InvoiceImportRequest request) {

        Account account = accountRepository.findById(request.getAccountId()).orElseThrow(() -> new EntityNotFoundException("account isn't existed"));
        Book book = bookRepository.findById(request.getBookId()).orElseThrow(() -> new EntityNotFoundException("book isn't existed"));
        Producer producer = producerRepository.findById(request.getProducerId()).orElseThrow(() -> new RuntimeException("producer is not found"));

        InvoiceImport invoiceImport = new InvoiceImport();
        invoiceImport.setDateImport(request.getDateImport());
        invoiceImport.setAccount(account);
        invoiceImport.setProducer(producer);
        InvoiceImport invoiceImportSave = importRepository.save(invoiceImport);

        InvoiceImportDetails invoiceImportDetails = new InvoiceImportDetails();
        invoiceImportDetails.setBook(book);
        invoiceImportDetails.setQuantity(request.getQuantity());
        invoiceImportDetails.setInvoiceImport(invoiceImportSave);
        importDetailRepository.save(invoiceImportDetails);

        return "Successfully!";
    }
}
