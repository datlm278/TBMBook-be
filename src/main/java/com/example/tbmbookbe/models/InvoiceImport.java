package com.example.tbmbookbe.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "PHIEU_NHAP_KHO")
public class InvoiceImport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ngay_nhap")
    private Timestamp dateImport;

    @ManyToOne
    @JoinColumn(name = "id_tai_khoan", referencedColumnName = "id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "id_nha_xuat_ban", referencedColumnName = "id")
    private Producer producer;
}
