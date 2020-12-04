package com.jedify.bookstore;

import javax.persistence.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Entity
public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ElementCollection
    @CollectionTable(name = "purchasedBooks")
    private List<Book> purchasedBooks;
    @ManyToOne
    @JoinColumn(name = "storebook_id")
    private StoreBook storeBook;

    public Customer(String email, String password) {
        super(email, password);
        this.purchasedBooks = new LinkedList<>();
    }

    public Customer(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Book> getPurchasedBooks() {
        return purchasedBooks;
    }

    public void addPurchasedBooks(Book book) {
        this.purchasedBooks.add(book);
    }

    public StoreBook getStoreBook() {
        return storeBook;
    }

    public void setStoreBook(StoreBook storeBook) {
        this.storeBook = storeBook;
    }

    public static Map<String,Object> customerDTO(Customer customer){
        Map<String,Object> dto = new HashMap<>();
        dto.put("id", customer.getId());
        dto.put("email", customer.getEmail());
        dto.put("password", customer.getPassword());
        dto.put("purchased_books", customer.getPurchasedBooks());
        dto.put("storebook_id", customer.getStoreBook());
        return dto;
    }
}
