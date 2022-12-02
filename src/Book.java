public class Book {

    private String isbn;//isbn number
    private String title;//title of book

    private String category;//genre of book
    private String edition;//edition of the book
    private String authors;//Author or authors of the book
    private String bookStatus;//should return true if book is currently available in library

    //instances should be created by librarian class
    public Book(String isbn, String title, String authors,String category, String edition,String status) {
        this.isbn=isbn;
        this.title=title;
        this.authors=authors;
        this.category = category;
        bookStatus = status;
        this.edition=edition;

    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }


    public String getEdition() {
        return edition;
    }

    public String getAuthors() {
        return authors;
    }

    public String getBookStatus() {
        return bookStatus;
    }

}