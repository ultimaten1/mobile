package com.maxrave.hellosharedreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.maxrave.hellosharedreference.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;

    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        sharedPreferences = requireActivity().getSharedPreferences("maxrave", Context.MODE_PRIVATE);
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] colors = {"#000000", "#ffcc0000", "#ff669900", "#ff0099cc"};
        CharSequence[] charSequences = {"Black", "Red", "Green", "Blue"};
        int countStep = sharedPreferences.getInt("countStep", 1);
        int countNumber = sharedPreferences.getInt("count", 0);
        String color = sharedPreferences.getString("color", "#000000");
        binding.tvColor.setText(getColorNameFromString(color, charSequences, colors));
        binding.tvCountStep.setText(String.valueOf(countStep));
        binding.tvNumber.setText(String.valueOf(countNumber));
        binding.toolbar.setNavigationOnClickListener(v ->
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(R.id.action_settingsFragment_to_mainFragment));
        binding.btCountStep.setOnClickListener(v -> {
            final TextInputEditText edittext = new TextInputEditText(requireContext());
            edittext.setInputType(InputType.TYPE_CLASS_NUMBER);
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext());
            builder.setTitle("Count Step");
            builder.setMessage("Enter Count Step");
            builder.setView(edittext);
            builder.setPositiveButton("OK", (dialog, which) -> {
                int count = Integer.parseInt(edittext.getText().toString());
                binding.tvCountStep.setText(String.valueOf(count));
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("countStep", count);
                editor.apply();
            });
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
            builder.setCancelable(true);
            builder.create();
            builder.show();
        });
        binding.btChangeNumber.setOnClickListener(v -> {
            final TextInputEditText edittext = new TextInputEditText(requireContext());
            edittext.setInputType(InputType.TYPE_CLASS_NUMBER);
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext());
            builder.setTitle("Change Number");
            builder.setView(edittext);
            builder.setPositiveButton("OK", (dialog, which) -> {
                int count = Integer.parseInt(edittext.getText().toString());
                binding.tvNumber.setText(String.valueOf(count));
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("count", count);
                editor.apply();
            });
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
            builder.setCancelable(true);
            builder.create();
            builder.show();
        });
        binding.btColor.setOnClickListener(v ->{
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext());
            builder.setTitle("Color");
            builder.setSingleChoiceItems(charSequences, -1, (dialog, which) -> {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("color", colors[which]);
                editor.apply();
                binding.tvColor.setText(getColorNameFromString(colors[which], charSequences, colors));
                dialog.dismiss();
            });
            builder.setNegativeButton("Cancel", (dialog, which) -> {
                dialog.dismiss();
            });
            builder.create();
            builder.show();
        });
    }
    private static String getColorNameFromString(String color, CharSequence[] name, String[] hex) {
        int index = 0;
        for (int i = 0; i < hex.length; i++) {
            if (color.equals(hex[i])) {
                index = i;
                break;
            }
        }
        return name[index].toString() ;
    }
}