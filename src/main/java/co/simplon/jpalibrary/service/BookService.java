package co.simplon.jpalibrary.service;

import co.simplon.jpalibrary.model.Book;
import co.simplon.jpalibrary.repository.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Data
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(final Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }


    public void deleteBook(final Long id) {
        bookRepository.deleteById(id);
    }


}
