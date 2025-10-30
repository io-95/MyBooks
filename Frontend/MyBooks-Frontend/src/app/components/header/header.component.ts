import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {MatToolbarModule} from '@angular/material/toolbar';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  imports: [MatToolbarModule]
})

export class HeaderComponent {
  constructor(private router: Router) {}

  title = 'Book List'

  backToLandingPage(){
    this.router.navigate(['']);
  }
}
