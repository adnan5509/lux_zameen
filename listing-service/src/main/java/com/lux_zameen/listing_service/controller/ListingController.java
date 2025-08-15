package com.lux_zameen.listing_service.controller;

import com.lux_zameen.listing_service.dto.CreateListingRequest;
import com.lux_zameen.listing_service.dto.ListingCard;
import com.lux_zameen.listing_service.dto.ListingFilterDto;
import com.lux_zameen.listing_service.dto.ListingResponse;
import com.lux_zameen.listing_service.entity.Listing;
import com.lux_zameen.listing_service.service.ListingService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/listings")
public class ListingController {

    private final ListingService listingService;

    public ListingController(final ListingService listingService) {
        this.listingService = listingService;
    }

    @PostMapping("/create")
    public ResponseEntity<ListingResponse> createListing(@RequestBody @Valid CreateListingRequest request) {
        ListingResponse response = listingService.createListing(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ListingCard>> searchListings(@ModelAttribute ListingFilterDto filter, Pageable pageable) {
        Page<ListingCard> listings = listingService.searchListings(filter, pageable);
        return ResponseEntity.ok(listings);

    }

    @GetMapping("/latest")
    public ResponseEntity<Page<ListingCard>> getLatestListings(@PageableDefault(size = 3, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ListingCard> latestListings = listingService.getLatestListings(pageable);
        return ResponseEntity.ok(latestListings);
    }


}
