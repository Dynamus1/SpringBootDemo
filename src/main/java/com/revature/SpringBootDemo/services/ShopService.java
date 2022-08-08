package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {

    boolean createShop(Shop shop);

    Shop getShopById(int id);

    List<Shop> getAllShops();

    int updateShop(Shop shop);

    boolean deleteShop(Shop shop);

}
