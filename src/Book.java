public class Book {

    private String isbn;//isbn number
    private String title;//title of book

    private String category;//genre of book
    private String edition;//edition of the book
    private String authors;//Author or authors of the book


    //instances should be created by librarian class
    public Book(String isbn, String title, String authors,String category, String edition) {
        this.isbn=isbn;
        this.title=title;
        this.authors=authors;
        this.category = category;
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



}