// listing.model.ts

// Enums (string unions) to match your backend values
export type Purpose = 'Rent' | 'Buy' | 'Sell';

export type PropertyType =
    | 'HOUSE'
    | 'APARTMENT'
    | 'NEW_PROPERTY'
    | 'NEW_HOUSE'
    | 'INVESTMENT_BUILDING'
    | 'LAND'
    | 'GARAGE_PARKING'
    | 'OFFICE'
    | 'COMMERCIAL_PROPERTY';

export type ListingStatus = 'ACTIVE' | 'PENDING' | 'INACTIVE';

// Exact shape of the API response
export interface ListingDto {
    id: number;
    purpose: Purpose;
    propertyType: PropertyType;
    city: string;
    location: string;
    areaSize: number;
    price: number;
    installmentAvailable: boolean;
    readyForPossession: boolean;
    amenities: string[];
    title: string;
    description: string;
    images: string[];
    videoUrl: string;
    thumbnailUrl: string;
    email: string;
    mobile: string;
    landline: string;
    createdDate: string;      // ISO string from API
    status: ListingStatus;
}

// Domain model used in the app (createdDate is a Date)
export class Listing {
    id!: number;
    purpose!: Purpose;
    propertyType!: PropertyType;
    city!: string;
    location!: string;
    areaSize!: number;
    price!: number;
    installmentAvailable!: boolean;
    readyForPossession!: boolean;
    amenities!: string[];
    title!: string;
    description!: string;
    images!: string[];
    videoUrl!: string;
    thumbnailUrl!: string;
    email!: string;
    mobile!: string;
    landline!: string;
    createdDate!: Date;       // converted
    status!: ListingStatus;

    constructor(init: Omit<Listing, never>) {
        Object.assign(this, init);
    }

    static fromDto(d: ListingDto): Listing {
        return new Listing({
            ...d,
            createdDate: new Date(d.createdDate),
        });
    }
}
