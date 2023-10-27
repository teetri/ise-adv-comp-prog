import java.util.ArrayList;
import java.util.List;

// Book class
class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;

    public Book(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    // Getter and setter methods for book properties
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }
}

// BookRecord class
class BookRecord {
    private Book book;
    private int quantityInStock;

    public BookRecord(Book book, int quantityInStock) {
        this.book = book;
        this.quantityInStock = quantityInStock;
    }

    // Getter and setter methods for book record properties
    public Book getBook() {
        return book;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}

// Inventory class
class Inventory {
    private List<BookRecord> bookRecords = new ArrayList<>();

    public void addBookRecord(BookRecord bookRecord) {
        bookRecords.add(bookRecord);
    }

    public void removeBook(String isbn) {
        for (int i = 0; i < this.bookRecords.size(); i++) {
            if (bookRecords.get(i).getBook().getIsbn().equals(isbn)) {
                this.bookRecords.remove(i);
            }
        }
    }

    public BookRecord findBook(String isbn) {
        // Implement book search logic based on ISBN
        for (int i = 0; i < this.bookRecords.size(); i++) {
            if (bookRecords.get(i).getBook().getIsbn().equals(isbn)) {
                return this.bookRecords.get(i);
            }
        }
        return null;
    }

    public List<BookRecord> listAllBooks() {
        return bookRecords;
    }
}

// SearchManager class
class SearchManager {
    public List<BookRecord> searchByBookInfo(BookInfo bookInfo, Inventory inventory) {
        List<BookRecord> matchingBooks = new ArrayList<>();

        // Iterate through the book records in the inventory
        for (BookRecord bookRecord : inventory.listAllBooks()) {
            Book book = bookRecord.getBook();

            // Check if the title substring matches (case-insensitive)
            if (bookInfo.getTitleSubstring() != null &&
                    book.getTitle().toLowerCase().contains(bookInfo.getTitleSubstring().toLowerCase())) {
                matchingBooks.add(bookRecord);
            }

            // Check if the author substring matches (case-insensitive)
            if (bookInfo.getAuthorSubstring() != null &&
                    book.getAuthor().toLowerCase().contains(bookInfo.getAuthorSubstring().toLowerCase())) {
                matchingBooks.add(bookRecord);
            }

            // Check if the ISBN matches (case-insensitive)
            if (bookInfo.getIsbn() != null &&
                    book.getIsbn().equalsIgnoreCase(bookInfo.getIsbn())) {
                matchingBooks.add(bookRecord);
            }
        }

        return matchingBooks;
    }
}

// BookInfo class
class BookInfo {
    private String titleSubstring;
    private String authorSubstring;
    private String isbn;

    public BookInfo(String titleSubstring, String authorSubstring, String isbn) {
        this.titleSubstring = titleSubstring;
        this.authorSubstring = authorSubstring;
        this.isbn = isbn;
    }

    // Getter methods for book info properties
    public String getTitleSubstring() {
        return titleSubstring;
    }

    public String getAuthorSubstring() {
        return authorSubstring;
    }

    public String getIsbn() {
        return isbn;
    }
}

public class BookstoreApp {
    public static void main(String[] args) {
        // Create sample books
        Book book1 = new Book("Java Programming", "John Doe", "1234567890", 29.99);
        Book book2 = new Book("Python Basics", "Jane Smith", "9876543210", 19.99);
        Book book3 = new Book("Data Science Essentials", "David Johnson", "5678901234", 39.99);

        // Create book records and add them to the inventory
        Inventory inventory = new Inventory();
        inventory.addBookRecord(new BookRecord(book1, 10));
        inventory.addBookRecord(new BookRecord(book2, 15));
        inventory.addBookRecord(new BookRecord(book3, 5));

        // inventory.removeBook("1234567890");
        // System.out.println(inventory.findBook("1234567890").getBook().getTitle());

        // Create a SearchManager
        SearchManager searchManager = new SearchManager();

        // Define search criteria using BookInfo
        BookInfo searchCriteria = new BookInfo("Java", "Jane", null);

        // Search for books based on the criteria
        List<BookRecord> matchingBooks = searchManager.searchByBookInfo(searchCriteria, inventory);

        // Display the matching books
        if (matchingBooks.isEmpty()) {
            System.out.println("No matching books found.");
        } else {
            System.out.println("Matching Books:");
            for (BookRecord bookRecord : matchingBooks) {
                Book matchingBook = bookRecord.getBook();
                System.out.println("Title: " + matchingBook.getTitle());
                System.out.println("Author: " + matchingBook.getAuthor());
                System.out.println("ISBN: " + matchingBook.getIsbn());
                System.out.println("Price: $" + matchingBook.getPrice());
                System.out.println("Quantity in Stock: " + bookRecord.getQuantityInStock());
                System.out.println("--------------------");
            }
        }
    }
}