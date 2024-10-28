package com.dexentri.user_account.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

/**
 * Represents a seller-specific SKU based on a product from the catalog.
 */
@Data
@Document(collection = "seller_skus")
public class SellerSKU {

    @Id
    private String id; // unique SKU identifier for the seller

    private String name; // seller-specific name for the SKU
    private String description; // seller-specific description

    private List<String> imageUrls; // list of image URLs related to the seller's SKU

    @DBRef
    private Product product; // reference to the product from the shared catalog

    @DBRef
    private Set<Profile> profiles; // references to associated profiles
}
