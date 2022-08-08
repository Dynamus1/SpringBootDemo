package com.revature.SpringBootDemo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "candies")
@Data
public class Candy {
 int x = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private int id;

    @Column(name = "c_name",unique = true,nullable = false)
    private String name;

    @Column(name = "c_price", nullable = false)
    private double price;

    @ManyToOne //1st "Many" describes the class - many candies to one shop in this case
//    @OneToOne(cascade = {CascadeType.ALL}) //One Candy can be in One Shop
//    @JoinColumn(name = "shop_s_id")
    @JoinColumn(name = "c_shop",referencedColumnName = "s_id")
    private Shop shop;

    public Candy() {
        super();
    }

    public Candy(int id, String name, double price, Shop shop) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.shop = shop;
    }

    public Candy(String name, double price, Shop shop) {
        super();
        this.name = name;
        this.price = price;
        this.shop = shop;
    }

    public Candy(String name, double price, int id) {
        super();
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public Candy(int id) {
        super();
        this.id = id;
    }
}
