package com.questionpro.assessment.controller;

import com.questionpro.assessment.constants.Strings;
import com.questionpro.assessment.model.ItemEntity;
import com.questionpro.assessment.pojo.Item;
import com.questionpro.assessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/available-items")
    public ResponseEntity<List<ItemEntity>> viewAvailableItems() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllAvailable());
    }

    @PutMapping("/book")
    public ResponseEntity<String> bookItems(@RequestBody List<Item> itemList) {
        userService.book(itemList);
        return ResponseEntity.status(HttpStatus.OK).body(Strings.SUCCESSFUL_BOOKING);
    }
}
