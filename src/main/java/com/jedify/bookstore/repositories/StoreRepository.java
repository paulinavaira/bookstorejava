package com.jedify.bookstore.repositories;

import com.jedify.bookstore.classes.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StoreRepository extends JpaRepository<Store,Long> {
}
