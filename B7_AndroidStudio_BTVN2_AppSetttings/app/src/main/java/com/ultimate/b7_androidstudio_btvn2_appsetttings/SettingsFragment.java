package com.ultimate.b7_androidstudio_btvn2_appsetttings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreferenceCompat;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        saveColorAndCount();
        setCount();
        setSelectedColor();
    }

    public void setSelectedColor() {
        ListPreference colorPreference = findPreference("color_preference_xml");
        if (colorPreference != null) {
            colorPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    setMyBackgroundColor(newValue);
                    Log.d("PreferenceChange", "Color preference changed: " + newValue.toString());
                    return true;
                }
            });
        }
    }

    public void setMyBackgroundColor(Object newValue) {
        if (newValue != null && !newValue.toString().isEmpty()) {
            String selectedColorName = (String) newValue; // Lấy tên màu từ giá trị mới

            int selectedColor = R.color.colorPrimary; // Màu mặc định nếu không khớp với tên màu

            switch (selectedColorName) {
                case "Black":
                    selectedColor = R.color.black;
                    break;
                case "Red":
                    selectedColor = R.color.red;
                    break;
                case "Blue":
                    selectedColor = R.color.blue;
                    break;
                case "Green":
                    selectedColor = R.color.green;
                    break;
            }

            // Cập nhật màu của txtResult
            TextView txtResult = getActivity().findViewById(R.id.txtResult);
            if (txtResult == null) {
                txtResult.setText("0");
                txtResult.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            else {
                int selectColor = PreferenceManager.getDefaultSharedPreferences(getContext()).getInt("color_preference", getResources().getColor(R.color.colorPrimary));
                int count = PreferenceManager.getDefaultSharedPreferences(getContext()).getInt("count", 0);
                txtResult.setBackgroundColor(selectColor);
                txtResult.setText(String.valueOf(count));
            }

            int color = ContextCompat.getColor(getContext(), selectedColor);
            txtResult.setBackgroundColor(color);

            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
            editor.putInt("color_preference", ContextCompat.getColor(getContext(), selectedColor));
            editor.apply();
        } else {
            // Xử lý khi giá trị newValue rỗng
            // Ví dụ: bạn có thể thiết lập một màu mặc định ở đây
        }
    }


    public void setCount() {
        EditTextPreference countPreference = findPreference("count_preference");
        if (countPreference != null) {
            countPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    int count = Integer.parseInt(newValue.toString().trim());
                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
                    editor.putInt("count", count);
                    editor.apply();
                    return true;
                }
            });
        }
    }


    public void saveColorAndCount() {
        SwitchPreferenceCompat savePreferenceSwitch = findPreference("save_preference_key");

        if (savePreferenceSwitch != null) {
            savePreferenceSwitch.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    boolean enableFeature = (boolean) newValue;

                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
                    editor.putBoolean("enable_feature", enableFeature);
                    editor.apply();

                    if (getActivity() != null) {
                        TextView txtResult = getActivity().findViewById(R.id.txtResult);
                        if (txtResult != null) {
                            if (enableFeature) {
                                int selectedColor = PreferenceManager.getDefaultSharedPreferences(getContext()).getInt("color_preference", getResources().getColor(R.color.colorPrimary));
                                int count = PreferenceManager.getDefaultSharedPreferences(getContext()).getInt("count", 0);
                                txtResult.setBackgroundColor(selectedColor);
                                txtResult.setText(String.valueOf(count));
                            } else {
                                editor.remove("count");
                                editor.remove("color_preference");
                                editor.apply();

                                int count = 0;
                                txtResult.setText(String.valueOf(count));
                                int defaultColor = getResources().getColor(R.color.colorPrimary);
                                txtResult.setBackgroundColor(defaultColor);
                            }
                        }
                    }

                    return true;
                }
            });
        }
    }
}

