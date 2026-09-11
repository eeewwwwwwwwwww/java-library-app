package library;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста.");
        } else {
            for (Book book : books) {
                System.out.println(book.toString());
            }
        }
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // === НОВЫЕ МЕТОДЫ (улучшение из feature/2) ===

    // Метод для подсчета количества книг в библиотеке
    public int getBooksCount() {
        return books.size();
    }

    // Метод для удаления книги по названию
    public boolean removeBookByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }
    // Возвращает копию списка всех книг
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}