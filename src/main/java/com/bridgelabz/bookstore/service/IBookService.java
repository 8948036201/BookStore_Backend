package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDTO;
import java.util.List;

public interface IBookService {

    BookDTO addBook(BookDTO bookDTO);
    List<BookDTO> getBook();
    BookDTO updateBook(int id, BookDTO bookDTO);
    void deleteBook(int id);
    BookDTO getBookByID(int id);

}
