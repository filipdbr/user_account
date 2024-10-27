package com.dexentri.user_account.controller;

import com.dexentri.user_account.model.SKU;
import com.dexentri.user_account.service.SKUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller that exposes endpoints for managing SKUs
 */
@RestController
@RequestMapping("/api/sku")
public class SKUController {

    @Autowired
    private SKUService skuService; // service layer for handling business logic

    /**
     * Adds a new SKU to the system
     *
     * @param sku the SKU object sent in the request body
     * @return the saved SKU with a 200 OK status
     */
    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<SKU> addSKU(@RequestBody SKU sku) {
        SKU createdSKU = skuService.addSKU(sku); // call service to add SKU
        return ResponseEntity.ok(createdSKU); // return created SKU
    }

    /**
     * Retrieves all SKUs from the system
     *
     * @return a list of SKUs with a 200 OK status
     */
    @GetMapping("/all")
    public ResponseEntity<List<SKU>> getAllSKUs() {
        List<SKU> skus = skuService.getAllSKUs(); // fetch all SKUs
        return ResponseEntity.ok(skus); // return list of SKUs
    }

    /**
     * Retrieves a specific SKU by its ID
     *
     * @param id the ID of the SKU to retrieve
     * @return the SKU with the given ID, if found, with a 200 OK status
     */
    @GetMapping("/{id}")
    public ResponseEntity<SKU> getSKUById(@PathVariable String id) {
        SKU sku = skuService.getSKUById(id); // get SKU by id
        return ResponseEntity.ok(sku); // return the SKU
    }

    /**
     * Updates an existing SKU by its ID
     *
     * @param id the ID of the SKU to update
     * @param skuDetails the updated SKU details
     * @return the updated SKU with a 200 OK status
     */
    @PutMapping("/{id}")
    public ResponseEntity<SKU> updateSKU(@PathVariable String id, @RequestBody SKU skuDetails) {
        SKU updatedSKU = skuService.updateSKU(id, skuDetails); // update SKU details
        return ResponseEntity.ok(updatedSKU); // return updated SKU
    }

    /**
     * Deletes a SKU by its ID
     *
     * @param id the ID of the SKU to delete
     * @return a 204 No Content status after deletion
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSKU(@PathVariable String id) {
        skuService.deleteSKU(id); // delete SKU by id
        return ResponseEntity.noContent().build(); // return no content status
    }
}
