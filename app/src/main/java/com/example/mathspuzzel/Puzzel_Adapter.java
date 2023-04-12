package com.example.mathspuzzel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class Puzzel_Adapter extends BaseAdapter
{
    Context context;
    int  lock;
    int[] puzzel;

    public Puzzel_Adapter(Context context, int lock, int[] puzzel) {
        this.context=context;
        this.lock=lock;
        this.puzzel=puzzel;
    }

    @Override
    public int getCount() {
        return puzzel.length;
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
        return null;
    }
}
