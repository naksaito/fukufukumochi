package com.fukufuku.home;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "messages")
@javax.persistence.Entity
public class Entity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;

    protected Entity() {
    }

    public Entity(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}


