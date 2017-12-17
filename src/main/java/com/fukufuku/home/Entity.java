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

    protected Entity() {}

    public Entity(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s']", id, text);
    }
}