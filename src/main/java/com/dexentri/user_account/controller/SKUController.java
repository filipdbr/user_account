package com.dexentri.user_account.controller;

import com.dexentri.user_account.model.SKU;
import com.dexentri.user_account.service.SKUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller that exposes endpoints for managing SKUs.
 */
@RestController
@RequestMapping("/api/sku")
public class SKUController {

    @Autowired
    private SKUService skuService;

    /**
     * POST endpoint to add a new SKU.
     * @param sku - The SKU object sent in the request body.
     * @return ResponseEntity with the saved SKU and a 200 OK status.
     */
    @PostMapping("/add")
    public ResponseEntity<SKU> addSKU(@RequestBody SKU sku) {
        SKU createdSKU = skuService.addSKU(sku);
        return ResponseEntity.ok(createdSKU);
    }
}
