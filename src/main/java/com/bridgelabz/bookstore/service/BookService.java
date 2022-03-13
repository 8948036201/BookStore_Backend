package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.exception.BookStoreException;
import com.bridgelabz.bookstore.repository.BookRepository;
import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {

    @Autowired
    BookRepository bookStoreRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        Book addDetails = modelMapper.map(bookDTO, Book.class);
        bookStoreRepository.save(addDetails);
        return bookDTO;
    }

    @Override
    public List<BookDTO> getBook() {
        return bookStoreRepository.findAll().stream().map(book -> {
            return new BookDTO(book.getBookId(), book.getBookDetails(), book.getAuthorName(), book.getBookName(),
                    book.getPrice(), book.getNoOfBooks() ,book.getImage() );
        }).collect(Collectors.toList());
    }

    @Override
    public BookDTO updateBook(int id, BookDTO bookDTO) {
        BookDTO bookResponse = null;
        if (id > 0) {
            Book bookDetails = findBookById(id);
            String[] ignoreFields = {"id"};
            BeanUtils.copyProperties(bookDTO, bookDetails, ignoreFields);
            bookStoreRepository.save(bookDetails);
            bookResponse = modelMapper.map(bookDetails, BookDTO.class);
        }
        return bookResponse;
    }

    public Book findBookById(int id) {
        return bookStoreRepository.findById(id)
                .orElseThrow(() -> new BookStoreException("Unable to find any Book detail!"));
    }


    @Override
    public void deleteBook(int id) {
        if (id > 0) {
            Book contact = findBookById(id);
            bookStoreRepository.delete(contact);
        }
    }

    @Override
    public BookDTO getBookByID(int id) {
        Book book = findBookById(id);
        BookDTO contactResponse = modelMapper.map(book, BookDTO.class);
        return contactResponse;
    }
}
