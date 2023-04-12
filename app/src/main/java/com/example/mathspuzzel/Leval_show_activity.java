package com.example.mathspuzzel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class Leval_show_activity extends AppCompatActivity {
    GridView gridView;
    Button button;
     TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leval_show);
        gridView=findViewById(R.id.Leval_grid_view);
        textView=findViewById(R.id.select_puzzel);

        button=findViewById(R.id.next_button);

        Puzzel_Adapter puzzelAdapter=new Puzzel_Adapter(Leval_show_activity.this,confing.lock);
        gridView.setAdapter(puzzelAdapter);
        Typeface typeface= Typeface.createFromAsset(Leval_show_activity.this.getAssets(),confing.font);
        textView.setTypeface(typeface);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(Leval_show_activity.this, Leval_show_activity.class);
                    startActivity(intent);

            }
        });
    }
}