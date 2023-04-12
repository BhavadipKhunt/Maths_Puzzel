package com.example.mathspuzzel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
TextView textView1,textView2,textView3,textView4;
Button share,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=findViewById(R.id.puzzles_text);
        textView2=findViewById(R.id.continue_text);
        textView3=findViewById(R.id.buy_text);
        textView4=findViewById(R.id.policy_text);
        Typeface typeface= Typeface.createFromAsset(MainActivity.this.getAssets(),confing.font);

        textView1.setTypeface(typeface );
        textView2.setTypeface(typeface );
        textView3.setTypeface(typeface );
        textView4.setTypeface(typeface );
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        share=findViewById(R.id.share_Button);
        email=findViewById(R.id.Email_Button);
        share.setOnClickListener(this);
        email.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==share.getId())
        {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT,textView1.getText());
            intent.putExtra(Intent.EXTRA_SUBJECT,"Puzzel");
            startActivity(Intent.createChooser(intent,"share"));
        }
        if(view.getId()==email.getId())
        {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
           // intent.putExtra(Intent.EXTRA_EMAIL,new String[]{""});
            intent.putExtra(Intent.EXTRA_TEXT,textView1.getText());
            intent.putExtra(Intent.EXTRA_SUBJECT,"Puzzel Game");
            startActivity(Intent.createChooser(intent,"share"));

        }
        if (view.getId()==textView1.getId())
        {

        }
        if (view.getId()==textView2.getId())
        {

        }
        if (view.getId()==textView3.getId())
        {

        }
        if (view.getId()==textView4.getId())
        {

        }
    }
}