package com.example.volleyproj;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;


public class ColorQuiz extends AppCompatActivity {
    Button button,btnretour;
    ImageView image1,image2;
    CheckBox ch1,ch2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_color);



        button=(Button) findViewById(R.id.verifier);
        btnretour=(Button) findViewById(R.id.retour);
        image1=(ImageView) findViewById(R.id.image_view1) ;
        image2=(ImageView) findViewById(R.id.image_view2) ;
        ch1=findViewById(R.id.checkbox1);
        ch2=findViewById(R.id.checkbox4);
        String s="https://download.vikidia.org/vikidia/fr/images/thumb/9/99/Noir_%28couleur%29.jpg/800px-Noir_%28couleur%29.jpg";

       String s2="https://download.vikidia.org/vikidia/fr/images/6/68/Vert_fonc%C3%A9.jpeg";

        RequestQueue queue1 = Volley.newRequestQueue(this);
        com.android.volley.toolbox.ImageRequest  request1 = new com.android.volley.toolbox.ImageRequest(s,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {

                        ColorQuiz.this.image1.setImageBitmap(bitmap);

                    }
                }, 250, 250, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {


                        //imageView.setImageResource(R.drawable.image_load_error);
                    }
                });
        queue1.add(request1);


        RequestQueue queue2 = Volley.newRequestQueue(this);
        com.android.volley.toolbox.ImageRequest  request2 = new com.android.volley.toolbox.ImageRequest(s2,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {

                        ColorQuiz.this.image2.setImageBitmap(bitmap);

                    }
                }, 250, 250, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {


                        //imageView.setImageResource(R.drawable.image_load_error);
                    }
                });
        queue1.add(request2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

      if(ch1.isChecked() && ch2.isChecked())
      {
          Toast.makeText(getApplicationContext(), "score complet", Toast.LENGTH_SHORT).show();

      }

             else{
                    Toast.makeText(getApplicationContext(), "score incomplet", Toast.LENGTH_SHORT).show();

                }
            }

        });

      btnretour.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view)
          {
              Intent intent=new Intent(ColorQuiz.this,MainActivity.class);
              startActivity(intent);
              finish();
          }
      });
    }


    }



