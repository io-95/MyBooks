import { Component, OnInit } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Book } from '../../models/book.model';
import { BookService } from '../../services/book.service';
import { DataService } from '../../services/data.service';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
  imports: [MatCardModule, MatFormFieldModule, MatButtonModule, MatInputModule, FormsModule],
})

export class FormComponent implements OnInit{
  constructor(private router: Router,
    private bookService: BookService,
    private dataService: DataService) {}

  title = '';

  book: Book = {
    "id": '',
    "title": '',
    "author": '',
    "publishingYear": 0,
    "isbn": ''
  };

  ngOnInit(){
    const bookData = this.dataService.getData();
    if(bookData) {
      this.title = 'Change Book';
      this.book = bookData;
      return;
    } else {
        this.title = 'Add new Book';
      }
  }

  saveBook(){
    if(this.book.id === ''){
     this.bookService.addBook(this.book).subscribe({
      next: (response) => {
        this.router.navigate(['']);
      },
        error: (error) => console.error('Error creating book:', error)
     });
    } else{
      this.bookService.changeBook(this.book).subscribe({
        next: (response)  => {
          this.router.navigate(['']);
        },
          error: (error) => console.error('Error creating book:', error)
      });
    }
    this.router.navigate(['']);
  }

  switchToLandingPage(){
    this.dataService.setDefaultData();
    this.router.navigate(['']);
  }
}
