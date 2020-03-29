package edu.temple.bookshelf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements BookListFragment.BookSelectedInterface {
    BookListFragment b1 = new BookListFragment();
    BookDetailsFragment b2 = new BookDetailsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState ==null){
            if(findViewById(R.id.Large_fragment_container)  != null
                    && (findViewById(R.id.fragment_containerD_Land) == null)) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.Large_fragment_container, b1)
                        .addToBackStack(null)
                        .commit();
            }else if(findViewById(R.id.fragment_containerD_Land) == null){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.fragment_container_default, b1)
                            .addToBackStack(null)
                            .commit();
                }
            }else{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_Land, b1)
                    .addToBackStack(null)
                    .commit();
        }
        }
    public void BookSelected(HashMap<String,String> b, int position){
        BookDetailsFragment b2 = new BookDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(BookDetailsFragment.Arg_Position,position);
        args.putString(BookDetailsFragment.AuthorString,b.get("author"));
        args.putString(BookDetailsFragment.BookString,b.get("title"));
        b2.setArguments(args);

        if(findViewById(R.id.Large_fragment_container)  != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.Large_fragment_containerD, b2)
                    .addToBackStack(null)
                    .commit();
        }else if(findViewById(R.id.fragment_containerD_Land) != null){
               getSupportFragmentManager()
                       .beginTransaction()
                       .replace(R.id.fragment_containerD_Land, b2)
                       .addToBackStack(null)
                       .commit();
        }else{
            b2 = BookDetailsFragment.newInstance(position,b.get("author"),b.get("title"));
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_default, b2)
                    .addToBackStack(null)
                    .commit();
        }
    }
}

