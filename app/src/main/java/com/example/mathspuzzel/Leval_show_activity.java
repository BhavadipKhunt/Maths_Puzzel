package com.example.mathspuzzel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class Leval_show_activity extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leval_show);
        gridView=findViewById(R.id.Leval_grid_view);
        Puzzel_Adapter puzzelAdapter=new Puzzel_Adapter(Leval_show_activity.this,confing.lock,confing.puzzel);
        gridView.setAdapter(puzzelAdapter);
    }
}