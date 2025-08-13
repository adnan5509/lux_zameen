package com.lux_zameen.listing_service.controller;

import com.lux_zameen.listing_service.dto.CreateListingRequest;
import com.lux_zameen.listing_service.dto.ListingResponse;
import com.lux_zameen.listing_service.service.ListingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ListingResponse> createListing(@RequestBody @Valid CreateListingRequest request){
        ListingResponse response = listingService.createListing(request);
        return ResponseEntity.ok(response);
    }

}
