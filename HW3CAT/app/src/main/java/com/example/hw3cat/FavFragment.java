package com.example.hw3cat;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw3cat.database.DBUtil;
import com.example.hw3cat.model.Cat;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavFragment extends Fragment {

    private List<Cat> catList = new ArrayList<>();
    FavAdapter viewAdapter;
    DBUtil dbUtil;
    public FavFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fav, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        dbUtil = new DBUtil(getContext());
        catList.addAll(dbUtil.getFavs());
        viewAdapter = new FavAdapter(catList);
        recyclerView.setAdapter(viewAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        catList.clear();
        catList.addAll(dbUtil.getFavs());
        viewAdapter.notifyDataSetChanged();
    }
}
