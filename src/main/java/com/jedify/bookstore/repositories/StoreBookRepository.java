package com.jedify.bookstore.repositories;

import com.jedify.bookstore.classes.StoreBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StoreBookRepository extends JpaRepository<StoreBook,Long>{
}
