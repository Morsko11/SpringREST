package com.restful.restproject.controllers;

import com.fasterxml.jackson.databind.node.TextNode;
import com.restful.restproject.models.Shop;
import com.restful.restproject.services.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Text;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
@Slf4j
public class ShopController {

    private Service service;

    @Autowired
    public ShopController(Service service) {
        this.service = service;
    }

    @PostMapping("/save")
    public void saveShop(@RequestBody Shop shop) {
        service.saveOrUpdate(shop);
        log.info("success saving");
    }

    @PutMapping("/update")
    public void updateShop(@RequestBody Shop shop) {
        service.saveOrUpdate(shop);
        log.info("success updating");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteShop(@PathVariable("id") int id) {
        try {
            service.deleteShop(id);
            log.info("success deleting {}", id);
        } catch (Exception e) {
            log.info("failed deleting {}", id);
        }
    }

    @GetMapping("/getAll")
    public List<Shop> findAll() {
        List<Shop> shops = service.getAll();
        log.info("success");
        return shops;
    }


    @RequestMapping("/byId")
    public Shop getShopById(@RequestBody int id) {
        Shop shop = null;
        try {
            shop = service.getShopById(id).get();
            log.info("success getting id");
        } catch (NoSuchElementException e) {
            log.info("failed getting id");
        }

        return shop;
    }


    @GetMapping("/byName")
    public Shop getShopByname(@RequestBody TextNode name) {
        Shop shop = null;
        try {
            shop = service.getShopByName(name.asText());
            log.info("success getting name");
        } catch (NoSuchElementException exception) {
            log.info("failed getting name");
        }
        return shop;
    }

    @RequestMapping("/more")
    public List<Shop> getStuffByValue(@RequestParam("value") Integer value) {
        log.info("success");
        return service.getMore(value);
    }

}
