package library;
/*
 * ПОСТАНОВКА ЗАДАЧИ:
 * Разработать консольное приложение на Java для управления простой библиотекой.
 * Требования к решению:
 * 1. Создать классы для описания Автора, Книги и Библиотеки.
 * 2. Реализовать возможность добавления книг в библиотеку.
 * 3. Реализовать вывод списка всех книг в библиотеке.
 * 4. Реализовать поиск книги по её названию.
 * 5. Приложение должно быть реализовано с использованием ровно 4-х классов.
 *
 * УЛУЧШЕНИЯ (feature/2):
 * 6. Добавлен метод подсчета количества книг в библиотеке.
 * 7. Добавлен метод удаления книги по названию.
 */

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        Author author1 = new Author("Лев Толстой");
        Author author2 = new Author("Федор Достоевский");

        Book book1 = new Book("Война и мир", author1, 1869);
        Book book2 = new Book("Преступление и наказание", author2, 1866);
        Book book3 = new Book("Анна Каренина", author1, 1877);

        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);

        System.out.println("Все книги в библиотеке:");
        myLibrary.displayAllBooks();

        // Используем новую функцию: подсчет книг
        System.out.println("\nВсего книг в библиотеке: " + myLibrary.getBooksCount());

        // Используем новую функцию: удаление книги
        System.out.println("\nУдаляем книгу 'Анна Каренина'...");
        boolean removed = myLibrary.removeBookByTitle("Анна Каренина");
        if (removed) {
            System.out.println("Книга успешно удалена!");
        }

        System.out.println("\nКниг после удаления: " + myLibrary.getBooksCount());
        myLibrary.displayAllBooks();
    }
}