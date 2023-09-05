package com.gaurav.SpringFluxBookStore.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Document(collection = "author")
public class Author {
    @Id
    @NotNull(message = "You must specify authorId")
    @NotBlank
    private int aid;

    @NotNull(message = "You must specify author name")
    @NotBlank
    private String name;

    @NotNull(message = "You must specify Address")
    @NotBlank
    private Address address;

    public Author(int aid, String name, Address address) {
        this.aid = aid;
        this.name = name;
        this.address = address;
    }
    public Author() {}

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
