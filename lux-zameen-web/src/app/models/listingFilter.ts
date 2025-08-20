export interface ListingFilter {
  purpose?: Purpose | null;
  q?: string | null;               // region/city/location/free text
  propertyType?: string | null;
  minPrice?: number | null;
  maxPrice?: number | null;
  bedroomsMin?: number | null;
  bedroomsMax?: number | null;
  minArea?: number | null;         // m²
  maxArea?: number | null;
}


export const PROPERTY_TYPE_OPTIONS = [
  { value: 'HOUSE', label: 'House' },
  { value: 'APARTMENT', label: 'Apartment' },
  { value: 'NEW_PROPERTY', label: 'New property' },
  { value: 'NEW_HOUSE', label: 'New house' },
  { value: 'INVESTMENT_BUILDING', label: 'Investment building' },
  { value: 'LAND', label: 'Land' },
  { value: 'GARAGE_PARKING', label: 'Garage - parking' },
  { value: 'OFFICE', label: 'Office' },
  { value: 'COMMERCIAL_PROPERTY', label: 'Commercial Property' }
];

export const PURPOSE_OPTIONS = [
  { value: 'Rent', label: 'Rent' },
  { value: 'Buy', label: 'Buy' },
  { value: 'Sell', label: 'Sell' },
];

export type Purpose = 'Sell' | 'Rent' | 'Buy'

