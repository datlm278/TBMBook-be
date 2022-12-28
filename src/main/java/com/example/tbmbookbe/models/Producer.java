package com.example.tbmbookbe.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "NHA_XUAT_BAN")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ten_NXB")
    private String name;
}
