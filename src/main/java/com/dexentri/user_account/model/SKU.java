package com.dexentri.user_account.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

/**
 * Represents an SKU (Stock Keeping Unit) document stored in MongoDB.
 * Each SKU can belong to multiple profiles and contains references to associated profiles.
 */
@Data
@Document(collection = "sku")
public class SKU {

    @Id
    private String id;
    private String name;
    private String description;
    private List<String> imageUrls;

    @DBRef
    private Set<Profile> profiles;
}
