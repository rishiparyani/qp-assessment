package com.questionpro.assessment.service;

import com.questionpro.assessment.model.ItemEntity;
import com.questionpro.assessment.pojo.Item;
import com.questionpro.assessment.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private ItemRepository itemRepository;

    public List<ItemEntity> findAllAvailable() {
        return itemRepository.findAllAvailable();
    }

    @Transactional
    public void book(List<Item> itemList) {
        List<Long> ids = itemList.stream().map(Item::getId).toList();
        List<ItemEntity> itemEntityList = itemRepository.findAllById(ids);

        Map<Long, Integer> quantityMap = new HashMap<>();
        for (Item item : itemList) {
            quantityMap.put(item.getId(), item.getQuantity());
        }

        for (ItemEntity itemEntity : itemEntityList) {
            Integer quantityToUpdate = quantityMap.get(itemEntity.getId());
            if (quantityToUpdate != null) {
                itemEntity.setStock(itemEntity.getStock() - quantityToUpdate);
            }
        }

        itemRepository.saveAll(itemEntityList);
    }
}
