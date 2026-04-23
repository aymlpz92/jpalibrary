package co.simplon.jpalibrary.controller;

import co.simplon.jpalibrary.model.Book;
import co.simplon.jpalibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public Iterable<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") final Long id) {
        Optional<Book> book = bookService.getBook(id);
        return book.orElse(null);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") final Long id, @RequestBody Book book) {
        Optional<Book> b = bookService.getBook(id);
        if(b.isPresent()) {
            Book currentBook = b.get();

            currentBook.setTitle(book.getTitle());
            currentBook.setDescription(book.getDescription());
            currentBook.setAvailable(book.getAvailable());

            bookService.saveBook(currentBook);
            return currentBook;
        } else {
            return null;
        }
    }

    @PatchMapping

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") final Long id) {
        bookService.deleteBook(id);
    }

}
