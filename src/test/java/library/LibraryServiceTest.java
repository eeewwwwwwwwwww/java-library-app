package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Эта аннотация включает поддержку Mockito в JUnit 5
@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {

    // Создаем "моки" (заглушки) зависимостей
    @Mock
    private Library mockLibrary;

    @Mock
    private BookFilter mockBookFilter;

    private LibraryService libraryService;

    @BeforeEach
    void setUp() {
        // Передаем моки в конструктор сервиса
        libraryService = new LibraryService(mockLibrary, mockBookFilter);
    }

    @Test
    void testGetAllBooks() {
        // 1. Подготовка (Arrange): настраиваем поведение мока
        Author author = new Author("Тест");
        Book book1 = new Book("Книга 1", author, 2000);
        Book book2 = new Book("Книга 2", author, 2010);
        
        // Когда вызывается getAllBooks(), вернуть наш список
        when(mockLibrary.getAllBooks()).thenReturn(Arrays.asList(book1, book2));

        // 2. Действие (Act): вызываем тестируемый метод
        List<Book> result = libraryService.getAllBooks();

        // 3. Проверка (Assert): проверяем результат
        assertEquals(2, result.size());
        
        // Проверяем, что метод мока был вызван ровно 1 раз
        verify(mockLibrary, times(1)).getAllBooks();
    }

    @Test
    void testGetBooksPublishedAfter() {
        // 1. Подготовка
        Author author = new Author("Тест");
        Book oldBook = new Book("Старая", author, 1900);
        Book newBook = new Book("Новая", author, 2020);
        
        when(mockLibrary.getAllBooks()).thenReturn(Arrays.asList(oldBook, newBook));
        // Настраиваем mockBookFilter: при вызове с любым списком и годом 2000, вернуть только newBook
        when(mockBookFilter.filterByYearFrom(anyList(), eq(2000)))
                .thenReturn(Arrays.asList(newBook));

        // 2. Действие
        List<Book> result = libraryService.getBooksPublishedAfter(2000);

        // 3. Проверка
        assertEquals(1, result.size());
        assertEquals("Новая", result.get(0).getTitle());
        
        // Проверяем, что сервис обратился к обоим мокам
        verify(mockLibrary).getAllBooks();
        verify(mockBookFilter).filterByYearFrom(anyList(), eq(2000));
    }

    @Test
    void testAddBookAndCount() {
        // 1. Подготовка
        Author author = new Author("Тест");
        Book newBook = new Book("Новая книга", author, 2023);
        
        // Эмулируем, что после добавления книги в библиотеке стало 5 книг
        when(mockLibrary.getBooksCount()).thenReturn(5);

        // 2. Действие
        int count = libraryService.addBookAndCount(newBook);

        // 3. Проверка
        assertEquals(5, count);
        // Проверяем, что метод addBook был вызван с правильной книгой
        verify(mockLibrary).addBook(newBook);
        verify(mockLibrary).getBooksCount();
    }
}