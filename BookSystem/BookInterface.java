package BookSystem;

public class BookInterface {
    public static void main(String[] args) {
        Collection bookCollection = new Collection("BookSystem/books.csv");

        Book book1 = bookCollection.findBookByISBN(9780451524940l);
        bookCollection.removeBook(book1);
        Book book2 = bookCollection.findBookByISBN(9780451524940l);
        System.out.println(book2);
    }
}
