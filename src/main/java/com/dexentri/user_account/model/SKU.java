package com.dexentri.user_account.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;
import com.dexentri.user_account.model.Profile;

/**
 * Represents an SKU (Stock Keeping Unit) document stored in MongoDB.
 * Each SKU can belong to multiple profiles and contains references to associated profiles.
 */
@Data
@Document(collection = "sku")
public class SKU {

    @Id
    private String id; // unique SKU identifier
    private String name; // name of the product
    private String description; // brief description of the product
    private List<String> imageUrls; // list of image URLs related to the SKU

    @DBRef
    private Set<Profile> profiles; // references to associated profiles
}
