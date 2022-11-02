package BookSystem;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Collection {
    private ArrayList<Book> books;
    private String filename;

    public Collection(String filename){
        // initialize an arraylist
        this.books = new ArrayList<>();
        this.filename = filename;
        this.readFile(filename);
    }

    private void readFile(String filename){
        // start with null to create a Scanner
        Scanner input = null;
        // might be errors
        try{
            input = new Scanner(new File(filename));
        }catch(Exception e){
            // print the error if it happens
            e.printStackTrace();
        }
        // throw away the header
        input.nextLine();
        // keep going while there are still books
        while(input.hasNext()){
            // scan the line and split around commas
            String line = input.nextLine();
            String[] bookInfo = line.split(",");
            // get all the book info to create a book
            long isbn = Long.parseLong(bookInfo[0]);
            String author = bookInfo[1];
            String title = bookInfo[2];
            double rating = Double.parseDouble(bookInfo[3]);
            Book b = new Book(isbn, title, author, rating);
            // add book to list
            this.books.add(b);
        }
        // close off the scanner
        input.close();
    }   

    
}
