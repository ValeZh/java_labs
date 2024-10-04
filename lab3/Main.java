// Базовый класс ПечатноеИздание
class PrintMedia {
    private String title;

    public PrintMedia(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// Класс для Книг, наследует от ПечатноеИздание
class Book extends PrintMedia {
    public Book(String title) {
        super(title);
    }
}

// Класс для Журналов, наследует от ПечатноеИздание
class Magazine extends PrintMedia {
    public Magazine(String title) {
        super(title);
    }
}

// Класс КнижковийМагазин
class Bookstore {
    private PrintMedia[] items;
    private int countBooks = 0;
    private int countMagazines = 0;

    public Bookstore(PrintMedia[] items) {
        this.items = items;
    }

    // Метод подсчета количества книг и журналов
    public void countItems() {
        for (PrintMedia item : items) {
            if (item instanceof Book) {
                countBooks++;
            } else if (item instanceof Magazine) {
                countMagazines++;
            }
        }
    }

    public void printCounts() {
        System.out.println("Книги: " + countBooks);
        System.out.println("Журналы: " + countMagazines);
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание массива с книгами и журналами
        PrintMedia[] items = {
                new Book("Java Programming"),
                new Magazine("Tech Weekly"),
                new Book("Data Structures"),
                new Magazine("Science Daily")
        };

        // Создание объекта КнижковийМагазин и подсчет
        Bookstore bookstore = new Bookstore(items);
        bookstore.countItems();
        bookstore.printCounts();
    }
}
