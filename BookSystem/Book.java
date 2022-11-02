package BookSystem;

public class Book {
    private long isbn;
    private String title;
    private String author;
    private double rating;

    public Book(long isbn, String title, String author, double rating){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.rating = rating;
    }

    public long getISBN(){
        return this.isbn;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public double getRating(){
        return this.rating;
    }

    public String toString(){
        return this.isbn + "," + this.author + "," 
            + this.title + "," + this.rating;
    }
}
