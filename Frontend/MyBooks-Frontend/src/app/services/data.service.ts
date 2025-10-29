import { Injectable } from '@angular/core';
import { Book } from '../models/book.model';

@Injectable({ providedIn: 'root' })
export class DataService {
  private data?: Book;

  setData(book: Book): void {
    this.data = book;
  }

  getData(): Book | undefined {
    return this.data;
  }
}
