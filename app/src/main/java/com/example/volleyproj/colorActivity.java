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


public class colorActivity extends AppCompatActivity {
    Button button ,btnQuiz,btnverif;
    ImageView image1,m;
   TextView t;
   Spinner spinner;
    RequestQueue queue;
    com.android.volley.toolbox.ImageRequest request;
   public HashMap<String, String> ColorURL;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_activity);


         ColorURL = new HashMap<String, String>();
        ColorURL.put("noir", "https://download.vikidia.org/vikidia/fr/images/thumb/9/99/Noir_%28couleur%29.jpg/800px-Noir_%28couleur%29.jpg");
        ColorURL.put("vert", "https://download.vikidia.org/vikidia/fr/images/6/68/Vert_fonc%C3%A9.jpeg");
        ColorURL.put("bleu", "https://revuedada.fr/wp-content/uploads/2022/02/indigo.png.webp");
        ColorURL.put("jaune", "https://www.apyart.com/2142-large_default/jaune-or-500ml.jpg");
        ColorURL.put("rouge", "https://upload.wikimedia.org/wikipedia/commons/2/20/Couleur_rouge.jpg");
        ColorURL.put("rose", "https://webdi.fr/img/couleurs/f9429e.png");


       spinner=findViewById(R.id.formSpinner);
        button=(Button) findViewById(R.id.load_image2);
        image1=(ImageView) findViewById(R.id.image_view1) ;

       btnQuiz=findViewById(R.id.quizbtn);
      btnverif=findViewById(R.id.verifier);

           button.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                 String c=  spinner.getSelectedItem().toString();
                 String u= ColorURL.get(c).toString();
                 setImageReq(image1,u);
                 queue.add(request);


               }
           });
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(colorActivity.this, ColorQuiz.class);
                startActivity(intent);
            }
        });



    }

    public void setImageReq( ImageView m,String s) {


        queue = Volley.newRequestQueue(this);

        request = new com.android.volley.toolbox.ImageRequest(s,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {

                        m.setImageBitmap(bitmap);

                    }
                }, 250, 250, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {

                        t.setText("Error Occured.");
                        //imageView.setImageResource(R.drawable.image_load_error);
                    }
                });

    }



}
