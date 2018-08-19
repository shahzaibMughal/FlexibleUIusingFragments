package com.example.shahzaib.flexibleuiusingfragments;

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

public class Fragment_One extends Fragment implements AdapterView.OnItemClickListener {


    Communicator communicator;
    ArrayAdapter adapter;
    ListView listView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_layout,container,false);
        listView = view.findViewById(R.id.listView);
        adapter = ArrayAdapter.createFromResource(getActivity(),R.array.titles,android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        return view;
    }


    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        communicator.respond(position);
    }

    public interface Communicator{
        void respond(int i);
    }
}
