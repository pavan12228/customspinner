package com.example.ravi.materialspinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {


    private static final String Root_url = "http://api.androidhive.info/json";
    List<Model> stringArrayList=new ArrayList<>();
     Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner= (Spinner) findViewById(R.id.Spinner);
        inserUser();
        CustomAdapter customAdapter=new CustomAdapter(stringArrayList,getApplicationContext());
        spinner.setAdapter(customAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void inserUser() {

        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(Root_url).build();

        DetailsApi api = adapter.create(DetailsApi.class);
        api.Mymeth(new Callback<JsonArray>() {


            @Override
            public void success(JsonArray jsonElements, Response response) {
                for (int i = 0; i < jsonElements.size(); i++) {

                                   JsonObject jsonObject1= jsonElements.get(i).getAsJsonObject();
                                  String name= jsonObject1.get("title").getAsString();
                                  String image=jsonObject1.get("image").getAsString();
                                  Model model=new Model();
                                   model.setName(name);
                                model.setImage(image);
                       stringArrayList.add(model);
                }




            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, "Retro error"+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
