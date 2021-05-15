package com.springtests.mvc.springmvctest.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alien", schema = "springapp")
public class Alien {
    public Alien(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Alien() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    private int id;
    private String name;
}
