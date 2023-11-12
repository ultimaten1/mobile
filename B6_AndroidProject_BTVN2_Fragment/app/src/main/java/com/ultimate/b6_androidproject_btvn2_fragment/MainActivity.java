package com.ultimate.b6_androidproject_btvn2_fragment;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MenuFrag.IFragmentClickListener {

    private ContentFrag contentFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentFrag = (ContentFrag) getFragmentManager().findFragmentById(R.id.ContentFrag);
    }

    @Override
    public void onMenuItemClick(List<String> imageUrls) {
        if (contentFrag != null) {
            contentFrag.updateContent(imageUrls);
        }
    }
}



