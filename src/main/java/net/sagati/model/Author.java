package net.sagati.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity

public class Author {
    public Author() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return Id == author.Id;
    }

    @Override
    public int hashCode() {
        return (int) (Id ^ (Id >>> 32));
    }

    @Override
    public String toString() {
        return "Author{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }
}
