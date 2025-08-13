package com.lux_zameen.listing_service.mapper;

import com.lux_zameen.listing_service.dto.CreateListingRequest;
import com.lux_zameen.listing_service.dto.ListingResponse;
import com.lux_zameen.listing_service.entity.Listing;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ListingMapper {

    Listing CreateListingToListing(CreateListingRequest createListingRequest);
    ListingResponse ListingToListingResponse(Listing listing);


}
