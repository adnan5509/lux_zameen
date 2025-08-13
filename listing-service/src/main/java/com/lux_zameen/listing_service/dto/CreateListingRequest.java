package com.lux_zameen.listing_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateListingRequest {

    @NotBlank(message = "Purpose is required")
    @Pattern(regexp = "Sell|Rent", message = "Purpose must be 'Sell' or 'Rent'")
    private String purpose; // Sell or Rent

    @NotBlank(message = "Property type is required")
    @Pattern(regexp = "Home|Plots|Commercial|House|Flat|Upper Portion|Lower Portion|Farm House|Room|Penthouse",
            message = "Invalid property type")
    private String propertyType;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Area size is required")
    @Min(value = 0, message = "Area size must be non-negative")
    private Double areaSize; // In square meters or marla, depending on region

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be non-negative")
    private Double price;

    private Boolean installmentAvailable; // Optional, defaults to false
    private Boolean readyForPossession; // Optional, defaults to false

    @Size(min = 5, message = "At least 5 amenities are required")
    private List<String> amenities; // e.g., parking, internet

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @Size(min = 5, message = "At least 5 images are required")
    private List<String> images; // URLs or base64, max 5MB, .jpg/.png

    private String videoUrl; // YouTube link

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid mobile number format")
    private String mobile;

    private String landline; // Optional, same format as mobile
}


