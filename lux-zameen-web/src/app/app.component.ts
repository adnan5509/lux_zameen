import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SearchPropertyFilterComponent } from './search-property-filter/search-property-filter.component';
import { ListingCardComponent } from './shared/listing-card/listing-card.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, SearchPropertyFilterComponent, ListingCardComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'lux-zameen-web';
}
