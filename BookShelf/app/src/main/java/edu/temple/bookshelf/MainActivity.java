package edu.temple.bookshelf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements BookListFragment.BookSelectedInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container) !=null){
            if(savedInstanceState !=null){
                return;
            }
            BookListFragment b1 = new BookListFragment();
            b1.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,b1).commit();
        }
    }

    public void BookSelected(String a,String t, int position){
        BookDetailsFragment b2 = new BookDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(BookDetailsFragment.Arg_Position,position);
        b2.setArguments(args);
        getSupportFragmentManager().beginTransaction()
       .replace(R.id.fragment_container,b2)
       .addToBackStack(null)
        .commit();

    }
}

