package net.sagati.bootstrap;

import net.sagati.model.Author;
import net.sagati.model.Book;
import net.sagati.repo.AuthorRepository;
import net.sagati.repo.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author manju = new Author("Manjunatha", "Muniyappa");
        Author vaishnav = new Author("Vaishnav", "Manjunatha");
        Author praveena = new Author("Praveena", "Manjunatha");
        List<Author> authors = new ArrayList<>(Arrays.asList(manju, vaishnav, praveena));

        Book manjuBook = new Book("Learn Spring", "1234");
        Book vaishnavBook = new Book("Learn Math", "5678");
        Book praveenaBook = new Book("Learn BI", "89012");
        List<Book> books = new ArrayList<>(Arrays.asList(manjuBook, praveenaBook, vaishnavBook));

        manju.getBooks().add(manjuBook);
        vaishnav.getBooks().add(vaishnavBook);
        praveena.getBooks().add(praveenaBook);

        manjuBook.getAuthors().add(manju);
        vaishnavBook.getAuthors().add(vaishnav);
        praveenaBook.getAuthors().add(praveena);

        this.authorRepository.saveAll(authors);
        this.bookRepository.saveAll(books);

        System.out.println("Number of books " + bookRepository.count());
    }
}
