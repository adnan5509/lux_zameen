package com.lux_zameen.listing_service.repository;

import com.lux_zameen.listing_service.entity.Listing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long>, JpaSpecificationExecutor<Listing> {
    long countByStatusIgnoreCase(String status);

}
