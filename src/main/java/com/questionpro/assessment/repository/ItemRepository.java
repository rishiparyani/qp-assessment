package com.questionpro.assessment.repository;

import com.questionpro.assessment.model.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
