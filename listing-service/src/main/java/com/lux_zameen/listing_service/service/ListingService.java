package com.lux_zameen.listing_service.service;

import com.lux_zameen.listing_service.dto.CreateListingRequest;
import com.lux_zameen.listing_service.dto.ListingFilterDto;
import com.lux_zameen.listing_service.dto.ListingResponse;
import com.lux_zameen.listing_service.entity.Listing;
import com.lux_zameen.listing_service.filter.ListingFilterSpecs;
import com.lux_zameen.listing_service.mapper.ListingMapper;
import com.lux_zameen.listing_service.repository.ListingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ListingService {

    private final ListingRepository listingRepository;
    private final ListingMapper listingMapper;

    public ListingService(final ListingRepository listingRepository, final ListingMapper listingMapper) {
        this.listingRepository = listingRepository;
        this.listingMapper = listingMapper;
    }

    public ListingResponse createListing(final CreateListingRequest request) {
        Listing listing = listingMapper.CreateListingToListing(request);
        Listing savedListing = listingRepository.save(listing);
        return listingMapper.ListingToListingResponse(savedListing);

    }

    public Page<Listing> searchListings(final ListingFilterDto filter, final Pageable pageable) {
        Specification<Listing> listingSpecification = ListingFilterSpecs.filterListingsByCriteria(filter);
        return listingRepository.findAll(listingSpecification, pageable);
    }
}
