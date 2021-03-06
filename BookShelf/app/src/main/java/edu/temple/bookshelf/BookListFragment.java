package edu.temple.bookshelf;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class BookListFragment extends Fragment {
    private  BookSelectedInterface parentActivity;
    private View rootView;
    private ListView bookList;
    private static final String KEY_NAME = "InstanceKey";


    public static BookDetailsFragment newInstance(int x){
        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NAME, x);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if(context instanceof BookSelectedInterface){
            parentActivity = (BookSelectedInterface) context;
        }else{
            throw new RuntimeException("Implement the BookSelect interace");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_book_list, container, false);
        bookList = rootView.findViewById(R.id.booksView);

        final ArrayList<HashMap<String,String>> books =BookHelper.gernerateBooks();
        BookAdapter customaAdapter = new BookAdapter(rootView.getContext(),books);

        bookList.setAdapter(customaAdapter);
        bookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  parentActivity.BookSelected(books.get(position), position);
          }
      });
        return rootView;
    }

    interface BookSelectedInterface{
        void BookSelected(HashMap<String,String> b, int position);
    }
    public BookListFragment() {

    }
}
