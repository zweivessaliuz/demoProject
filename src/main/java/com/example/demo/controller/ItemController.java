package com.example.demo.controller;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping("/addItem")
    public Item addItem(@RequestBody Item item) {
        return service.saveItem(item);
    }

    @PostMapping("/addItems")
    public List<Item> addItems(@RequestBody List<Item> items) {
        return service.saveItems(items);
    }

    @GetMapping("/items")
    public List<Item> findAllItems() {
        return service.getItems();
    }

    @GetMapping("/itemById/{id}")
    public Item findItemById(@PathVariable int id) {
        return service.getItemById(id);
    }

    @GetMapping("/item/{name}")
    public Item findItemByName(@PathVariable String name) {
        return service.getItemByName(name);
    }

    @PutMapping("/update")
    public Item updateItem(@RequestBody Item item) {
        return service.updateItem(item);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable int id) {
        return service.deleteItem(id);
    }
}
