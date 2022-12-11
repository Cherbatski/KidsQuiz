package com.example.volleyproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button bColor,btnQuiz, bFormes, bAnimal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setTitle("kidsQuiz");
        bColor=findViewById(R.id.colorsquiz);
        bFormes=findViewById(R.id.shapes);
        bAnimal=findViewById(R.id.animal);


       bColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this, colorActivity.class);
                startActivity(intent);

            }
        });

        bFormes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, formActivity.class);
                startActivity(intent);

            }
        });

  bAnimal.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          Intent intent=new Intent(MainActivity.this, AnimalActivity.class);
          startActivity(intent);
      }
  });


    }

}
