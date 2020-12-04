package com.jedify.bookstore;

import javax.persistence.*;
import java.util.*;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String name;
    private String address;

    @OneToMany(
            mappedBy = "store",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL}
    )
    private Set<Store> store;

    @OneToMany(mappedBy = "store", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<StoreBook> storeBookSet;

    public Store() {}

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
        this.store = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Store> getStoreSet() {
        return store;
    }

    public void setStoreSet(Set<Store> storeSet) {
        this.store = storeSet;
    }

    public static Map<String,Object> storeDTO(Store store){
        Map<String,Object> dto = new HashMap<>();
        dto.put("id", store.getId());
        dto.put("name", store.getName());
        dto.put("address", store.getAddress());
        return dto;
    }
}
