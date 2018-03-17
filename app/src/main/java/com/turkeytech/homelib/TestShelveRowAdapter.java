package com.turkeytech.homelib;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestShelveRowAdapter extends RecyclerView.Adapter<TestShelveRowAdapter.VH> {

    ArrayList books;

    TestShelveRowAdapter(ArrayList books) {
        this.books = books;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class VH extends RecyclerView.ViewHolder{

        @BindView(R.id.shelf_row_image)
        ImageView imageView;

        VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
