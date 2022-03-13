package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.entity.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<Wish, Integer> {

}
