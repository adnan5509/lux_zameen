package com.lux_zameen.listing_service.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ListingResponse {
    private String id;
    private String purpose; // Sell or Rent
    private String propertyType; // e.g., House, Flat
    private String city;
    private String location;
    private Double areaSize; // In square meters or marla
    private Double price;
    private Boolean installmentAvailable; // Defaults to false
    private Boolean readyForPossession; // Defaults to false
    private List<String> amenities; // e.g., parking, internet
    private String title;
    private String description;
    private List<String> images; // URLs or base64
    private String thumbnailUrl; //thumbnail Url
    private String videoUrl; // YouTube link
    private String email;
    private String mobile;
    private String landline;
    private LocalDateTime createdDate;
    private String status; // e.g., "PENDING", "ACTIVE", "SOLD"
    private Integer views; // Number of times viewed
//    private String message; // Success or error message
}
