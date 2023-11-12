package com.ultimate.b6_androidproject_btvn2_fragment_version_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MenuFrag.IFragmentClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onMenuItemClick(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        ContentFrag contentFrag = (ContentFrag) fragmentManager.findFragmentByTag("ContentFrag");

        if (contentFrag != null) {
            contentFrag.updatePosition(position);
        }
    }

}