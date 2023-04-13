package com.example.mathspuzzel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Puzzel_Adapter extends BaseAdapter
{
    Context context;
    int  lock;

    ImageView textView;

    public Puzzel_Adapter(Context context, int lock) {
        this.context=context;
        this.lock=lock;

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
        textView=view.findViewById(R.id.iteam_text_view);
        textView.setImageResource(confing.lock);


        return view;
    }
}
