package com.curdcuboverde.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="FeedBack")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdFeedBack;
    private String TypeFeedBack;
    private String DescriptionFeedBack;
    private Long IdUser;
    private String feedBackDate;
    private String CreationDate;
}
