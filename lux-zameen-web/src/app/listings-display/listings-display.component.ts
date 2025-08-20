import { Component, Input } from '@angular/core';
import { ListingCard } from '../models/listingCard';
import { Page } from '../models/page';
import { CommonModule } from '@angular/common';
import { ListingCardComponent } from '../shared/listing-card/listing-card.component';

@Component({
  selector: 'app-listings-display',
  imports: [CommonModule, ListingCardComponent],
  templateUrl: './listings-display.component.html',
  styleUrl: './listings-display.component.css'
})
export class ListingsDisplayComponent {

  @Input() listings: ListingCard[] = [];

}
