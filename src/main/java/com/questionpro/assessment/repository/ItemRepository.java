package com.questionpro.assessment.repository;

import com.questionpro.assessment.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
