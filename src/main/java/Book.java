class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int year;

    public Book(String isbn, String title, String author, String publisher, int year) throws LibraryException {
        if (isbn == null || isbn.isEmpty()) {
            throw new LibraryException("ISBN cannot be null or empty.");
        }
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
}
