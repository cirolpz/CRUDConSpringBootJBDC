package org.example.repositories;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.model.Book;

@Repository
public class BookRepository {
private final NamedParameterJdbcTemplate jdbcTemplate;//Un objeto para ejecutar consulta SQL, se conecta con db
private final BookMapper mapper = new BookMapper();//Clase interna que implementa RowMapper<Book> usada para
// mapear resultados de una consulta SQL  a objetos Book

public BookRepository(NamedParameterJdbcTemplate jdbcTemplate){
    this.jdbcTemplate= jdbcTemplate;
}
//El constructor del repositorio acepta un objeto NamedParameterJdbcTemplate y lo asigna al campo jdbcTemplate.
// Esto permite la inyección de dependencias por parte de Spring.
    public List<Book> getAllBooks(){
        String sql = "SELECT * FROM books";
        try {
            return jdbcTemplate.query(sql, mapper); // Usa el RowMapper para mapear resultados a objetos Book
        } catch (DataAccessException e) {
            System.err.println("Error al obtener libros: " + e.getMessage());
            return Collections.emptyList(); // Devuelve una lista vacía en caso de error
        }
    }

    public long createBook(Book newBook) {
        String sql = "INSERT INTO books (name) VALUES (:name)";
        Map<String, Object> params = new HashMap<>();
        params.put("name", newBook.getName());
        try {
            return jdbcTemplate.update(sql, params); // Devuelve el número de filas afectadas
        } catch (DataAccessException e) {
            System.err.println("Error al crear libro: " + e.getMessage());
            return -1; // Devuelve un valor negativo para indicar error
        }
    }

    public void deleteBook(Long id){
        String sql= "DELETE FROM books WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        try {
            int rowsAffected = jdbcTemplate.update(sql, params); // Devuelve el número de filas afectadas
            if (rowsAffected == 0) {
                throw new DataAccessException("No se encontró el libro con el ID proporcionado") {};
            }
        } catch (DataAccessException e) {
            System.err.println("Error al eliminar libro: " + e.getMessage());
        }
    }

    public void updateBook(Long id, Book updatedBook) {
        String sql= "UPDATE books SET name = :name WHERE id= :id";
        Map<String,Object>params = new HashMap<>();
        params.put("id",id);
        params.put("name", updatedBook.getName());
        try {
            int rowsAffected = jdbcTemplate.update(sql, params);
            if (rowsAffected == 0) {
                throw new DataAccessException("No se encontró el libro con el ID proporcionado") {};
            }
        } catch (DataIntegrityViolationException e) {
            System.out.println("Violación de integridad de datos: " + e.getMessage());
        } catch (DataAccessException e) {
            System.out.println("Error de acceso a datos: " + e.getMessage());
        }
    }

    private static class BookMapper implements RowMapper<Book> {
    @Override//Mapea las filas del ResultSet a objetos "Book"
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {//Extrae valores del ResultSet como id, name y
        // crea un nuevo objeto con estos valores
        long id= rs.getLong("id");
        String name = rs.getString("name");
        Book book = new Book(id,name);
        return book;
    }
}
}
