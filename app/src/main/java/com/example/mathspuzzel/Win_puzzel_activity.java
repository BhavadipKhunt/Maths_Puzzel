package com.example.mathspuzzel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Win_puzzel_activity extends AppCompatActivity implements View.OnClickListener
{
TextView textView;
Button continu,mainmenu,buypro,buy,nothanks,share1;
int n;
    List<String> arrayList=new ArrayList<>();
    ArrayList<String> imgArr=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_puzzel);
        textView=findViewById(R.id.Win_solve_number);
        n=getIntent().getIntExtra("level",0);
        textView.setText("Puzzel "+ (n-1) +" Solved");
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
            intent.putExtra("level",n);
            startActivity(intent);
            finish();
        }
        if(view.getId()==mainmenu.getId())
        {
            Intent intent=new Intent(Win_puzzel_activity.this,MainActivity.class);
            startActivity(intent);
            finish();
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
            String[] images = new String[0];
            try {
                images = getAssets().list("img/");
                imgArr = new ArrayList<String>(Arrays.asList(images));

            } catch (IOException e) {
                e.printStackTrace();
            }

            arrayList=imgArr.subList(0,74);

            InputStream inputstream = null;
            try {
                inputstream = getAssets().open("img/"+arrayList.get(confing.levelNo));
                Drawable drawable = Drawable.createFromStream(inputstream, null);
                System.out.println("input Stream="+drawable);

                inputstream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("image/jpeg");

            try {
                System.out.println("Path="+(getAssets().open("img/"+arrayList.get(confing.levelNo))));
                intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(String.valueOf(getAssets().open("img/"+arrayList.get(confing.levelNo)))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            //intent.putExtra(Intent.EXTRA_STREAM,screenshotUri);
            startActivity(Intent.createChooser(intent,"share.."));

        }
    }
}