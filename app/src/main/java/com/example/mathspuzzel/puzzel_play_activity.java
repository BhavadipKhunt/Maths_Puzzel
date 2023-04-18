package com.example.mathspuzzel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class puzzel_play_activity extends AppCompatActivity implements View.OnClickListener
{
Button button[]=new Button[10];
TextView textView,leveltext;
Button delet,submit;
String str1,temp,str;

ImageView imageView;
List<String> arrayList = new ArrayList<>();
ArrayList<String> imgArr=new ArrayList<>();
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    int level;
int ansArr[]={10,20,30,40,50,60,70,80,90,100,110,120,130,140,150};
    private int lastLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzel_play);
        for (int i=0;i< button.length;i++)
        {
            int id=getResources().getIdentifier("btn"+i,"id",getPackageName());
            button[i]=findViewById(id);
            button[i].setOnClickListener(this);
        }
        leveltext=findViewById(R.id.level_show_text);

        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.answer_txt);
        delet=findViewById(R.id.Delet_button);
       submit=findViewById(R.id.submit_button);
       submit.setOnClickListener(this);
        delet.setOnClickListener(this);

        preferences=getSharedPreferences("mypre",MODE_PRIVATE);
        editor=preferences.edit();
        lastLevel=preferences.getInt("lastlevel",0);
        System.out.println(getIntent().getExtras()==null);

        if(getIntent().getExtras()==null) {
            level = 0;
        }
        else
        {
            level=getIntent().getIntExtra("level",0);
            System.out.println("---"+level);
        }

        leveltext.setText("Puzzel "+(level));
        String[] images = new String[0];
        try {
            images = getAssets().list("images/");
            imgArr = new ArrayList<String>(Arrays.asList(images));

        } catch (IOException e) {
            e.printStackTrace();
        }
        arrayList = imgArr.subList(3,77);


        InputStream inputstream = null;
        try {
            inputstream = getAssets().open("images/"+arrayList.get(lastLevel));
            Drawable drawable = Drawable.createFromStream(inputstream, null);
            System.out.println("input Stream="+drawable);
            imageView.setImageDrawable(drawable);
            inputstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View view)
    {
        for(int i=0;i<button.length;i++)
        {
            if(button[i].getId()==view.getId())
            {
                str1= textView.getText().toString();
                temp=str1+i;
                textView.setText(temp);
            }
        }

        if (view.getId()==delet.getId())
        {
            str1= String.valueOf(textView.getText());
            int n=str1.length()-1;
            if (n>=0) {
                String s = str1.substring(0, n);

            textView.setText(""+s);
            }
        }
        if (view.getId()==submit.getId())
        {
            str= String.valueOf(textView.getText());
            int n= Integer.parseInt(str);
            if(ansArr[level-1]==n)
            {
                level++;
                editor.putInt("lastlevel",level);
                editor.putString("levelstatus",level +"win");
                System.out.println(level);
                editor.commit();
                Intent intent = new Intent(puzzel_play_activity.this,Win_puzzel_activity.class);
                intent.putExtra("level",level);
                startActivity(intent);
                finish();
            }
            else
             {
                 AlertDialog.Builder builder = new AlertDialog.Builder(this);
                 builder.setMessage("Wrong....");
                 builder.show();
             }
        }
    }
}
