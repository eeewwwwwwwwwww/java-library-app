package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BookFilterTest {

    private BookFilter bookFilter;
    private Book book1, book2, book3;

    @BeforeEach
    void setUp() {
        bookFilter = new BookFilter();
        Author author1 = new Author("Лев Толстой");
        Author author2 = new Author("Федор Достоевский");

        book1 = new Book("Война и мир", author1, 1869);
        book2 = new Book("Преступление и наказание", author2, 1866);
        book3 = new Book("Анна Каренина", author1, 1877);
    }

    @Test
    void testFilterByYearFrom() {
        List<Book> books = Arrays.asList(book1, book2, book3);
        // Ищем книги с 1870 года
        List<Book> result = bookFilter.filterByYearFrom(books, 1870);

        assertEquals(1, result.size());
        assertEquals("Анна Каренина", result.get(0).getTitle());
    }

    @Test
    void testFilterByAuthorName() {
        List<Book> books = Arrays.asList(book1, book2, book3);
        // Ищем книги Толстого
        List<Book> result = bookFilter.filterByAuthorName(books, "Лев Толстой");

        assertEquals(2, result.size());
    }

    @Test
    void testFilterByYearFrom_EmptyList() {
        List<Book> result = bookFilter.filterByYearFrom(Arrays.asList(), 1800);
        assertTrue(result.isEmpty());
    }
}