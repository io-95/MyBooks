import { Component } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
  imports: [MatCardModule, MatFormFieldModule, MatButtonModule, MatInputModule],
})

export class FormComponent {
  constructor(private router: Router) {}

  switchToLandingPage(){
    this.router.navigate(['']);
  }
}
