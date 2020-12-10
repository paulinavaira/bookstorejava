package com.jedify.bookstore.classes;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "storebook_id")
    private StoreBook storeBook;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Purchase(Customer customer) {
        this.customer = customer;
    }

    public Purchase() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static Map<String,Object> purchaseDTO(Purchase purchase){
        Map<String,Object> dto = new HashMap<>();
        dto.put("purchased_books", purchase.getCustomer().getPurchasedBooks());
        return dto;
    }
}
