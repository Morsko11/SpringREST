package com.restful.restproject.services;

import com.restful.restproject.models.Shop;
import com.restful.restproject.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    public ShopRepository shopRepository;

    @Autowired
    public Service(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public void saveOrUpdate(Shop shop) {
        shopRepository.save(shop);
    }

    public void deleteShop(int id) {
        shopRepository.deleteById(id);
    }

    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    public Optional<Shop> getShopById(int id) {
        return shopRepository.findById(id);
    }

    public Shop getShopByName(String name) {
        return shopRepository.findByName(name);

    }

    public List<Shop> getMore(Integer more) {
        return shopRepository.getMoreThan(more);
    }

}
