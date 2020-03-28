package edu.temple.bookshelf;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

public class BookDetailsFragment extends Fragment {
    final static String Arg_Position = "position";
    final static String AuthorString = "author";
    final static String BookString = "book";

    int myCurrentPosition =-1;
    String myAuthor="a";
    String myBook="b";
    View rootview;

    public BookDetailsFragment() {

    }

   public static BookDetailsFragment newInstance(int x, String a, String s){
        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Arg_Position,x);
        bundle.putString(AuthorString,a);
        bundle.putString(BookString,s);
        fragment.setArguments(bundle);
        return fragment;
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_book_details, container, false);
        if(savedInstanceState != null){
            myCurrentPosition= savedInstanceState.getInt(Arg_Position);
        }
        return rootview;
    }

    @Override
    public void onStart(){
        super.onStart();
        Bundle args = getArguments();
        if(args != null){
            updateBook(args.getInt(Arg_Position), args.getString(AuthorString), args.getString(BookString));

        }else if(myCurrentPosition !=-1){
            updateBook(myCurrentPosition,args.getString(AuthorString), args.getString(BookString));
        }
    }

    public void updateBook(int position, String a, String t){
        myCurrentPosition=position;
        myAuthor=a;
        myBook=t;

        TextView Book = (TextView) getActivity().findViewById(R.id.book);
        TextView Author = (TextView) getActivity().findViewById(R.id.book_author11);

        Book.setText(myBook);
        Author.setText(myAuthor);
    }


    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(Arg_Position,myCurrentPosition);
        outState.putString(AuthorString,myAuthor);
        outState.putString(BookString,myBook);
    }

}
