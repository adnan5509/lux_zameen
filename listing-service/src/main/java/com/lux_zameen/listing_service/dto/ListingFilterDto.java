package com.lux_zameen.listing_service.dto;

import jakarta.annotation.Nullable;

/**
 * Represents the filter criteria for listing properties.
 */
public record ListingFilterDto(
        @Nullable String purpose,
        @Nullable String propertyType,
        @Nullable String city,
        @Nullable String location,
        @Nullable Double minPrice,
        @Nullable Double maxPrice,
        @Nullable Double minArea,
        @Nullable Double maxArea,
        @Nullable Boolean installmentAvailable,
        @Nullable String status
) {}