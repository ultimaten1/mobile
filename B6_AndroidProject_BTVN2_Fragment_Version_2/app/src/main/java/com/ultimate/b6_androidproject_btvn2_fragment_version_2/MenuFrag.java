package com.ultimate.b6_androidproject_btvn2_fragment_version_2;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuFrag extends ListFragment {
    private String[] menus = {"LCK", "LPL", "VCS"};
    private ListView listView;
    private IFragmentClickListener itemFragment;

    ListView list;
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (itemFragment != null) {
                itemFragment.onMenuItemClick(position);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.menu_frag, container, false);
        listView = view.findViewById(android.R.id.list);

        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(view.getContext(), R.layout.menu_layout, (new ArrayList<>(Arrays.asList(menus))));
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(onItemClickListener);

        return view;
    }

    public interface IFragmentClickListener {
        public void onMenuItemClick(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            itemFragment = (IFragmentClickListener) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }
}