package com.curdcuboverde.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdImage;
    private String UrlImage;
    private String DescriptionImage;
    private Long IdContent;
    private Long IdFeedBack;
    private String CreationDate;
}
