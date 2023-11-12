package com.example.hellosharedprefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

public class SettingsFragment extends PreferenceFragmentCompat
        implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        // Đăng ký một trình nghe để theo dõi sự thay đổi trong cài đặt
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        // Xử lý sự thay đổi trong cài đặt ở đây
        if (key.equals("background_color_preference")) {
            // Lấy giá trị cài đặt màu nền mới
            String newBackgroundColor = sharedPreferences.getString(key, "#FFFFFF"); // Giá trị mặc định là trắng

            // Lưu giá trị màu nền vào SharedPreferences của MainActivity
            SharedPreferences mainActivityPreferences = getActivity().getSharedPreferences("MainActivityPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = mainActivityPreferences.edit();
            editor.putString("background_color", newBackgroundColor);
            editor.apply();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Hủy đăng ký trình nghe sự thay đổi cài đặt để tránh rò rỉ bộ nhớ
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }
}

