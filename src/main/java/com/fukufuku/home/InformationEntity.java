package com.fukufuku.home;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;

@Table(name = "information")
@javax.persistence.Entity
public class InformationEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;
    private Date createdAt;

    protected InformationEntity() {
    }

    public InformationEntity(String text, Date createdAt) {
        this.text = text;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getCreatedAtFormatted() {
        SimpleDateFormat d1 = new SimpleDateFormat("yyyy.MM.dd");
        return d1.format(createdAt);
    }
}


