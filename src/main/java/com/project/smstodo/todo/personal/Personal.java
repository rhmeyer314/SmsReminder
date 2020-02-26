package com.project.smstodo.todo.personal;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

// Personal Model class for database
@Entity
public class Personal {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id",updatable = false, nullable = false)
    private String id;
    private String item;

    public Personal() {

    }

    public Personal(String id, String item) {
        this.id = id;
        this.item = item;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
