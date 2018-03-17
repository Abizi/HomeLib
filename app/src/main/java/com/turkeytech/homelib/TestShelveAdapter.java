package com.turkeytech.homelib;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestShelveAdapter extends RecyclerView.Adapter<TestShelveAdapter.VH> {

    private static final String TAG = "xix: TestShelve";
    private ArrayList books;
    private int rows;

    TestShelveAdapter(ArrayList books, int rows) {
        this.books = books;
        this.rows = rows;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.shelf_row, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Log.i(TAG, "onBindViewHolder: " + position);
        holder.doCrazyMath(books, position);
    }

    @Override
    public int getItemCount() {
        return rows;
    }

    class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.shelf_row)
        RecyclerView recyclerView;

        VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void doCrazyMath(ArrayList book, int position) {

            ArrayList c = new ArrayList();

            int first = ((position + 1) * 3) - 3;
            int second = ((position + 1) * 3) - 2;
            int third = ((position + 1) * 3) - 1;

            if (first <= book.size() - 1)
                c.add(book.get(first));
            if (second <= book.size() - 1)
                c.add(book.get(second));
            if (third <= book.size() - 1)
                c.add(book.get(third));

            recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setAdapter(new TestShelveRowAdapter(c));
        }
    }
}
