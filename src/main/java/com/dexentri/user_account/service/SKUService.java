package com.dexentri.user_account.service;

import com.dexentri.user_account.model.SKU;
import com.dexentri.user_account.repository.SKURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling business logic related to SKUs.
 */
@Service
public class SKUService {

    @Autowired
    private SKURepository skuRepository;

    /**
     * Adds a new SKU to the MongoDB database.
     * @param sku - The SKU object to be added.
     * @return The saved SKU object.
     */
    public SKU addSKU(SKU sku) {
        return skuRepository.save(sku);
    }
}
