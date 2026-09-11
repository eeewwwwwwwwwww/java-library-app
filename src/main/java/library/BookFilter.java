package library;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для фильтрации книг по различным критериям.
 */
public class BookFilter {

    /**
     * Фильтрует книги, изданные после указанного года (включительно).
     */
    public List<Book> filterByYearFrom(List<Book> books, int yearFrom) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() >= yearFrom) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Фильтрует книги по имени автора.
     */
    public List<Book> filterByAuthorName(List<Book> books, String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                result.add(book);
            }
        }
        return result;
    }
}