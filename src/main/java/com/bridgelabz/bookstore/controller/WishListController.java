package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.dto.WishDTO;
import com.bridgelabz.bookstore.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bookStore/wishList")
public class WishListController {

    @Autowired
    WishListService wishListService;

    @PostMapping(value = "/addWishListDetails")
    public ResponseEntity<ResponseDTO> addWishListDetails(@RequestBody WishDTO wishDTO) {
        WishDTO addData = wishListService.addWish(wishDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added new WishList Details", addData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @GetMapping(value = "/getWishListDetails")
    public ResponseEntity<ResponseDTO> getWishListDetails() {
        List<WishDTO> wishListData = wishListService.getWish();
        ResponseDTO responseDTO = new ResponseDTO("Fetched All WishList Details", wishListData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @DeleteMapping(value = "/deleteWishListDetails")
    public ResponseEntity<ResponseDTO> deleteWishListDetails(@RequestParam(name = "id") int id) {
        wishListService.deleteWish(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted by ID : Cart Details", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }
}
