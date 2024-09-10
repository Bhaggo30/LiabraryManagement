import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(new SimpleBorrowingService());
        Scanner sc = new Scanner(System.in);

        // Add sample data
        library.addBook(new Book("123", "The Great Gatsby", "F. Scott Fitzgerald", "Scribner", 1925));
        library.addMember(new Member("M001", "John Doe", "123 Main St", "123-456-7890"));

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Add Member");
            System.out.println("5. Remove Member");
            System.out.println("6. Search Member");
            System.out.println("7. Borrow Book");
            System.out.println("8. Return Book");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter book publisher: ");
                    String publisher = sc.nextLine();
                    System.out.print("Enter year of publication: ");
                    int year = sc.nextInt();
                    library.addBook(new Book(isbn, title, author, publisher, year));
                    break;

                case 2:
                    System.out.print("Enter book ISBN to remove: ");
                    String removeIsbn = sc.nextLine();
                    library.removeBook(removeIsbn);
                    break;

                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = sc.nextLine();
                    library.searchBook(searchTitle);
                    break;

                case 4:
                    System.out.print("Enter member ID: ");
                    String memberId = sc.nextLine();
                    System.out.print("Enter member name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter member address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter member contact: ");
                    String contact = sc.nextLine();
                    library.addMember(new Member(memberId, name, address, contact));
                    break;

                case 5:
                    System.out.print("Enter member ID to remove: ");
                    String removeMemberId = sc.nextLine();
                    library.removeMember(removeMemberId);
                    break;

                case 6:
                    System.out.print("Enter member name to search: ");
                    String searchMemberName = sc.nextLine();
                    library.searchMember(searchMemberName);
                    break;

                case 7:
                    System.out.print("Enter book title to borrow: ");
                    String borrowBookTitle = sc.nextLine();
                    System.out.print("Enter member ID: ");
                    String borrowMemberId = sc.nextLine();
                    library.borrowBook(new Book(borrowBookTitle, borrowBookTitle, "", "", 0),
                            new Member(borrowMemberId, "", "", ""));
                    break;

                case 8:
                    System.out.print("Enter book title to return: ");
                    String returnBookTitle = sc.nextLine();
                    System.out.print("Enter member ID: ");
                    String returnMemberId = sc.nextLine();
                    library.returnBook(new Book(returnBookTitle, returnBookTitle, "", "", 0),
                            new Member(returnMemberId, "", "", ""));
                    break;

                case 9:
                    System.out.println("Exiting the Library System.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
