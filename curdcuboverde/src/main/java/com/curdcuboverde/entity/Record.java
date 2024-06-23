package com.curdcuboverde.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdRecord;
    private String Record;
    private String DescriptionRecord;
    private Long IdFeedBack;
    private String CreationDate;
}
