package com.example.mathspuzzel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class puzzel_play_activity extends AppCompatActivity implements View.OnClickListener
{
Button button[]=new Button[10];
TextView textView,leveltext;
Button delet,submit;
String str1,temp,str;
static int levelNo=0;
ImageView imageView;
int ansArr[]={10,20,30,40,50,60,70,80,90,100,110,120,130,140,150};
ArrayList<String> imgArr=new ArrayList<>();
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
        leveltext.setText("Puzzel"+(levelNo+1));
        //
        //       InputStream ims=null;
//        try
//        {
//            // get input stream
//             ims = getAssets().open(imgArr.get(levelNo));
//            // load image as Drawable
//                Drawable d = Drawable.createFromStream(ims, null);
//            // set image to ImageView
//            imageView.setImageDrawable(d);
//
//        }
//        catch(IOException ex)
//        {
//            return;
//        }

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
            if(ansArr[levelNo]==n)
            {
                levelNo++;
                Intent intent = new Intent(puzzel_play_activity.this,Win_puzzel_activity.class);
                intent.putExtra("levelNo",levelNo);
                startActivity(intent);
            }
            else
             {
                  Toast.makeText(this, "Wrong...", Toast.LENGTH_SHORT).show();
             }
        }
    }
}
