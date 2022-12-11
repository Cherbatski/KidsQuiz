package com.example.volleyproj;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;


public class AnimalActivity extends AppCompatActivity {
    Button btndown ,btnQuiz;
    ImageView image1;
    Spinner spinner;
    RequestQueue queue;
    com.android.volley.toolbox.ImageRequest requestanimal;
    public HashMap<String, String> animalsURL;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_activity);


       animalsURL = new HashMap<String, String>();
       animalsURL.put("tigre","https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Siberischer_tiger_de_edit02.jpg/800px-Siberischer_tiger_de_edit02.jpg");
       animalsURL.put("elephant","https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/African_Bush_Elephant.jpg/800px-African_Bush_Elephant.jpg");
       animalsURL.put("chien","https://ggsc.s3.amazonaws.com/images/made/images/uploads/The_Science-Backed_Benefits_of_Being_a_Dog_Owner_300_200_int_c1-1x.jpg");



        spinner=findViewById(R.id.animalSpinner);
        btndown=(Button) findViewById(R.id.load_image3);
        image1=(ImageView) findViewById(R.id.image_view2) ;
        btnQuiz=findViewById(R.id.quizbtn2);


        btndown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c=  spinner.getSelectedItem().toString();
                String u= animalsURL.get(c).toString();
                setImageReq(u);
                queue.add(requestanimal);


            }
        });
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AnimalActivity.this, AnimalQuiz.class);
                startActivity(intent);
            }
        });



    }

    public void setImageReq( String s) {


        queue = Volley.newRequestQueue(this);

        requestanimal = new com.android.volley.toolbox.ImageRequest(s,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {

                        image1.setImageBitmap(bitmap);

                    }
                }, 500, 500, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {


                        //imageView.setImageResource(R.drawable.image_load_error);
                    }
                });

    }}