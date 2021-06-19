package com.laioffer.eco.repository;

import com.laioffer.eco.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {

}
