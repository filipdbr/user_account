package com.dexentri.user_account.service;

import com.dexentri.user_account.model.SellerSKU;
import com.dexentri.user_account.repository.SellerSKURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling business logic related to Seller SKUs.
 */
@Service
public class SellerSKUService {

    @Autowired
    private SellerSKURepository sellerSKURepository;

    /**
     * Adds a new SellerSKU to the MongoDB database.
     * @param sellerSKU the SellerSKU object to be added.
     * @return the saved SellerSKU object.
     */
    public SellerSKU addSellerSKU(SellerSKU sellerSKU) {
        return sellerSKURepository.save(sellerSKU);
    }

    /**
     * Retrieves all SellerSKUs from the database.
     * @return a list of all SellerSKUs.
     */
    public List<SellerSKU> getAllSellerSKUs() {
        return sellerSKURepository.findAll();
    }

    /**
     * Retrieves a SellerSKU by its ID.
     * @param id the ID of the SellerSKU to retrieve.
     * @return the SellerSKU if found.
     */
    public SellerSKU getSellerSKUById(String id) {
        return sellerSKURepository.findById(id).orElseThrow(() -> new RuntimeException("Seller SKU not found"));
    }

    /**
     * Deletes a SellerSKU by its ID.
     * @param id the ID of the SellerSKU to delete.
     */
    public void deleteSellerSKU(String id) {
        SellerSKU sku = sellerSKURepository.findById(id).orElseThrow(() -> new RuntimeException("Seller SKU not found"));
        sellerSKURepository.delete(sku);
    }
}

