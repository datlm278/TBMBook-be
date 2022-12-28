package com.example.tbmbookbe.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CHI_TIET_PNK")
@Data
public class InvoiceImportDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "so_luong")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "id_sach", referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "id_PNK", referencedColumnName = "id")
    private InvoiceImport invoiceImport;
}
