package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.WishDTO;

import java.util.List;

public interface IWishListService {
    WishDTO addWish(WishDTO bookDTO);

    List<WishDTO> getWish();

    void deleteWish(int id);
}
