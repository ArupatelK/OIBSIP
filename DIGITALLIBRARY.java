import java.util.*;
class Book {
private String title;
private String author;
private long isbn;

public Book(String title, String author, long isbn) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
}

public String getTitle() {
    return title;
}

public String getAuthor() {
    return author;
}

public long getISBN() {
    return isbn;
}
}

class Library{
private List<Book> books = new ArrayList<>();

public void addBook(Book book) {
    books.add(book);
}

public List<Book> getBooks() {
    return books;
}

public List<Book> searchBooks(String query) {
    List<Book> result = new ArrayList<>();

    for (Book book : books) {
        if (book.getTitle().contains(query) || book.getAuthor().contains(query)) {
            result.add(book);
        }
    }

    return result;
}

}

public class DIGITALLIBRARY{
public static void main(String[] args) {
Library library = new Library();

//add some books
library.addBook(new Book("Management and behavioural process", "Dr.Nidhi Arora", 912110887825L));
library.addBook(new Book("mangerial accounting", "Dr.G.Guanseelan",912134638909L));
library.addBook(new Book("business planning and regulations","Dr.Guru Swamy",912120667436L));
library.addBook(new Book("employability skill development","Veera Thakur",912164870326L));

// remove book
Book bookToRemove = null;
for (Book book : library.getBooks()){
    if (book.getISBN() == 912106835475L){
        bookToRemove = book;
        break;
    }
}
if (bookToRemove != null) {
    library.getBooks().remove(bookToRemove);
}

// search for books
List<Book> results = library.searchBooks("Management and behavioural process");
System.out.println("RESULTS:");
for (Book book : results) {
    System.out.println(book.getTitle() + " by " + book.getAuthor());
}

// print all books
System.out.println("TOTAL BOOKS:");
for (Book book : library.getBooks()){
    System.out.println(book.getTitle() + " by " + book.getAuthor());
}
}
}