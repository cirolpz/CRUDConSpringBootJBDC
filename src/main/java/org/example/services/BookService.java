package org.example.services;

import org.example.repositories.BookRepository;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.example.model.Book;
import java.util.List;
import org.slf4j.Logger;

@Service
public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private final BookRepository repository;
    public BookService(BookRepository repository){
        this.repository = repository;
    }
    public List<Book> getAllBooks(){
        return repository.getAllBooks();
    }
    public long createBook(Book newBook) {
        if (newBook.getName() == null || newBook.getName().isEmpty()) {
            throw new IllegalArgumentException("El nombre del libro no puede ser nulo o vacío.");
        }
        try {
            return repository.createBook(newBook);
        } catch (DataAccessException e) {
            logger.error("Error al crear el libro: " + e.getMessage(), e);
            throw e; // O manejar de otra forma según tu lógica
        }
    }
    public void deleteBook(Long id){
        try {
            repository.deleteBook(id);
        } catch (DataAccessException e) {
            logger.error("Error al eliminar el libro con ID " + id + ": " + e.getMessage(), e);
            throw e; // O manejar de otra forma
        }
    }
    public void updateBook(Long id, Book updatedBook) {
        if (updatedBook.getName() == null || updatedBook.getName().isEmpty()) {
            throw new IllegalArgumentException("El nombre del libro no puede ser nulo o vacío.");
        }
        try {
            repository.updateBook(id, updatedBook);
        } catch (DataAccessException e) {
            logger.error("Error al actualizar el libro con ID " + id + ": " + e.getMessage(), e);
            throw e; // O manejar de otra forma
        }
    }
}