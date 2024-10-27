package com.dexentri.user_account.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a user's profile in the system, stored in the MongoDB 'profiles' collection.
 */
@Data
@Document(collection = "profiles")
public class Profile {

    @Id
    private String id; // unique identifier for the profile (autogenerated)
    private String companyName; // name of the company associated with this profile
    private String description; // brief description of the profile or company
}