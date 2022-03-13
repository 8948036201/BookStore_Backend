package com.bridgelabz.bookstore.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Wish {

    @Id
    private int bookId;
    private String bookDetails;
    private String authorName;
    private String bookName;
    private int price;
    private int noOfBooks;
    private String image;
}
