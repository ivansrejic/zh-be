package com.example.zhbe.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name="categories")
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL)
    private List<Product> products;

}
