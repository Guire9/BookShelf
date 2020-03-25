package edu.temple.bookshelf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    public ListView bookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookList = findViewById(R.id.booksView);


        ArrayList<HashMap<String,String>> books = new ArrayList<>();
        HashMap<String,String>harryPotter=new HashMap<>();
        HashMap<String,String>Lotr=new HashMap<>();
        HashMap<String,String>HitchhikerGuide=new HashMap<>();
        HashMap<String,String>Dune=new HashMap<>();
        HashMap<String,String>Fahrenheit451=new HashMap<>();

        harryPotter.put("Jk Rowling","Harry Potter");
        Lotr.put("J.R.R Tolkien","Lord of the Rings");
        HitchhikerGuide.put("Douglas Adams","The Hitchhiker's Guide to the Galaxy");
        Dune.put("Frank Herber","Dune");
        Fahrenheit451.put("Ray Bradbury","Fahrenheit 451");

        books.add(harryPotter);
        books.add(Lotr);
        books.add(HitchhikerGuide);
        books.add(Dune);
        books.add(Fahrenheit451);

        BookAdapter customaAdapter = new BookAdapter(this,books);

        bookList.setAdapter(customaAdapter);


    }
}
