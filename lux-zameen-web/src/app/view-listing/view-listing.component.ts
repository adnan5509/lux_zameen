import { Component, inject, computed } from '@angular/core';
import { CommonModule, NgOptimizedImage } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { map, switchMap, filter } from 'rxjs';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatTooltipModule } from '@angular/material/tooltip';
import { Listing, PropertyType } from '../models/listing';
import { ListingService } from '../services/listing.service';


const PROPERTY_TYPE_LABEL: Record<PropertyType, string> = {
  HOUSE: 'House',
  APARTMENT: 'Apartment',
  NEW_PROPERTY: 'New property',
  NEW_HOUSE: 'New house',
  INVESTMENT_BUILDING: 'Investment building',
  LAND: 'Land',
  GARAGE_PARKING: 'Garage / Parking',
  OFFICE: 'Office',
  COMMERCIAL_PROPERTY: 'Commercial Property'
};

@Component({
  selector: 'app-view-listing',
  standalone: true,
  imports: [
    CommonModule, NgOptimizedImage,
    MatCardModule, MatChipsModule, MatIconModule,
    MatButtonModule, MatDividerModule, MatTooltipModule
  ],
  templateUrl: './view-listing.component.html',
  styleUrls: ['./view-listing.component.css']
})
export class ViewListingComponent {
  private route = inject(ActivatedRoute);
  private api = inject(ListingService);

  listing$ = this.route.paramMap.pipe(
    map(pm => Number(pm.get('id'))),
    filter(id => Number.isFinite(id)),
    switchMap(id => this.api.getListing(id.toString()))
  );

  // gallery state
  selectedIndex = 0;

  setImage(i: number) { this.selectedIndex = i; }

  typeLabel(listing: Listing) {
    return PROPERTY_TYPE_LABEL[listing.propertyType];
  }

  // icons for amenities we know; others fall back to a tag chip
  amenityIcon(a: string): string | null {
    const m: Record<string, string> = {
      parking: 'local_parking',
      internet: 'wifi',
      balcony: 'balcony',
      elevator: 'elevator',
      gym: 'fitness_center',
      garden: 'yard',
      pool: 'pool',
      fireplace: 'fireplace',
      'well water': 'water',
      barn: 'warehouse',
      fenced: 'fence',
      'access road': 'route',
      'electricity nearby': 'bolt',
      'meeting room': 'meeting_room',
      'loading bay': 'local_shipping',
    };
    return m[a.toLowerCase()] ?? null;
  }
}
