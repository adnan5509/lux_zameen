import { Component, EventEmitter, inject, Input, Output } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { MatOptionModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { CommonModule } from '@angular/common';
import { ListingFilter, PROPERTY_TYPE_OPTIONS, PURPOSE_OPTIONS } from '../models/listingFilter';
import { MatIconModule } from "@angular/material/icon";

@Component({
  selector: 'app-search-property-filter',
  imports: [
    CommonModule, ReactiveFormsModule,
    MatFormFieldModule, MatInputModule, MatSelectModule, MatButtonModule, MatIconModule
  ],
  templateUrl: './search-property-filter.component.html',
  styleUrl: './search-property-filter.component.css'
})
export class SearchPropertyFilterComponent {


  @Input() propertiesCount = 0;
  @Input() backgroundImageUrl = 'assets/Home-background.jpg';

  @Output() search = new EventEmitter<ListingFilter>();


  propertyTypes = PROPERTY_TYPE_OPTIONS;

  purposeArray = PURPOSE_OPTIONS;

  private fb = inject(FormBuilder);


  // Initialize the form with default values
  form = this.fb.group({
    purpose: 'Rent',
    q: '',
    propertyType: null,
    minPrice: null,
    maxPrice: null,
    bedroomsMin: null,
    bedroomsMax: null,
    minArea: null,
    maxArea: null
  }
  )
  buyBudgets = [100000, 200000, 300000, 500000, 750000, 1000000];
  rentBudgets = [500, 1000, 1500, 2000, 2500, 3000, 4000];


  get budgets() {
    return this.form.value.purpose === 'Rent' ? this.rentBudgets : this.buyBudgets;
  }

  onSubmit() {
    // Handle form submission logic here
    console.log(this.form)
    const v = structuredClone(this.form.value) as ListingFilter;
    this.search.emit(v);
  }
}
