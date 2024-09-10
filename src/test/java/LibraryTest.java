import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Member member1;

    @BeforeEach
    public void setUp() throws LibraryException {
        library = new Library(new SimpleBorrowingService());
        book1 = new Book("123", "The Great Gatsby", "F. Scott Fitzgerald", "Scribner", 1925);
        book2 = new Book("456", "1984", "George Orwell", "Secker & Warburg", 1949);
        member1 = new Member("M001", "John Doe", "123 Main St", "123-456-7890");
    }

    @Test
    public void testAddBook() throws LibraryException {
        library.addBook(book1);
        library.addBook(book2);
        assertThrows(LibraryException.class, () -> library.addBook(book1)); // Book already exists
    }

    @Test
    public void testRemoveBook() throws LibraryException {
        library.addBook(book1);
        library.removeBook("123");
        assertThrows(LibraryException.class, () -> library.removeBook("123")); // Book not found
    }

    @Test
    public void testAddMember() throws LibraryException {
        library.addMember(member1);
        assertThrows(LibraryException.class, () -> library.addMember(member1)); // Member already exists
    }

    @Test
    public void testBorrowAndReturnBook() throws LibraryException {
        library.addBook(book1);
        library.addMember(member1);
        library.borrowBook(book1, member1);
        assertThrows(LibraryException.class, () -> library.borrowBook(book1, member1)); // Book already borrowed

        library.returnBook(book1, member1);
        assertThrows(LibraryException.class, () -> library.returnBook(book1, member1)); // Book was not borrowed
    }
}
