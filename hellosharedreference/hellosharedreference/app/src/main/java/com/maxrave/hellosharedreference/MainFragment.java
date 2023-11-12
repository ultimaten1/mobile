package com.maxrave.hellosharedreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxrave.hellosharedreference.databinding.FragmentMainBinding;


public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    SharedPreferences sharedPreferences;

    private int count = 0;
    private int countStep = 1;
    private String color = "#000000";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPreferences = requireActivity().getSharedPreferences("maxrave", Context.MODE_PRIVATE);
        initData();

        binding.btCount.setOnClickListener(v -> {
            count += countStep;
            binding.tvCount.setText(String.valueOf(count));
            saveData();
        });

        binding.btReset.setOnClickListener(v -> {
            count = 0;
            color = "#000000";
            binding.tvCount.setText(String.valueOf(count));
            binding.backgroundLayout.setBackgroundColor(Color.parseColor("#000000"));
            saveData();
        });

        binding.btBlack.setOnClickListener(v -> {
            color = "#000000";
            binding.backgroundLayout.setBackgroundColor(Color.parseColor("#000000"));
            saveData();
        });
        binding.btRed.setOnClickListener(v -> {
            color = "#ffcc0000";
            binding.backgroundLayout.setBackgroundColor(Color.parseColor("#ffcc0000"));
            saveData();
        });
        binding.btGreen.setOnClickListener(v -> {
            color = "#ff669900";
            binding.backgroundLayout.setBackgroundColor(Color.parseColor("#ff669900"));
            saveData();
        });
        binding.btBlue.setOnClickListener(v -> {
            color = "#ff0099cc";
            binding.backgroundLayout.setBackgroundColor(Color.parseColor("#ff0099cc"));
            saveData();
        });
        binding.toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.settings) {
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(R.id.action_mainFragment_to_settingsFragment);
            }
            return true;
        });
    }

    private void initData() {
        count = sharedPreferences.getInt("count", 0);
        color = sharedPreferences.getString("color", "#000000");
        countStep = sharedPreferences.getInt("countStep", 1);
        binding.tvCount.setText(String.valueOf(count));
        binding.backgroundLayout.setBackgroundColor(Color.parseColor(color));
    }
    private void saveData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count", count);
        editor.putString("color", color);
        editor.apply();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        saveData();
    }
}