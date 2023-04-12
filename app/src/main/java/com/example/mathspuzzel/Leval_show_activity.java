package com.example.mathspuzzel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

public class Leval_show_activity extends AppCompatActivity {
    GridView gridView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leval_show);
        gridView=findViewById(R.id.Leval_grid_view);
        button=findViewById(R.id.next_button);
        Puzzel_Adapter puzzelAdapter=new Puzzel_Adapter(Leval_show_activity.this,confing.lock,confing.puzzel);
        gridView.setAdapter(puzzelAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            int cn=0;

            @Override
            public void onClick(View view) {
                cn++;
                if (cn==1) {
                    Intent intent = new Intent(Leval_show_activity.this, Leval_show_activity.class);
                    startActivity(intent);
                }
            }
        });
    }
}