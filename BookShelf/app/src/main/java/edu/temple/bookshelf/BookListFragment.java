package edu.temple.bookshelf;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookListFragment extends Fragment {
    private  BookSelectedInterface parentActivity;
    private View rootView;
    private ListView bookList;
    private String title;
    private String author;

    public BookListFragment() {
        // Required empty public constructor
    }
    public void onAttach(Context context){
        super.onAttach(context);

        if(context instanceof BookSelectedInterface){
            parentActivity = (BookSelectedInterface) context;
        }else{
            throw new RuntimeException("Implemnt the BookSelect interace");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_book_list, container, false);

        bookList = (ListView)rootView.findViewById(R.id.booksView);
        final ArrayList<HashMap<String,String>> books =BookHelper.gernerateBooks();

        BookAdapter customaAdapter = new BookAdapter(rootView.getContext(),books);
        bookList.setAdapter(customaAdapter);

      bookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              author=books.get(position).get("author");
              title=books.get(position).get("title");
              parentActivity.BookSelected(author,title);
          }
      });
        return rootView;
    }

    interface BookSelectedInterface{
         void BookSelected(String a, String t);
    }

}
