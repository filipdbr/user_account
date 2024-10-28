package com.dexentri.user_account.controller;

import com.dexentri.user_account.model.SellerSKU;
import com.dexentri.user_account.service.SellerSKUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller that exposes endpoints for managing SellerSKUs.
 */
@RestController
@RequestMapping("/api/seller_skus")
public class SellerSKUController {

    @Autowired
    private SellerSKUService sellerSKUService; // service layer for handling business logic

    /**
     * Adds a new SellerSKU to the system.
     *
     * @param sellerSKU the SellerSKU object sent in the request body.
     * @return the saved SellerSKU with a 200 OK status.
     */
    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<SellerSKU> addSellerSKU(@RequestBody SellerSKU sellerSKU) {
        SellerSKU createdSKU = sellerSKUService.addSellerSKU(sellerSKU); // call service to add SellerSKU
        return ResponseEntity.ok(createdSKU); // return created SellerSKU
    }

    /**
     * Retrieves all SellerSKUs from the system.
     *
     * @return a list of SellerSKUs with a 200 OK status.
     */
    @GetMapping("/all")
    public ResponseEntity<List<SellerSKU>> getAllSellerSKUs() {
        List<SellerSKU> skus = sellerSKUService.getAllSellerSKUs(); // fetch all SellerSKUs
        return ResponseEntity.ok(skus); // return list of SellerSKUs
    }

    /**
     * Retrieves a specific SellerSKU by its ID.
     *
     * @param id the ID of the SellerSKU to retrieve.
     * @return the SellerSKU with the given ID, if found, with a 200 OK status.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SellerSKU> getSellerSKUById(@PathVariable String id) {
        SellerSKU sku = sellerSKUService.getSellerSKUById(id); // get SellerSKU by id
        return ResponseEntity.ok(sku); // return the SellerSKU
    }

    /**
     * Deletes a SellerSKU by its ID.
     *
     * @param id the ID of the SellerSKU to delete.
     * @return a 204 No Content status after deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSellerSKU(@PathVariable String id) {
        sellerSKUService.deleteSellerSKU(id); // delete SellerSKU by id
        return ResponseEntity.noContent().build(); // return no content status
    }
}
