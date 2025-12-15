import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class TokenService {

  private KEY = 'THIS_IS_A_VERY_LONG_SECRET_KEY_1234567890';

  set(token: string) {
    localStorage.setItem(this.KEY, token);
  }

  get(): string | null {
    return localStorage.getItem(this.KEY);
  }

  clear() {
    localStorage.removeItem(this.KEY);
  }

  isLoggedIn(): boolean {
    return !!this.get();
  }
}

