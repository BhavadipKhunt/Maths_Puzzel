package com.example.mathspuzzel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Win_puzzel_activity extends AppCompatActivity implements View.OnClickListener
{
TextView textView;
Button continu,mainmenu,buypro,buy,nothanks,share1;
int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_puzzel);
        textView=findViewById(R.id.Win_solve_number);
        n=getIntent().getIntExtra("levelNo",0);
        textView.setText("Puzzel "+ n +" Solved");
        continu=findViewById(R.id.Continue_button);
        mainmenu=findViewById(R.id.Main_menu_button);
        buypro=findViewById(R.id.Buy_pro_button);
        share1=findViewById(R.id.share_button_1);
        share1.setOnClickListener(this);
        continu.setOnClickListener(this);
        mainmenu.setOnClickListener(this);
        buypro.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==continu.getId())
        {
            Intent intent=new Intent(Win_puzzel_activity.this,puzzel_play_activity.class);
            startActivity(intent);
        }
        if(view.getId()==mainmenu.getId())
        {
            Intent intent=new Intent(Win_puzzel_activity.this,MainActivity.class);
            startActivity(intent);
        }
        if (view.getId()==buypro.getId())
        {
            BottomSheetDialog dialog=new BottomSheetDialog(this);
            dialog.setContentView(R.layout.buy_pro_layaout);
            buy=dialog.findViewById(R.id.buy_button);
            nothanks=dialog.findViewById(R.id.nothanks_button);
            dialog.show();
            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.cancel();
                }
            });
            nothanks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.cancel();
                }
            });
        }
        if (view.getId()==share1.getId())
        {

        }
    }
}