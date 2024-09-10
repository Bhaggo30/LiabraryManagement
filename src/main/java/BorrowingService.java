import java.util.HashMap;
import java.util.Map;

interface BorrowingService {
    void borrowBook(Book book, Member member) throws LibraryException;
    void returnBook(Book book, Member member) throws LibraryException;
}

class SimpleBorrowingService implements BorrowingService {
    private Map<Book, Member> borrowedBooks = new HashMap<>();

    @Override
    public void borrowBook(Book book, Member member) throws LibraryException {
        if (borrowedBooks.containsKey(book)) {
            throw new LibraryException("Book is already borrowed.");
        }
        borrowedBooks.put(book, member);
        System.out.println(member + " borrowed " + book);
    }

    @Override
    public void returnBook(Book book, Member member) throws LibraryException {
        if (!borrowedBooks.containsKey(book)) {
            throw new LibraryException("Book was not borrowed.");
        }
        borrowedBooks.remove(book);
        System.out.println(member + " returned " + book);
    }
}
