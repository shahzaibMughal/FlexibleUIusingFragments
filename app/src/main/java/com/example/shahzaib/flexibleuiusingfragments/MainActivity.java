package com.example.shahzaib.flexibleuiusingfragments;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment_One.Communicator {

    Fragment_One fragment_one;
    Fragment_Two fragment_two;
    FragmentManager fragmentManager;
    boolean isLayoutInLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        fragment_one = (Fragment_One) fragmentManager.findFragmentById(R.id.fragmentOne);
        fragment_two = (Fragment_Two) fragmentManager.findFragmentById(R.id.fragmentTwo);

        fragment_one.setCommunicator(this);

        isLayoutInLandscape = fragment_two != null;

        Toast.makeText(this, "Layout is in landscape = " + isLayoutInLandscape, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void respond(int clickedItemIndex) {
        if (isLayoutInLandscape) {
            if (fragment_two.isVisible()) {
                fragment_two.changeData(clickedItemIndex);
            }
            else
            {
                Toast.makeText(this, "Fragment is not visible", Toast.LENGTH_SHORT).show();
            }
        } else {
            Intent detailActivityIntent = new Intent(this, detail_activity.class);
            detailActivityIntent.putExtra(detail_activity.KEY_INTENT_CLICKED_ITEM_INDEX, clickedItemIndex);
            startActivity(detailActivityIntent);
        }
    }
}
