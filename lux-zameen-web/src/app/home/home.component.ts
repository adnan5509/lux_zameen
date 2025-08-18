import { Component, inject } from '@angular/core';
import { ListingCardComponent } from '../shared/listing-card/listing-card.component';
import { SearchPropertyFilterComponent } from '../search-property-filter/search-property-filter.component';
import { Observable, shareReplay } from 'rxjs';
import { ListingCard } from '../models/listingCard';
import { Page } from '../models/page';
import { ListingService } from '../services/listing.service';
import { AsyncPipe, CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  imports: [ListingCardComponent, SearchPropertyFilterComponent, AsyncPipe, CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  private listingService = inject(ListingService);

  latestListings$: Observable<Page<ListingCard>> = this.listingService.getLatest(0, 4).pipe(shareReplay(1));

}
