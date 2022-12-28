package com.example.tbmbookbe.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "THE_LOAI")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ten_the_loai")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cha", referencedColumnName = "id")
    private Type parentId;
    @OneToMany(mappedBy = "parentId")
    private List<Type> childType;

}
