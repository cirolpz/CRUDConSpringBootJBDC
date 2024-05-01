package org.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name="id")
     long id;
    @Column(name="name")
      String name;

    public Book() {
    }
    public Book(long id, String name){
        this.id=id;
        this.name=name;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
