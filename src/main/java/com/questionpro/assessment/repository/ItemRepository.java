package com.questionpro.assessment.repository;

import com.questionpro.assessment.model.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
    @Query("SELECT i FROM ItemEntity i WHERE i.stock > 0")
    List<ItemEntity> findAllAvailable();
}
