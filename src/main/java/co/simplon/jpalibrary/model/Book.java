package co.simplon.jpalibrary.model;


import jakarta.persistence.*;
import lombok.Data;

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

}
