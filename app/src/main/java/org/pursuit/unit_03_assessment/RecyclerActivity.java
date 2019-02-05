package org.pursuit.unit_03_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.controller.view.ZodiacAdapter;
import org.pursuit.unit_03_assessment.model.Zodiac;
import org.pursuit.unit_03_assessment.model.ZodiacApi;
import org.pursuit.unit_03_assessment.network.ZodiacRetrofit;
import org.pursuit.unit_03_assessment.network.Zservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RecyclerActivity extends AppCompatActivity {
    private static final String TAG = "ZodiacJSON";
    private RecyclerView recyclerView;
    private List<Zodiac> myList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        recyclerView = findViewById(R.id.zodiac_recyclerview);

        /*
         * TODO: Add logic that will:
         * TODO 1. Make Retrofit instance for this endpoint: https://raw.githubusercontent.com/JDVila/storybook/master/planets.json
         * TODO 2. Make data model objects based on JSON
         * TODO 3. Make a service interface with method(s) to make a GET request
         * TODO 4. Make a request to the JSON endpoint using the Retrofit instance and the service
         * TODO 5. Subclass a RecyclerView Adapter
         * TODO 6. Subclass a RecyclerView ViewHolder
         * TODO 7. Pass list to RecyclerView
         * TODO 8. Display planet name in a RecyclerView tile
         * TODO 9. Implement an OnClickListener for the itemview
         * TODO 10. Pass the Planet Name, Number, and Image URL data to DisplayActivity when tile is clicked
         */

        Retrofit retrofit = ZodiacRetrofit.getInstance();
        Zservice zService = retrofit.create(Zservice.class);
        Call<ZodiacApi> zodiac = zService.getZodiac();
        zodiac.enqueue(new Callback<ZodiacApi>() {
            @Override
            public void onResponse(Call<ZodiacApi> call, Response<ZodiacApi> response) {
                myList = response.body().getZodiac();
                ZodiacAdapter adapter = new ZodiacAdapter(myList);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }


            @Override
            public void onFailure(Call<ZodiacApi> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t.toString());
            }
        });

    }

}




