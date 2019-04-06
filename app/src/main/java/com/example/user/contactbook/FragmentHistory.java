package com.example.user.contactbook;

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

public class FragmentHistory extends Fragment {

    View view;
    public FragmentHistory() {
    }

    private ListView listView2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.call_history_layout, container, false);

        listView2 = view.findViewById(R.id.callhistory_listViewId);

        //at first, get all item name from string array
        final String[] callhistory = getResources().getStringArray(R.array.call_history);

        //make adapter: use array adapter for only  item <data type> = (from which class, data from which layout, textid, string name)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.callhistory_item_view_layout, R.id.historyId, callhistory);
        //show all item in view by using adapter(arrayadapter-> single list adapter)
        listView2.setAdapter(adapter);

        return view;
    }
}
