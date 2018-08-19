package com.example.shahzaib.flexibleuiusingfragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment_Two extends Fragment{

    TextView descriptionTV;
    String[] description_array;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_two_layout,container,false);
        descriptionTV = view.findViewById(R.id.descriptionTV);
        description_array = getResources().getStringArray(R.array.descriptions);


        return view;
    }

    public void changeData(int i)
    {
        descriptionTV.setText(description_array[i]);
        Toast.makeText(getContext(), "Data Successfully Changed", Toast.LENGTH_SHORT).show();
    }
}
