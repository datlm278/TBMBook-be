package com.example.tbmbookbe.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "TAI_KHOAN")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ten_tai_khoan")
    private String username;
    @Column(name = "mat_khau")
    private String password;
    @Column(name = "vai_tro")
    private String role;
    @Column(name = "ho_ten")
    private String name;
    @Column(name = "gioi_tinh")
    private String gender;
    @Column(name = "so_dien_thoai")
    private String phoneNumber;
    @Column(name = "dia_chi")
    private String address;
    @Column(name = "ngay_sinh")
    private Timestamp dob;
}
