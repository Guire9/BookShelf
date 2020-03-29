package edu.temple.bookshelf;

import java.util.ArrayList;
import java.util.HashMap;

public class BookHelper {


    public static ArrayList<HashMap<String,String>> gernerateBooks() {
        ArrayList<HashMap<String, String>> bookList = new ArrayList<>();

        newBook("Jk Rowling","Harry Potter",bookList);
        newBook("J.R.R Tolkien","Lord of the Rings",bookList);
        newBook("Douglas Adams","The Hitchhiker's Guide to the Galaxy",bookList);
        newBook("Frank Herber","Dune",bookList);
        newBook("Ray Bradbury","Fahrenheit 451",bookList);
        newBook("Herman Melville","Moby Dick",bookList);
        newBook("Charlotte Bronte","Jane Eyre",bookList);
        newBook("Mary Shelley.","Frankenstein",bookList);
        newBook("Mark Twain","The Adventures of Tom Sawyer",bookList);
        newBook("Jane Austen","Pride and Prejudice",bookList);
        return bookList;
    }

    public static ArrayList<HashMap<String,String>> newBook(String a, String t, ArrayList<HashMap<String, String>> h){
        HashMap<String,String> b = new HashMap<>();
        b.put("author",a);
        b.put("title",t);
        h.add(b);
        return h;
    }
}
