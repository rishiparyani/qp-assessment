package com.questionpro.assessment.repository;

import com.questionpro.assessment.model.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
