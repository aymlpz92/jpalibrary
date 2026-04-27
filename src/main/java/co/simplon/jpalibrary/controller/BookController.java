package co.simplon.jpalibrary.controller;

import co.simplon.jpalibrary.model.Book;
import co.simplon.jpalibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public Iterable<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.orElse(null);
    }

    @GetMapping("/title/{title}")
    public Optional<Book> getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }


    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> b = bookService.getBookById(id);
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

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") final Long id) {
        bookService.deleteBook(id);
    }

}
