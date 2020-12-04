package com.jedify.bookstore;

import javax.persistence.*;

@Entity
public class Admin extends User{

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public Admin(String email, String password, Store store) {
        super(email, password);
        this.store = store;
    }

    public Admin() {}

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}

