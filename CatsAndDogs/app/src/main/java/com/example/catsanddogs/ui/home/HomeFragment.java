package com.example.catsanddogs.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private AnimalAdapter mAnimalAdapter;

    RecyclerView.LayoutManager mLayoutManager;

    ArrayList<Animal> mAnimals = new ArrayList<>();

        public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        final RecyclerView recyclerView = root.findViewById(R.id.recyclerViewHome);

        //mAnimalAdapter = new AnimalAdapter(getContext(), mAnimals);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);


        homeViewModel.getAnimalList().observe(this, new Observer<List<Animal>>() {
            @Override
            public void onChanged(List<Animal> animals) {

                if(mAnimalAdapter==null){
                    Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT).show();
                    mAnimalAdapter = new AnimalAdapter(getContext(), (ArrayList<Animal>) animals);
                    recyclerView.setAdapter(mAnimalAdapter);

                }
            }
        });

        //homeViewModel.setCatsList();
        return root;
    }


}