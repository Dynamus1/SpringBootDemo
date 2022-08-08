package com.revature.SpringBootDemo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="shops")
@Data
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private int id;

    @Column(name = "s_name",unique = true,nullable = false)
    private String shopName;

    @Column(name="s_inven_count", nullable = false)
    private int inventoryCount;

//    @ManyToOne
//    @Column(name="candies_in_shop", referencedColumnName = "c_id")


    public Shop() {
        super();
    }

    public Shop(int id) {
        super();
        this.id = id;
    }

    public Shop(int id, String shopName, int inventoryCount) {
        super();
        this.id = id;
        this.shopName = shopName;
        this.inventoryCount = inventoryCount;
    }

    public Shop(String shopName, int inventoryCount) {
        super();
        this.shopName = shopName;
        this.inventoryCount = inventoryCount;
    }

    public Shop(String shopName, int inventoryCount, int id) {
        super();
        this.shopName = shopName;
        this.inventoryCount = inventoryCount;
        this.id = id;
    }

}
