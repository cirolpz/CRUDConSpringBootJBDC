package org.example.controllers;

import org.example.repositories.JsonLoader;
import org.example.services.BookService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.example.model.Book;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;

@RestController
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @Component
    public class ScheduledJsonLoader{
        private final JsonLoader jsonLoader = new JsonLoader();
            @Scheduled(cron = "0 0 8,10,12 * * ?") // Ejecuta a las 8:00, 10:00 y 12:00 cada día
            public void attemptLoadJson() {
                jsonLoader.loadJson(); // Llama al método que carga el JSON
            }
}

    @GetMapping("/book")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public long createBook(@RequestBody Book newBook){
        return bookService.createBook(newBook);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Long id){
         bookService.deleteBook(id);
    }
    @PutMapping("/book/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {bookService.updateBook(id,updatedBook);}
}
