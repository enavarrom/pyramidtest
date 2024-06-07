package com.example.test.contract.producer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Book {

    @Id
    @UuidGenerator
    private UUID id;

    private String title;

    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
