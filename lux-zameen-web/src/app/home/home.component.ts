import { Component, inject } from '@angular/core';
import { ListingCardComponent } from '../shared/listing-card/listing-card.component';
import { SearchPropertyFilterComponent } from '../search-property-filter/search-property-filter.component';
import { Observable, shareReplay } from 'rxjs';
import { ListingCard } from '../models/listingCard';
import { Page } from '../models/page';
import { ListingService } from '../services/listing.service';
import { AsyncPipe, CommonModule } from '@angular/common';
import { ListingFilter } from '../models/listingFilter';
import { ListingsDisplayComponent } from '../listings-display/listings-display.component';

@Component({
  selector: 'app-home',
  imports: [SearchPropertyFilterComponent, AsyncPipe, CommonModule, ListingsDisplayComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  private listingService = inject(ListingService);

  listingsToDisplay$: Observable<Page<ListingCard>> = this.listingService.getLatest(0, 4).pipe(shareReplay(1));
  propertiesCount$: Observable<number> = this.listingService.getPropertiesCount().pipe(shareReplay(1));
  listingSearchResult!: Observable<Page<ListingCard>>;



  onSearch(listingFilter: ListingFilter) {
    this.listingSearchResult = this.listingService.searchListings(listingFilter, 0, 8).pipe(shareReplay(1));
    this.listingsToDisplay$ = this.listingSearchResult;
  }

}
