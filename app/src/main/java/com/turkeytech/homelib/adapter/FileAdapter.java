package com.turkeytech.homelib.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.turkeytech.homelib.R;
import com.turkeytech.homelib.java.model.BookFile;

import java.util.ArrayList;

public class FileAdapter extends ArrayAdapter<BookFile> {
    private Context cxt;
    private int res;
    private ArrayList<BookFile> list;

    public FileAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<BookFile> objects) {
        super(context, resource, objects);

        cxt = context;
        res = resource;
        list = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Initializing view which will point to layout file list_item
        @SuppressLint("ViewHolder")
        View view = LayoutInflater.from(cxt).inflate(res, parent, false);

        //Text view showing pdf file name
        TextView txtView = view.findViewById(R.id.txtFileName);

        //setting the file name
        txtView.setText(list.get(position).getFileName());
        return view;
    }
}
