package com.dexentri.user_account.service;

import com.dexentri.user_account.model.SKU;
import com.dexentri.user_account.repository.SKURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for handling business logic related to SKUs
 */
@Service
public class SKUService {

    @Autowired
    private SKURepository skuRepository; // repository for accessing SKU data

    /**
     * Adds a new SKU to the MongoDB database
     * @param sku the SKU object to be added
     * @return the saved SKU object
     */
    public SKU addSKU(SKU sku) {
        return skuRepository.save(sku);
    }

    /**
     * Retrieves all SKUs from the database
     * @return a list of all SKUs
     */
    public List<SKU> getAllSKUs() {
        return skuRepository.findAll();
    }

    /**
     * Retrieves an SKU by its ID
     * @param id the ID of the SKU to retrieve
     * @return the SKU if found
     */
    public SKU getSKUById(String id) {
        return skuRepository.findById(id).orElseThrow(() -> new RuntimeException("SKU not found"));
    }

    /**
     * Updates an existing SKU by its ID
     * @param id the ID of the SKU to update
     * @param skuDetails the new details for the SKU
     * @return the updated SKU
     */
    public SKU updateSKU(String id, SKU skuDetails) {
        SKU sku = skuRepository.findById(id).orElseThrow(() -> new RuntimeException("SKU not found"));
        sku.setName(skuDetails.getName());
        sku.setDescription(skuDetails.getDescription());
        sku.setImageUrls(skuDetails.getImageUrls());
        return skuRepository.save(sku);
    }

    /**
     * Deletes an SKU by its ID
     * @param id the ID of the SKU to delete
     */
    public void deleteSKU(String id) {
        SKU sku = skuRepository.findById(id).orElseThrow(() -> new RuntimeException("SKU not found"));
        skuRepository.delete(sku);
    }
}
