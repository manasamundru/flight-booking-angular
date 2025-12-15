import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class FlightService {

  private BASE = 'http://localhost:8080/api/flights';

  constructor(private http: HttpClient) {}

  search(source: string, destination: string, date: string) {
    return this.http.get(
      `${this.BASE}/search?from=${source}&to=${destination}&date=${date}`
    );
  }
}

