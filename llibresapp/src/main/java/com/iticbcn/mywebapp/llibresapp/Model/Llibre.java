package com.iticbcn.mywebapp.llibresapp.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "llibre", uniqueConstraints = {@UniqueConstraint(columnNames = "isbn")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Llibre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLlibre;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    private LocalDate publishedYear;

    private String editorial;

    private String genre;

    @Column(nullable = false, unique = true)
    private String isbn;

    private LocalDate    fecha; // Se mapea correctamente como tipo DATE en la BD

    public void setDataPublicacio(LocalDate localDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDataPublicacio'");
    }

    public Llibre(String title, String author, String editorial, LocalDate publishedYear, String genre, String isbn) {
        this.title = title;
        this.author = author;
        this.editorial = editorial;
        this.publishedYear = publishedYear;
        this.genre = genre;
        this.isbn = isbn;
    }
}


