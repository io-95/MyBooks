import { ChangeDetectionStrategy, Component } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {BookListComponent} from '../../components/book-list/book-list.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  imports: [
    MatIconModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    BookListComponent
  ],
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class HomeComponent {
  constructor(private router: Router) {}

  switchToFormPage(){
    this.router.navigate(['/ziel']);
  }
}
