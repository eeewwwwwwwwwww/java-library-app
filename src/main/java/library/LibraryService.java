package library;

import java.util.List;

/**
 * Сервисный класс, который использует Library и BookFilter.
 * Идеальный кандидат для тестирования с Mockito.
 */
public class LibraryService {

    private final Library library;
    private final BookFilter bookFilter;

    public LibraryService(Library library, BookFilter bookFilter) {
        this.library = library;
        this.bookFilter = bookFilter;
    }

    /**
     * Возвращает все книги из библиотеки.
     */
    public List<Book> getAllBooks() {
        return library.getAllBooks();
    }

    /**
     * Возвращает книги, изданные после указанного года.
     */
    public List<Book> getBooksPublishedAfter(int year) {
        List<Book> allBooks = library.getAllBooks();
        return bookFilter.filterByYearFrom(allBooks, year);
    }

    /**
     * Добавляет книгу и возвращает общее количество книг.
     */
    public int addBookAndCount(Book book) {
        library.addBook(book);
        return library.getBooksCount();
    }
}