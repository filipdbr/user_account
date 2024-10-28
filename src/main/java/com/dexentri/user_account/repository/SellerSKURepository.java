package com.dexentri.user_account.repository;

import com.dexentri.user_account.model.SellerSKU;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface for managing SellerSKU documents in MongoDB
 */
public interface SellerSKURepository extends MongoRepository<SellerSKU, String> {
}
