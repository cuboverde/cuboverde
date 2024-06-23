package com.curdcuboverde.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCategory;
    private String DescriptionCategory;
    private String CreationDate;
}
