package com.questionpro.assessment.pojo;

import lombok.Data;

@Data
public class Item {
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity = 0;
    private String operation = "change";
}
