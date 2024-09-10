import java.util.ArrayList;
import java.util.List;
class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private BorrowingService borrowingService;

    public Library(BorrowingService borrowingService) {

        this.borrowingService = borrowingService;
    }

    public void addBook(Book book) throws LibraryException {
        for (Book b : books) {
            if (b.getIsbn().equals(book.getIsbn())) {
                throw new LibraryException("Book with this ISBN already exists.");
            }
        }
        books.add(book);
        System.out.println("Added book: " + book);
    }

    public void removeBook(String isbn) throws LibraryException {
        boolean removed = books.removeIf(book -> book.getIsbn().equals(isbn));
        if (!removed) {
            throw new LibraryException("Book not found with ISBN: " + isbn);
        }
        System.out.println("Removed book with ISBN: " + isbn);
    }

    public void addMember(Member member) throws LibraryException {
        for (Member m : members) {
            if (m.getMemberId().equals(member.getMemberId())) {
                throw new LibraryException("Member with this ID already exists.");
            }
        }
        members.add(member);
        System.out.println("Added member: " + member);
    }

    public void removeMember(String memberId) throws LibraryException {
        boolean removed = members.removeIf(member -> member.getMemberId().equals(memberId));
        if (!removed) {
            throw new LibraryException("Member not found with ID: " + memberId);
        }
        System.out.println("Removed member with ID: " + memberId);
    }

    public void borrowBook(Book book, Member member) throws LibraryException {
        borrowingService.borrowBook(book, member);
    }

    public void returnBook(Book book, Member member) throws LibraryException {
        borrowingService.returnBook(book, member);
    }

    public void searchBook(String searchTitle) {
    }

    public void searchMember(String searchMemberName) {

    }
}
