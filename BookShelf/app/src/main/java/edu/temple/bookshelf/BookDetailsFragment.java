package edu.temple.bookshelf;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetailsFragment extends Fragment {
    final static String Arg_Position = "position";
    int myCurrentPosition =-1;

    public BookDetailsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null){
            myCurrentPosition= savedInstanceState.getInt(Arg_Position);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_details, container, false);
    }
    @Override
    public void onStart(){
        super.onStart();
        Bundle args = getArguments();
        if(args != null){
            updateBook(args.getInt(Arg_Position));
        }else if(myCurrentPosition !=-1){
            updateBook(myCurrentPosition);
        }
    }
    public void updateBook(int position){
        TextView Book = (TextView) getActivity().findViewById(R.id.book);
        myCurrentPosition=position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(Arg_Position,myCurrentPosition);
    }

}
