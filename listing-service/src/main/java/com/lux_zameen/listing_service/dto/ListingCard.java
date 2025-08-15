package com.lux_zameen.listing_service.dto;

import java.time.LocalDateTime;

public record ListingCard(
        Long id,
        String title,
        String city,
        String location,
        String propertyType,
        String purpose,
        Double price,
        Double areaSize,
        String status,
        String thumbnailUrl,
        LocalDateTime createdDate
) {

}

