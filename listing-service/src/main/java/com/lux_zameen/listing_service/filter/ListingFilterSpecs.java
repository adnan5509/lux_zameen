package com.lux_zameen.listing_service.filter;

import com.lux_zameen.listing_service.dto.ListingFilterDto;
import com.lux_zameen.listing_service.entity.Listing;
import jakarta.annotation.Nullable;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor
public final class ListingFilterSpecs {

    public static final String PROPERTY_TYPE = "propertyType";
    public static final String PURPOSE = "purpose";
    public static final String CITY = "city";
    public static final String LOCATION = "location";
    public static final String PRICE = "price";
    public static final String STATUS = "status";
    public static final String SORT_BY = "sortBy";
    public static final String SORT_ORDER = "sortOrder";


    public static Specification<Listing> filterListingsByCriteria(ListingFilterDto listingFilter) {
        if (listingFilter == null) {
            return Specification.where(null);
        } else {
            return Specification.where(purposeEquals(listingFilter.purpose()))
                    .and(propertyTypeEquals(listingFilter.propertyType()))
                    .and(cityEquals(listingFilter.city()))
                    .and(locationEquals(listingFilter.location()))
                    .and(priceBetween(listingFilter.minPrice(), listingFilter.maxPrice()))
                    .and(areaBetween(listingFilter.minArea(), listingFilter.maxArea()))
                    .and(statusEquals(listingFilter.status()))
                    .and(installmentAvailableEquals(listingFilter.installmentAvailable()));
        }
    }

    public static Specification<Listing> purposeEquals(final String purpose) {
        return (root, query, criteriaBuilder) -> isBlank(purpose) ? null :
                criteriaBuilder.equal(criteriaBuilder.lower(root.get(PURPOSE)), purpose.toLowerCase());
    }

    public static Specification<Listing> propertyTypeEquals(final String propertyType) {
        return (root, query, criteriaBuilder) -> isBlank(propertyType) ? null :
                criteriaBuilder.equal(criteriaBuilder.lower(root.get(PROPERTY_TYPE)), propertyType.toLowerCase());
    }

    public static Specification<Listing> cityEquals(final String city) {
        return ((root, query, criteriaBuilder) -> isBlank(city) ? null :
                criteriaBuilder.equal(criteriaBuilder.lower(root.get(CITY)), city.toLowerCase()));
    }
    public static Specification<Listing> locationEquals(final String location) {
        return ((root, query, criteriaBuilder) -> isBlank(location) ? null :
                criteriaBuilder.equal(criteriaBuilder.lower(root.get(LOCATION)), location.toLowerCase()));
    }

    public static Specification<Listing> priceBetween(@Nullable final Double minPrice, @Nullable final Double maxPrice) {
        return (root, query, criteriaBuilder) -> {
            if (minPrice == null && maxPrice == null) {
                return null;
            } else if (minPrice != null && maxPrice != null) {
                return criteriaBuilder.between(root.get(PRICE), minPrice, maxPrice);
            } else if (minPrice != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(PRICE), minPrice);
            } else {
                return criteriaBuilder.lessThanOrEqualTo(root.get(PRICE), maxPrice);
            }
        };
    }

    public static Specification<Listing> areaBetween(@Nullable final Double minArea, @Nullable final Double maxArea) {
        return (root, query, criteriaBuilder) -> {
            if (minArea == null && maxArea == null) {
                return null;
            } else if (minArea != null && maxArea != null) {
                return criteriaBuilder.between(root.get("areaSize"), minArea, maxArea);
            } else if (minArea != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("areaSize"), minArea);
            } else {
                return criteriaBuilder.lessThanOrEqualTo(root.get("areaSize"), maxArea);
            }
        };
    }

    public static Specification<Listing> installmentAvailableEquals(Boolean val) {
        return (root, q, cb) -> val == null ? null : cb.equal(root.get("installmentAvailable"), val);
    }

    public static Specification<Listing> statusEquals(final String status) {
        return (root, query, criteriaBuilder) -> isBlank(status) ? null :
                criteriaBuilder.equal(criteriaBuilder.lower(root.get(STATUS)), status.toLowerCase());
    }

    /**
     * Checks if a string is blank (null or empty after trimming).
     *
     * @param value the string to check
     * @return true if the string is blank, false otherwise
     */
    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

}
