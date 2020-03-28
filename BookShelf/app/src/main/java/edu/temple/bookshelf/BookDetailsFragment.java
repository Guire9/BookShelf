package edu.temple.bookshelf;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetailsFragment extends Fragment {
    final static String Arg_Position = "position";
    int myCurrentPosition =-1;
    View rootview;

    public BookDetailsFragment() {

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
        args.getString("aKey");
        args.getString("tKey");
        if(args != null){
            updateBook(args.getInt(Arg_Position),args.getString("aKey"),args.getString("tKey"));

        }else if(myCurrentPosition !=-1){
            updateBook(myCurrentPosition,args.getString("aKey"),args.getString("tKey"));
        }
    }
    public void updateBook(int position, String a, String t){
        myCurrentPosition=position;
        TextView Book = (TextView) getActivity().findViewById(R.id.book);
        TextView Author = (TextView) getActivity().findViewById(R.id.book_author);
        Book.setText(t);
        Author.setText(a);
    }


    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(Arg_Position,myCurrentPosition);
    }

}
