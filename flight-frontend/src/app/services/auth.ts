import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class AuthService {

  private BASE = 'http://localhost:8080/api/auth';

  constructor(private http: HttpClient) {}

  register(data: any) {
    return this.http.post(`${this.BASE}/register`, data);
  }

  login(data: any) {
    return this.http.post(`${this.BASE}/login`, data, {
      responseType: 'text'
    });
  }
}

