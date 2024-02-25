package com.questionpro.assessment.controller;

import com.questionpro.assessment.model.ItemEntity;
import com.questionpro.assessment.pojo.Item;
import com.questionpro.assessment.service.AdminService;
import com.questionpro.assessment.constants.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public ResponseEntity<ItemEntity> addGroceryItems(@RequestBody Item item) {
        ItemEntity savedItem = adminService.saveItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    @GetMapping("/view-all")
    public ResponseEntity<List<ItemEntity>> viewGroceryItems() {
        List<ItemEntity> items = adminService.getAllItems();
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    @DeleteMapping("/delete-item/{itemId}")
    public ResponseEntity<String> deleteGroceryItem(@PathVariable Long itemId) {
        adminService.deleteItem(itemId);
        return ResponseEntity.status(HttpStatus.OK).body(Strings.SUCCSESSFUL_DELETE);
    }
}
