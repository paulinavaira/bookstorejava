package com.jedify.bookstore.repositories;

import com.jedify.bookstore.classes.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AdminRepository extends JpaRepository<Admin,Long> {
}