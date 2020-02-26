package com.project.smstodo.todo.professional;

import javax.persistence.*;

@Entity
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false, nullable = false)
    private int id;
    private String item;

    public Professional() {

    }

    public Professional(int id, String item) {
        this.id = id;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
