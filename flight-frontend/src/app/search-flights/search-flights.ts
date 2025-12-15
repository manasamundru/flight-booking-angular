import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { FlightService } from '../services/flight';
import { TokenService } from '../services/token';
import { CommonModule } from '@angular/common';
@Component({
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './search-flights.html',
  styleUrls: ['../shared.css']
})
export class SearchFlightsComponent {

  from = '';
  to = '';
  date = '';
  flights: any[] = [];

  constructor(
    private flightService: FlightService,
    private token: TokenService,
    private router: Router
  ) {}

  search() {
    this.flightService
      .search(this.from, this.to, this.date)
      .subscribe((data: any) => this.flights = data);
  }

  logout() {
    this.token.clear();
    this.router.navigate(['/login']);
  }
}

