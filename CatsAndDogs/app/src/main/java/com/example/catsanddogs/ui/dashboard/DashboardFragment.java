package com.example.catsanddogs.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catsanddogs.R;
import com.example.catsanddogs.adapters.AnimalAdapter;
import com.example.catsanddogs.models.Animal;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    RecyclerView.LayoutManager mLayoutManager;
    private AnimalAdapter mAnimalAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);

        final RecyclerView recyclerView = root.findViewById(R.id.recyclerViewDashBoard);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);

        dashboardViewModel.getAnimalList().observe(this, new Observer<List<Animal>>() {
            @Override
            public void onChanged(List<Animal> animals) {

                mAnimalAdapter = new AnimalAdapter(getContext(), (ArrayList<Animal>) animals);
                recyclerView.setAdapter(mAnimalAdapter);

            }
        });
        return root;
    }
}