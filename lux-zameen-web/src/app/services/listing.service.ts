import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ListingCard } from '../models/listingCard';
import { Page } from '../models/page';

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


}
