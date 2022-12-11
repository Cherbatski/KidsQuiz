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


public class formActivity extends AppCompatActivity {
    Button btndown ,btnQuiz;
    ImageView image1;
    Spinner spinner;
    RequestQueue queue;
    com.android.volley.toolbox.ImageRequest requestShapes;
    public HashMap<String, String> ShapesURL;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_activity);


        ShapesURL = new HashMap<String, String>();
        ShapesURL.put("triangle","https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Regular_triangle.svg/800px-Regular_triangle.svg.png");
        ShapesURL.put("cercle","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Circle_-_black_simple.svg/800px-Circle_-_black_simple.svg.png");
        ShapesURL.put("rectangle","https://cutewallpaper.org/24/rectangle-png/2051318107.jpg");



        spinner=findViewById(R.id.Spinnershapes);
        btndown=(Button) findViewById(R.id.load_image2);
        image1=(ImageView) findViewById(R.id.image_view1) ;
        btnQuiz=findViewById(R.id.quizbtn2);


        btndown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c=  spinner.getSelectedItem().toString();
                String u= ShapesURL.get(c).toString();
                setImageReq(u);
                queue.add(requestShapes);


            }
        });
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(formActivity.this, FormQuiz.class);
                startActivity(intent);
            }
        });



    }

    public void setImageReq( String s) {


        queue = Volley.newRequestQueue(this);

        requestShapes = new com.android.volley.toolbox.ImageRequest(s,
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

    }



}

