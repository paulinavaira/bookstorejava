package com.jedify.bookstore.classes;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Nationality nationality;

    public Author(String firstName, String lastName, Nationality nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
    }

    public Author() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public String fullName() {
        return this.getFirstName() + "" + this.getLastName();
    }

    public static Map<String,Object> authorDTO(Author author) {
        Map<String, Object> dto = new HashMap<>();
        dto.put("id", author.getId());
        dto.put("firstName", author.getFirstName());
        dto.put("lastName", author.getLastName());
        dto.put("nationality", author.getNationality());
        return dto;
    }
}
