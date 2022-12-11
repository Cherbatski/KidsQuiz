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


public class AnimalQuiz extends AppCompatActivity {
    Button button,btnretour;
    ImageView image1,image2;
    CheckBox ch1,ch2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_animal);



        button=(Button) findViewById(R.id.verifier);
        btnretour=(Button) findViewById(R.id.retour);
        image1=(ImageView) findViewById(R.id.image_view5) ;
        image2=(ImageView) findViewById(R.id.image_view6) ;
        ch1=findViewById(R.id.checkbox15);
        ch2=findViewById(R.id.checkbox17);
        String s="https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Siberischer_tiger_de_edit02.jpg/800px-Siberischer_tiger_de_edit02.jpg";
        String s2="https://ggsc.s3.amazonaws.com/images/made/images/uploads/The_Science-Backed_Benefits_of_Being_a_Dog_Owner_300_200_int_c1-1x.jpg";

        RequestQueue queue1 = Volley.newRequestQueue(this);
        com.android.volley.toolbox.ImageRequest  request1 = new com.android.volley.toolbox.ImageRequest(s,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {

                        AnimalQuiz.this.image1.setImageBitmap(bitmap);

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

                        AnimalQuiz.this.image2.setImageBitmap(bitmap);

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
                Intent intent=new Intent(AnimalQuiz.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
