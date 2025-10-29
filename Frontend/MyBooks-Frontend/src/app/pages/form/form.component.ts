import { Component } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { Router } from '@angular/router';
import { Book } from '../../models/book.model';
import { BookService } from '../../services/book.service';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
  imports: [MatCardModule, MatFormFieldModule, MatButtonModule, MatInputModule],
})

export class FormComponent {
  constructor(private router: Router, private bookService: BookService) {}

  private book: Book = {
    "title" = '',
    "author" = '',
    "publishingYear" = '',
    "isbn" = ''
  };

  title = '';
  author = '';
  publishingYear = '';
  isbn = '';

  saveBook(){
    this.book.title = this.title;
    this.book.author = this.author;
    this.book.publishingYear = Number(this.publishingYear);
    this.book.isbn = this.isbn;

    this.bookService.addBook(this.book);
    this.router.navigate(['']);
  }

  switchToLandingPage(){
    this.router.navigate(['']);
  }
}
