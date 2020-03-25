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
        ArrayList<HashMap<String,String>> books =BookHelper.gernerateBooks();
        BookAdapter customaAdapter = new BookAdapter(this,books);
        bookList.setAdapter(customaAdapter);


    }
}
