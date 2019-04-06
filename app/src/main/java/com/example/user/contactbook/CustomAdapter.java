package com.example.user.contactbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    int[] image;
    String[] contactNames;
    Context context;

    //kuno XML file k View e nite gele Inflater Use korte hoy
    private LayoutInflater inflater;


    //data receive
    CustomAdapter(Context context, String[] contactNames, int[] image){

        this.context = context;
        this.contactNames = contactNames;
        this.image = image;
    }


    @Override //return korbe total number of item
    public int getCount() {
        return contactNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override//item view er xml k view te convert korbe and pass korbe
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //layout view e convert kore view te rakha hoise
            view = inflater.inflate(R.layout.item_view_layout, viewGroup, false);
        }

        ImageView imageView = view.findViewById(R.id.imageViewId);
        TextView textView = view.findViewById(R.id.contactNameId);

        imageView.setImageResource(image[i]);
        textView.setText(contactNames[i]);

        return view;
    }
}
