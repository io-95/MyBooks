import { Component } from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import { CommonModule } from '@angular/common';

export interface BookList {
  id: string;
  title: string;
  author: string;
  publishingYear: number;
  isbn: string;
}

const BOOK_DATA: BookList[] = [
  {"id":"550e8400-e29b-41d4-a716-446655440000","title":"1984","author":"George Orwell","publishingYear":1999,"isbn":"978-0451524935"},
  {"id":"550e8400-e29b-41d4-a716-446655440001","title":"Harry Potter and the Goblet of Fire","author":"J.K. Rowling","publishingYear":2005,"isbn":"978-0439136365"},
  {"id":"550e8400-e29b-41d4-a716-446655440002","title":"The Great Gatsby","author":"F. Scott Fitzgerald","publishingYear":1925,"isbn":"978-0743273565"},
  {"id":"550e8400-e29b-41d4-a716-446655440003","title":"War and Peace","author":"Leo Tolstoy","publishingYear":1869,"isbn":"978-0199232765"},
  {"id":"550e8400-e29b-41d4-a716-446655440004","title":"The Hunger Games","author":"Suzanne Collins","publishingYear":2010,"isbn":"978-0439023528"}
  ];

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
  imports: [MatTableModule, CommonModule]
})

export class BookListComponent {
  displayedColumns: string[] = ['id', 'title', 'author', 'publishingYear', 'isbn'];
  dataSource = BOOK_DATA;
}
