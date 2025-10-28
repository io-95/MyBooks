import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { BookService, Book } from '../../services/book.service';
import { MatIconModule } from '@angular/material/icon';
import { ChangeDetectorRef } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';


@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [CommonModule, MatTableModule, MatIconModule, MatButtonModule],
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  displayedColumns: string[] = ['id', 'title', 'author', 'publishingYear', 'isbn', 'actions'];
  dataSource: Book[] = [];
  loading = true;
  error: string | null = null;

  constructor(private bookService: BookService,
    private cdr: ChangeDetectorRef) {}

  ngOnInit() {
    this.bookService.getBooks().subscribe({
      next: (books) => {
        this.dataSource = books;
        this.loading = false;
        this.cdr.markForCheck();
      },
      error: (err) => {
        this.error = 'Fehler beim Laden der Bücher';
        console.error(err);
        this.loading = false;
      }
    });
  }

  editBook(book: Book) {
    console.log('Edit Book:', book);
    // hier könntest du z.B. ein Dialog öffnen oder Router navigieren
  }

  deleteBook(book: Book) {
    const old = [...this.dataSource];
      this.dataSource = this.dataSource.filter(b => b.id !== book.id);

      this.bookService.deleteBook(book.id).subscribe({
        next: () => { /* ok */ },
        error: (err) => {
          this.dataSource = old; // rollback
          console.error('Löschen fehlgeschlagen', err);
        }
    });
  }
}
