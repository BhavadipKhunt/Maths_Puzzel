package com.example.mathspuzzel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class Leval_show_activity extends AppCompatActivity {
    GridView gridView;
    Button button,back;
     TextView textView;
     SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leval_show);
        gridView=findViewById(R.id.Leval_grid_view);
        textView=findViewById(R.id.select_puzzel);
        back=findViewById(R.id.back_button);
        button=findViewById(R.id.next_button);

        preferences=getSharedPreferences("mypre",MODE_PRIVATE);
        Puzzel_Adapter puzzelAdapter=new Puzzel_Adapter(Leval_show_activity.this,confing.lock);
        gridView.setAdapter(puzzelAdapter);
        Typeface typeface= Typeface.createFromAsset(Leval_show_activity.this.getAssets(),confing.font);
        textView.setTypeface(typeface);
        if (confing.cnt==1)
        {
            back.setVisibility(View.VISIBLE);
            button.setVisibility(View.GONE);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    confing.cnt--;
                    Intent intent=new Intent(Leval_show_activity.this,Leval_show_activity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view)
            {

                    Intent intent = new Intent(Leval_show_activity.this, Leval_show_activity.class);
                    confing.cnt++;
                    startActivity(intent);
                    finish();

            }
        });
    }
}