package com.questionpro.assessment.service;

import com.questionpro.assessment.model.ItemEntity;
import com.questionpro.assessment.pojo.Item;
import com.questionpro.assessment.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {
    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public ItemEntity saveItem(Item item) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setName(item.getName());
        itemEntity.setPrice(item.getPrice());

        return itemRepository.save(itemEntity);
    }
}
