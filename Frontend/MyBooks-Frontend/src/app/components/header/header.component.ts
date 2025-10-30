import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {MatToolbarModule} from '@angular/material/toolbar';
import { DataService } from '../../services/data.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  imports: [MatToolbarModule]
})

export class HeaderComponent {
  constructor(private router: Router,
    private dataService: DataService) {}

  title = 'Book List'

  backToLandingPage(){
    this.dataService.setDefaultData();
    this.router.navigate(['']);
  }
}
