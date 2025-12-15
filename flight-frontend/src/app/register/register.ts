import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth';

@Component({
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.html',
  styleUrls: ['../shared.css']
})
export class RegisterComponent {

  user = { username: '', email: '', password: '' };

  constructor(private auth: AuthService, private router: Router) {}

  register() {
    this.auth.register(this.user).subscribe(() => {
      alert('Registration successful');
      this.router.navigate(['/login']);
    });
  }
}

