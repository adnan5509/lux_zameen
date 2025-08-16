import { ChangeDetectionStrategy, Component, Input } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { ListingCard } from '../../models/listingCard';
import { CommonModule, CurrencyPipe, DatePipe } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-listing-card',
  imports: [MatCardModule, MatButtonModule, MatIconModule, DatePipe, CurrencyPipe, CommonModule],
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './listing-card.component.html',
  styleUrl: './listing-card.component.css'
})
export class ListingCardComponent {

  @Input({ required: true }) listing!: ListingCard

}
