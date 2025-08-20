export interface ListingFilter {
  purpose?: Purpose | null;
  location?: string | null;               // region/city/location/free text
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

export const LUXEMBOURG_COMMUNES = [
  // — Communes / Cities (30) —
  'Luxembourg',
  'Esch-sur-Alzette',
  'Differdange',
  'Dudelange',
  'Bettembourg',
  'Pétange',
  'Kayl',
  'Schifflange',
  'Rumelange',
  'Mondercange',
  'Sanem',
  'Hesperange',
  'Strassen',
  'Bertrange',
  'Mamer',
  'Walferdange',
  'Steinsel',
  'Contern',
  'Niederanven',
  'Schuttrange',
  'Junglinster',
  'Kehlen',
  'Roeser',
  'Steinfort',
  'Mersch',
  'Ettelbruck',
  'Diekirch',
  'Grevenmacher',
  'Remich',
  'Mondorf-les-Bains',

  // — Luxembourg City quarters (16) —
  'Kirchberg',
  'Gasperich',
  'Gare',
  'Belair',
  'Bonnevoie',
  'Limpertsberg',
  'Hollerich',
  'Cents',
  'Cessange',
  'Merl',
  'Beggen',
  'Dommeldange',
  'Hamm',
  'Grund',
  'Pfaffenthal',
  'Weimerskirch',

  // — Major localities outside the city (14) —
  'Belval',        // Esch-sur-Alzette
  'Oberkorn',      // Differdange
  'Niederkorn',    // Differdange
  'Belvaux',       // Sanem
  'Soleuvre',      // Sanem
  'Rodange',       // Pétange
  'Lamadelaine',   // Pétange
  'Foetz',         // Mondercange
  'Noertzange',    // Bettembourg
  'Howald',        // Hesperange
  'Berchem',       // Roeser
  'Bascharage',    // Käerjeng
  'Capellen',      // Mamer
  'Senningerberg'  // Niederanven
] as const;

export const COMMUNE_OPTIONS = LUXEMBOURG_COMMUNES.map(c => ({ value: c, label: c }));

