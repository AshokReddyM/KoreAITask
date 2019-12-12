package com.example.koreaitask.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.koreaitask.R;
import com.example.koreaitask.adapters.RecyclerViewAdapter;
import com.example.koreaitask.data.dummy.DummyItem;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;


public class ListFragment2 extends BottomSheetDialogFragment {

    private ArrayList<DummyItem> items = new ArrayList<DummyItem>();
    private int count;
    private RecyclerViewAdapter mAdapter;


    public ListFragment2() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        generateDummyItems();
        mAdapter = new RecyclerViewAdapter(this, items, recyclerView);
        recyclerView.setAdapter(mAdapter);


        mAdapter.setOnLoadMoreListener(() -> {
            items.add(null);
            mAdapter.notifyItemInserted(items.size() - 1);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    items.remove(items.size() - 1);
                    mAdapter.notifyItemRemoved(items.size());
                    generateDummyItems();
                    mAdapter.notifyDataSetChanged();
                    mAdapter.setLoaded();
                }
            }, 1000);

        });


        return view;
    }


    public List<DummyItem> generateDummyItems() {
        count = items.size() + 20;
        for (int i = items.size(); i < count; i++) {
            addItem(createDummyItem(i + 1));
        }

        return items;
    }

    private void addItem(DummyItem item) {
        items.add(item);
    }

    private DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, "This is subtitle " + position);
    }

}
