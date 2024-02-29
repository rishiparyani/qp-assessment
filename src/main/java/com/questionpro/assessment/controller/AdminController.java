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
    public ResponseEntity<ItemEntity> addGroceryItems (@RequestBody Item item) {
        ItemEntity savedItem = adminService.saveItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    @GetMapping("/view-all")
    public ResponseEntity<List<ItemEntity>> viewGroceryItems() {
        List<ItemEntity> items = adminService.getAllItems();
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    @DeleteMapping("/delete-item/{itemId}")
    public ResponseEntity<String> deleteGroceryItem (@PathVariable Long itemId) {
        adminService.deleteItem(itemId);
        return ResponseEntity.status(HttpStatus.OK).body(Strings.SUCCESSFUL_DELETE);
    }

    @PutMapping("/update-item/{itemId}")
    public ResponseEntity<String> updateGroceryItem (@PathVariable Long itemId, @RequestBody Item item) {
        Boolean updated = adminService.updateItem(itemId, item);
        return updated ? ResponseEntity.status(HttpStatus.OK).body(Strings.SUCCESSFUL_UPDATE) : ResponseEntity.status(HttpStatus.OK).body(Strings.UNSUCCESSFUL);
    }

    @PutMapping("/update-stock/{itemId}")
    public ResponseEntity<String> updateStock (@PathVariable Long itemId, @RequestBody Item item) {
        Boolean updated = adminService.manipulateStock(itemId, item);
        return updated ? ResponseEntity.status(HttpStatus.OK).body(Strings.SUCCESSFUL_UPDATE) : ResponseEntity.status(HttpStatus.OK).body(Strings.UNSUCCESSFUL);
    }
}
