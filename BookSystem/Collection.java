package BookSystem;

import java.io.File;
import java.io.PrintWriter;
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
    

    public Book findBookByISBN(long isbn){
        // for each book in books list
        // b is the current book you are looking at
        for(Book b : this.books){
            if(b.getISBN() == isbn){
                return b;
            }
        }
        // didn't find a book
        return null;
    }

    public void removeBook(Book b){
        // -1 is not valid therefore haven't found it
        int removeIndex = -1;
        // creating a counter so we know where we are
        int i = 0;
        for(Book book : this.books){
            // do these match?
            if(book == b){
                // mark the index and stop looking
                removeIndex = i;
                break;
            }
            i++;
        }
        // did I find it?
        if(removeIndex > -1){
            this.books.remove(removeIndex);
            this.writeFile(this.filename);
        }
    }

    private void writeFile(String filename){
        // creating a print writer
        PrintWriter output = null;
        try{
            output = new PrintWriter(new File(filename));
        }catch(Exception e){
            e.printStackTrace();
        }

        // print the header
        output.println("isbn13,authors,title,average_rating");
        for(Book b: this.books){
            // print each book using Book's toString
            output.println(b);
        }
        // close the file to complete writing
        output.close();
    }
    

    
}
