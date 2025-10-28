import { Component } from '@angular/core';
import {MatTableModule} from '@angular/material/table';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
  imports: []
})

export class BookListComponent {
  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
}
