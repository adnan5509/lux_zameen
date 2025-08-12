package com.lux_zameen.listing_service.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "listings")
@Data
@NoArgsConstructor
public class Listing {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "purpose", nullable = false)
    private String purpose; // Sell or Rent

    @Column(name = "property_type", nullable = false)
    private String propertyType; // e.g., House, Flat

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "area_size", nullable = false)
    private Double areaSize; // In square meters or marla

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "installment_available")
    private Boolean installmentAvailable; // Defaults to false

    @Column(name = "ready_for_possession")
    private Boolean readyForPossession; // Defaults to false

    @ElementCollection
    @CollectionTable(name = "listing_amenities", joinColumns = @JoinColumn(name = "listing_id"))
    @Column(name = "amenity")
    private List<String> amenities; // e.g., parking, internet

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @ElementCollection
    @CollectionTable(name = "listing_images", joinColumns = @JoinColumn(name = "listing_id"))
    @Column(name = "image_url")
    private List<String> images; // URLs or base64

    @Column(name = "video_url")
    private String videoUrl; // YouTube link

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "landline")
    private String landline;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "status", nullable = false)
    private String status; // e.g., "ACTIVE", "PENDING", "SOLD"

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        status = "PENDING"; // Default status
    }
}