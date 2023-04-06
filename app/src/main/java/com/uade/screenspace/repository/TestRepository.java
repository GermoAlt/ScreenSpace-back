package com.uade.screenspace.repository;

import com.uade.screenspace.entity.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<GroceryItem, String> {

    GroceryItem findByCategory(String category);

}
