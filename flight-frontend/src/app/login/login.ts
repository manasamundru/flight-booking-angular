import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth';
import { TokenService } from '../services/token';

@Component({
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrls: ['../shared.css']
})
export class LoginComponent {

  credentials = { username: '', password: '' };

  constructor(
    private auth: AuthService,
    private token: TokenService,
    private router: Router
  ) {}

  login() {
    this.auth.login(this.credentials).subscribe(token => {
      this.token.set(token);
      this.router.navigate(['/search']);
    });
  }
}

