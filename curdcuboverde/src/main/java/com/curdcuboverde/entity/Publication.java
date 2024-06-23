package com.curdcuboverde.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Publications")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPublication;
    private Long IdCategory;
    private String TypePublication;
    private String TitlePublication;
    private String DescriptionPublication;
    private String Approved;
    private Long IdUser;
    private String PublicationDate;
    private String CreationDate;
    private Long Favorites;
    private Long Shared;
    private Long Likes;
    private String Images;


}
