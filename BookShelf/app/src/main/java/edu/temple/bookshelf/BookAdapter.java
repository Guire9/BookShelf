package edu.temple.bookshelf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class BookAdapter extends BaseAdapter implements ListAdapter {
    private Context context;
    private ArrayList<HashMap<String,String>> books;
    LayoutInflater inflater;

    public BookAdapter(Context context,ArrayList<HashMap<String,String>>books){
        this.context=context;
        this.books=books;
        inflater=(LayoutInflater.from(context));
    }
    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if( view == null){
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.book_list,null);
        }
        TextView book_title= view.findViewById(R.id.book_title);
        TextView author = view.findViewById(R.id.book_author22);

        Set<String> keys = books.get(position).keySet();
        for(String k : keys){
            if(k.equals("author")){
                author.setText(books.get(position).get(k));
            }else if(k.equals("title")){
                book_title.setText(books.get(position).get(k));
            }
        }
        return view;
    }
}

