import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { BookService, Book } from '../../services/book.service';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [CommonModule, MatTableModule],
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  displayedColumns: string[] = ['id', 'title', 'author', 'publishingYear', 'isbn'];
  dataSource: Book[] = [];
  loading = true;
  error: string | null = null;

  constructor(private bookService: BookService) {}

  ngOnInit() {
    this.bookService.getBooks().subscribe({
      next: (books) => {
        this.dataSource = books;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Fehler beim Laden der Bücher';
        console.error(err);
        this.loading = false;
      }
    });
  }
}
