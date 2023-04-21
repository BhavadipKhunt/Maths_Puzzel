package com.example.mathspuzzel;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Puzzel_Adapter extends BaseAdapter
{
    Activity context;
    int  lock;

    ImageView imageView;
    TextView textView;
    SharedPreferences preferences;


    public Puzzel_Adapter(Activity context, int lock) {
        this.context=context;
        this.lock=lock;
        this.preferences= context.getSharedPreferences("mypre", MODE_PRIVATE);
    }

    @Override
    public int getCount() {
        return 24;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.leval_iteam,viewGroup,false);
        imageView=view.findViewById(R.id.iteam_text_view);
        imageView.setImageResource(confing.lock);
        Typeface typeface= Typeface.createFromAsset(context.getAssets(),confing.font);
        textView=view.findViewById(R.id.iteam_text_view1);
        textView.setTypeface(typeface);



if (confing.cnt==0) {
    int lastlevel = preferences.getInt("lastlevel",-1);
    String status= preferences.getString("levelstatus"+i,"pending");
    if (status.equals("win")) {
        imageView.setImageResource(R.drawable.tick);
        textView.setText("" + (i + 1));
        textView.setVisibility(View.VISIBLE);
    }else if (status.equals("skip") || i == lastlevel + 1) {
        imageView.setImageResource(0);
        textView.setText("" + (i + 1));
        textView.setVisibility(View.VISIBLE);
    }
    if (status.equals("win") || status.equals("skip") || i == lastlevel + 1) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, puzzel_play_activity.class);
                //intent.putExtra("SecondAttempt", i);
                intent.putExtra("level",i);
                context.startActivity(intent);
               //context.finish();

            }
        });
    }
}
        if (confing.cnt==1)
        {
            int lastlevel = preferences.getInt("lastlevel",-1);
            String status= preferences.getString("levelstatus"+(i+24),"pending");
            if (status.equals("win")) {
                imageView.setImageResource(R.drawable.tick);
                textView.setText("" + (i + 1+24));
                textView.setVisibility(View.VISIBLE);
            }else if (status.equals("skip") || i+24 == lastlevel +  1) {
                imageView.setImageResource(0);
                textView.setText("" + (i + 1+24));
                textView.setVisibility(View.VISIBLE);
            }
            if (status.equals("win") || status.equals("skip") || i+24 == lastlevel +1) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, puzzel_play_activity.class);
                        intent.putExtra("level", i+24);
                        context.startActivity(intent);
                        context.finish();

                    }
                });
            }
        }
        return view;
    }
}
