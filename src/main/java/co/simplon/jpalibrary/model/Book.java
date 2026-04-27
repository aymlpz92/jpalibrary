package co.simplon.jpalibrary.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titre", length=100, nullable=false)
    private String title;

    @Column(nullable=true)
    private String description;

    @Column(name="disponibilite", columnDefinition="boolean default true")
    private Boolean available = true;

    @ManyToOne
    private Category categories;

    @ManyToMany
    private Set<Author> authors = new HashSet<>();

}
