package com.example.mathspuzzel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class puzzel_play_activity extends AppCompatActivity implements View.OnClickListener
{
Button button[]=new Button[10];
TextView textView;
Button delet;
String str1;
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
        textView=findViewById(R.id.answer_txt);
        delet=findViewById(R.id.Delet_button);
        delet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(button[0].getId()==view.getId())
        {
            str1= String.valueOf(textView.getText());
            textView.setText(str1+"0");

        }
        if(button[1].getId()==view.getId())
        {
            str1= String.valueOf(textView.getText());
            textView.setText(str1+"1");

        }
        if(button[2].getId()==view.getId())
        {
            str1= String.valueOf(textView.getText());
            textView.setText(str1+"2");

        }
        if(button[3].getId()==view.getId())
        {
            str1= String.valueOf(textView.getText());
            textView.setText(str1+"3");

        }
        if(button[4].getId()==view.getId())
        {
            str1= String.valueOf(textView.getText());
            textView.setText(str1+"4");

        }
        if(button[5].getId()==view.getId())
        {
            str1= String.valueOf(textView.getText());
            textView.setText(str1+"5");

        }
        if(button[6].getId()==view.getId())
        {
            str1= String.valueOf(textView.getText());
            textView.setText(str1+"6");

        }
        if(button[7].getId()==view.getId())
        {
            str1= String.valueOf(textView.getText());
            textView.setText(str1+"7");

        }
        if(button[8].getId()==view.getId())
        {
            str1= String.valueOf(textView.getText());
            textView.setText(str1+"8");

        }
        if(button[9].getId()==view.getId())
        {
            str1= String.valueOf(textView.getText());
            textView.setText(str1+"9");

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

    }
}