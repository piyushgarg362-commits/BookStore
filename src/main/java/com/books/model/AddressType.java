package com.books.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "address_type")
@Data
public class AddressType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type") private String type;
}