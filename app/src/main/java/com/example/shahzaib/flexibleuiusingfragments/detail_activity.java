package com.example.shahzaib.flexibleuiusingfragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class detail_activity extends AppCompatActivity {

    public static final String KEY_INTENT_CLICKED_ITEM_INDEX = "clickedItemIndex";
    Fragment_Two fragment_two;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity);
        int indexReceived = getIntent().getIntExtra(KEY_INTENT_CLICKED_ITEM_INDEX,0);
        if(indexReceived == 0) return;


        fragmentManager = getSupportFragmentManager();
        fragment_two = (Fragment_Two) fragmentManager.findFragmentById(R.id.fragmentTwo);
        fragment_two.changeData(indexReceived);



    }
}
