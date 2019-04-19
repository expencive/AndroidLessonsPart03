package expencive.vk.com.fragmentbottomnavigation;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import expencive.vk.com.fragmentbottomnavigation.adapter.AnimalAdapter;
import expencive.vk.com.fragmentbottomnavigation.api.ApiClient;
import expencive.vk.com.fragmentbottomnavigation.api.ApiInterface;
import expencive.vk.com.fragmentbottomnavigation.models.Animal;
import expencive.vk.com.fragmentbottomnavigation.models.Animals;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment{
    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_NUMBER = "number";
    public static final String EXTRA_TITLE = "title";


    private RecyclerView mRecyclerView;
    private AnimalAdapter mAnimalAdapter;
    private ArrayList<Animal> mAnimalList;

    public static int index = -1;
    public static int top = -1;
    RecyclerView.LayoutManager mLayoutManager;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = rootView.findViewById(R.id.recycler_view);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        return rootView;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadJson();


    }

    public void loadJson(){

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        //String cat = "cat";

        Call<Animals> call;

        call = apiInterface.getCats();

        call.enqueue(new Callback<Animals>() {
            @Override
            public void onResponse(Call<Animals> call, Response<Animals> response) {
                if (response.isSuccessful() && response.body().getAnimalList()!=null) {
                    mAnimalList = new ArrayList<>();



                    List<Animal> animals = new ArrayList<>();
                    animals = response.body().getAnimalList();
                    mAnimalList = (ArrayList<Animal>) animals;


                    mAnimalAdapter = new AnimalAdapter(getContext(), mAnimalList);
                    mRecyclerView.setAdapter(mAnimalAdapter);
                    //mRecyclerView.setLayoutManager(mLayoutManager);
                    mAnimalAdapter.setOnItemClickListener(new AnimalAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            Intent detailIntent = new Intent(getContext(), ItemActivity.class);
                            Animal clickedItem = mAnimalList.get(position);

                            detailIntent.putExtra(EXTRA_URL, clickedItem.getImageUrl());
                            detailIntent.putExtra(EXTRA_NUMBER, String.valueOf(position+1));
                            detailIntent.putExtra(EXTRA_TITLE, clickedItem.getImageTitle());

                            startActivity(detailIntent);
                        }
                    });







                    return;
                } else{
                    Toast.makeText(getContext(), "not succesful", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<Animals> call, Throwable t) {
                Toast.makeText(getContext(), String.valueOf(t.getMessage()), Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public void onPause()
    {
        super.onPause();
        //read current recyclerview position
        index = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        View v = mRecyclerView.getChildAt(0);
        top = (v == null) ? 0 : (v.getTop() - mRecyclerView.getPaddingTop());
    }

    @Override
    public void onResume()
    {
        super.onResume();
        //set recyclerview position
        if(index != -1)
        {
            mLayoutManager.scrollToPosition( index);
        }
    }




//    @Override
//    public void onPause() {
//        super.onPause();
//
//        lastFirstVisiblePosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
//        Toast.makeText(getContext(), "Pause" + lastFirstVisiblePosition, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        if (lastFirstVisiblePosition!=0){
//
//            ( mRecyclerView.getLayoutManager()).scrollToPosition(lastFirstVisiblePosition);
//
//
//
//        }
//
//        Toast.makeText(getContext(), "Resume" + lastFirstVisiblePosition, Toast.LENGTH_SHORT).show();
//
//
//
//
//    }


}
