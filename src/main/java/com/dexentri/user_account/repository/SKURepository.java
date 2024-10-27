package com.dexentri.user_account.repository;

import com.dexentri.user_account.model.SKU;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface for managing SKU documents in MongoDB.
 */
public interface SKURepository extends MongoRepository<SKU, String> {
}
