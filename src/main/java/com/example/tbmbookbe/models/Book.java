package com.example.tbmbookbe.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SACH")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ten_sach")
    private String name;
    @Column(name = "tac_gia")
    private String author;
    @Column(name = "don_gia")
    private Float unitPrice;
    @Column(name = "nam_xuat_ban")
    private String year;
    @ManyToOne
    @JoinColumn(name = "id_the_loai", referencedColumnName = "id")
    private Type typeId;
    @ManyToOne
    @JoinColumn(name = "id_NXB", referencedColumnName = "id")
    private Producer producerId;

}
