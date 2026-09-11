package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Book book1, book2, book3;

    @BeforeEach
    void setUp() {
        library = new Library();
        Author author1 = new Author("Лев Толстой");
        Author author2 = new Author("Федор Достоевский");

        book1 = new Book("Война и мир", author1, 1869);
        book2 = new Book("Преступление и наказание", author2, 1866);
        book3 = new Book("Анна Каренина", author1, 1877);
    }

    @Test
    void testAddBook() {
        library.addBook(book1);
        assertEquals(1, library.getBooksCount());
    }

    @Test
    void testGetBooksCount_Empty() {
        assertEquals(0, library.getBooksCount());
    }

    @Test
    void testGetBooksCount_MultipleBooks() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        assertEquals(3, library.getBooksCount());
    }

    @Test
    void testFindBookByTitle_Found() {
        library.addBook(book1);
        library.addBook(book2);
        
        Book found = library.findBookByTitle("Война и мир");
        assertNotNull(found);
        assertEquals("Война и мир", found.getTitle());
    }

    @Test
    void testFindBookByTitle_NotFound() {
        library.addBook(book1);
        
        Book found = library.findBookByTitle("Несуществующая книга");
        assertNull(found);
    }

    @Test
    void testFindBookByTitle_CaseInsensitive() {
        library.addBook(book1);
        
        Book found = library.findBookByTitle("война и мир");
        assertNotNull(found);
    }

    @Test
    void testRemoveBookByTitle_Success() {
        library.addBook(book1);
        library.addBook(book2);
        
        boolean removed = library.removeBookByTitle("Война и мир");
        assertTrue(removed);
        assertEquals(1, library.getBooksCount());
    }

    @Test
    void testRemoveBookByTitle_NotFound() {
        library.addBook(book1);
        
        boolean removed = library.removeBookByTitle("Несуществующая книга");
        assertFalse(removed);
        assertEquals(1, library.getBooksCount());
    }

    @Test
    void testGetAllBooks() {
        library.addBook(book1);
        library.addBook(book2);
        
        List<Book> books = library.getAllBooks();
        assertEquals(2, books.size());
    }

    @Test
    void testGetAllBooks_Empty() {
        List<Book> books = library.getAllBooks();
        assertTrue(books.isEmpty());
    }

    @Test
    void testDisplayAllBooks() {
        library.addBook(book1);
        // Этот метод просто выводит в консоль, проверяем, что не падает
        assertDoesNotThrow(() -> library.displayAllBooks());
    }

    @Test
    void testDisplayAllBooks_Empty() {
        // Проверяем, что метод работает с пустой библиотекой
        assertDoesNotThrow(() -> library.displayAllBooks());
    }
}