import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ListingCard } from '../models/listingCard';
import { Page } from '../models/page';
import { ListingFilter } from '../models/listingFilter';

@Injectable({
  providedIn: 'root'
})
export class ListingService {

  private baseUrl = '/api/listings';

  constructor(private httpClient: HttpClient) {
  }

  getLatest(page = 0, size = 3): Observable<Page<ListingCard>> {
    const params = new HttpParams().set('page', page).set('size', size);
    const url = `${this.baseUrl}/latest`;
    return this.httpClient.get<Page<ListingCard>>(url, { params });
  }


  getPropertiesCount() {
    const url = `${this.baseUrl}/properties-count`;
    return this.httpClient.get<number>(url);
  }

  searchListings(filter: ListingFilter, page = 0, size = 6, sort?: string) {
    let params = new HttpParams().set('page', page).set('size', size);
    if (sort) params = params.set('sort', sort); // e.g. "price,desc"

    // scalars
    if (filter.purpose) params = params.set('purpose', filter.purpose);
    if (filter.location) params = params.set('location', filter.location);
    if (filter.propertyType) params = params.set('propertyType', filter.propertyType);

    // ranges
    if (filter.minPrice != null) params = params.set('minPrice', String(filter.minPrice));
    if (filter.maxPrice != null) params = params.set('maxPrice', String(filter.maxPrice));
    if (filter.bedroomsMin != null) params = params.set('bedroomsMin', String(filter.bedroomsMin));
    if (filter.bedroomsMax != null) params = params.set('bedroomsMax', String(filter.bedroomsMax));
    if (filter.minArea != null) params = params.set('minArea', String(filter.minArea));
    if (filter.maxArea != null) params = params.set('maxArea', String(filter.maxArea));

    return this.httpClient.get<Page<ListingCard>>(`${this.baseUrl}/search`, { params });
  }



}
