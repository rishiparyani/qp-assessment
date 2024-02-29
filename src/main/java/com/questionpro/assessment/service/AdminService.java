package com.questionpro.assessment.service;

import com.questionpro.assessment.model.ItemEntity;
import com.questionpro.assessment.pojo.Item;
import com.questionpro.assessment.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public ItemEntity saveItem(Item item) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setName(item.getName());
        itemEntity.setPrice(item.getPrice());
        itemEntity.setStock(item.getQuantity());

        return itemRepository.save(itemEntity);
    }

    public List<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }

    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }

    @Transactional
    public Boolean updateItem(Long itemId, Item item) {
        Optional<ItemEntity> itemEntity = itemRepository.findById(itemId);
        if (itemEntity.isEmpty())
            return false;
        else {
            ItemEntity itemEntity1 = itemEntity.get();
            itemEntity1.setName(item.getName());
            itemEntity1.setPrice(item.getPrice());
            itemRepository.save(itemEntity1);
            return true;
        }

    }

    @Transactional
    public Boolean manipulateStock(Long itemId, Item item) {
        Optional<ItemEntity> itemEntity = itemRepository.findById(itemId);
        if (itemEntity.isEmpty())
            return false;
        else {
            ItemEntity itemEntity1 = itemEntity.get();
            if (item.getOperation().equalsIgnoreCase("change"))
                itemEntity1.setStock(item.getQuantity());
            if (item.getOperation().equalsIgnoreCase("purchase"))
                itemEntity1.setStock(itemEntity1.getStock() + item.getQuantity());
            if (item.getOperation().equalsIgnoreCase("sale"))
                itemEntity1.setStock(itemEntity1.getStock() - item.getQuantity());
            itemRepository.save(itemEntity1);
            return true;
        }
    }
}
