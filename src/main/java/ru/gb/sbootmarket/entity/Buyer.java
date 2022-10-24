package ru.gb.sbootmarket.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //public Buyer() {        id = -1L;    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "buyer")
    List<Order> orderList;

    @Override
    public String toString() {
        return "BUYER [id=" + id + ", name=" + name + "]";
    }

}
