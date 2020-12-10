package com.jedify.bookstore.repositories;

import com.jedify.bookstore.classes.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book,Long>{
}
