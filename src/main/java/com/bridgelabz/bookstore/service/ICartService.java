package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDTO;

import java.util.List;

public interface ICartService {
    BookDTO addCart(BookDTO bookDTO);

    List<BookDTO> getCart();

    void deleteCart(int id);

}
