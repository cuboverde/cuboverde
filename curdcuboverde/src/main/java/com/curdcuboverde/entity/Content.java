package com.curdcuboverde.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Contents")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdContent;
    private String Content;
    private String DateContent;
    private Long IdPublication;
    private String CreationDate;
}
