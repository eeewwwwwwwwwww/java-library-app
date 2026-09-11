/*
 * ПОСТАНОВКА ЗАДАЧИ:
 * Разработать консольное приложение на Java для управления простой библиотекой.
 * Требования к решению:
 * 1. Создать классы для описания Автора, Книги и Библиотеки.
 * 2. Реализовать возможность добавления книг в библиотеку.
 * 3. Реализовать вывод списка всех книг в библиотеке.
 * 4. Реализовать поиск книги по её названию.
 * 5. Приложение должно быть реализовано с использованием ровно 4-х классов.
 */

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        Author author1 = new Author("Лев Толстой");
        Author author2 = new Author("Федор Достоевский");

        Book book1 = new Book("Война и мир", author1, 1869);
        Book book2 = new Book("Преступление и наказание", author2, 1866);

        myLibrary.addBook(book1);
        myLibrary.addBook(book2);

        System.out.println("Все книги в библиотеке:");
        myLibrary.displayAllBooks();

        System.out.println("\nПоиск книги 'Война и мир':");
        Book found = myLibrary.findBookByTitle("Война и мир");
        if (found != null) {
            System.out.println("Найдена: " + found.toString());
        } else {
            System.out.println("Книга не найдена.");
        }
    }
}