import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ViewListingComponent } from './view-listing/view-listing.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'listing/:id', component: ViewListingComponent }
];
