package com.example.user.contactbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Contacts extends Fragment {

    View view;
    private ListView listView;
    private String[] contactNames;
    //photo are set by their index
    int[] image = {R.drawable.p3, R.drawable.p3, R.drawable.p3, R.drawable.p3,
            R.drawable.p3, R.drawable.p3, R.drawable.p3, R.drawable.p3,
            R.drawable.p3, R.drawable.p3, R.drawable.p3, R.drawable.p3,
            R.drawable.p3, R.drawable.p3, R.drawable.p3, R.drawable.p3,
            R.drawable.p3, R.drawable.p3, R.drawable.p3, R.drawable.p3,
            R.drawable.p3, R.drawable.p3, R.drawable.p3, R.drawable.p3,
            R.drawable.p3, R.drawable.p3, R.drawable.p3, R.drawable.p3,
            R.drawable.p3, R.drawable.p3,R.drawable.p3};
    public Contacts() {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.contact_layout,container, false);

        listView = view.findViewById(R.id.listViewId);
        contactNames = getResources().getStringArray(R.array.contact_names);

        //Custom adapter er kaj holo resourse theke file gulo nie view e convert kora
        CustomAdapter2 customAdapter = new CustomAdapter2(getActivity(), contactNames, image);
        listView.setAdapter(customAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String value = contactNames[i]; //which item is selected
//                Toast.makeText(getActivity(), value, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), Profile.class);
                //pass string data from one activity to another
                intent.putExtra("tag",value);
                startActivity(intent);
            }
        });

        return view;
    }
}
