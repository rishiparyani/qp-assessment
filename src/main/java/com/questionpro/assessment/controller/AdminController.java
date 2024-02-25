package com.questionpro.assessment.controller;

import com.questionpro.assessment.model.ItemEntity;
import com.questionpro.assessment.pojo.Item;
import com.questionpro.assessment.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
