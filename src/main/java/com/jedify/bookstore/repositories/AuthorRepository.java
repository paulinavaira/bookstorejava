package com.jedify.bookstore.repositories;

import com.jedify.bookstore.classes.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AuthorRepository extends JpaRepository<Author,Long> {
}