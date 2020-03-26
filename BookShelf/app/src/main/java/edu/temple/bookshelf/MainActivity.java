package edu.temple.bookshelf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BookListFragment.BookSelectedInterface {

    public BookListFragment b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = new BookListFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment1,b1)
                .commit();
    }
    @Override
    public void BookSelected(String a, String t) {
           Toast.makeText(getApplicationContext(),a,Toast.LENGTH_LONG).show();
     //   Toast.makeText(getApplicationContext(),t,Toast.LENGTH_LONG).show();
    }
}
