package ru.gb.sbootmarket.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "buying_date")
    private Date buying_date;

    @Column(name = "buying_price")
    private float buying_price;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    public Buyer getBuyer() {
        return buyer;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBuying_date() {
        return buying_date;
    }

    public void setBuying_date(Date buying_date) {
        this.buying_date = buying_date;
    }

    public float getBuying_price() {
        return buying_price;
    }

    public void setBuying_price(float buying_price) {
        this.buying_price = buying_price;
    }



}
