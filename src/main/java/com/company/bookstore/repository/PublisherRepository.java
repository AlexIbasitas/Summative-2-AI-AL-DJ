package com.company.bookstore.repository;

import com.company.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Book,Integer> {
}
