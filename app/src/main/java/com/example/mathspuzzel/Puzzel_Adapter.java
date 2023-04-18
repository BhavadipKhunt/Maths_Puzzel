package com.example.mathspuzzel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Puzzel_Adapter extends BaseAdapter
{
    Context context;
    int  lock;

    ImageView imageView;
    TextView textView;
    SharedPreferences preferences;


    public Puzzel_Adapter(Context context, int lock, SharedPreferences preferences) {
        this.context=context;
        this.lock=lock;
        this.preferences=preferences;
    }

    @Override
    public int getCount() {
        return 20;
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


        int lastlevel = preferences.getInt("lastlevel",-1);
        String status= preferences.getString("levelstatus"+i,"pending");
            if (status.equals("win")) {
                imageView.setImageResource(R.drawable.tick);
                textView.setText("" + (i + 1));
                textView.setVisibility(View.VISIBLE);
            }


            if (status.equals("skip") || i == lastlevel ) {
                imageView.setImageResource(0);
                textView.setText("" + (i + 1));
                textView.setVisibility(View.VISIBLE);
            }
            if (status.equals("win") || status.equals("skip") || i == lastlevel ) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, puzzel_play_activity.class);
                        intent.putExtra("level", i);
                        context.startActivity(intent);


                    }
                });
            }

        return view;
    }
}
