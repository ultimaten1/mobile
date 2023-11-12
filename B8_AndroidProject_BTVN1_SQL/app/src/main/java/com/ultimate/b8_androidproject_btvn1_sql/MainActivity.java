package com.ultimate.b8_androidproject_btvn1_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    private GridView grvMain;
    private ArticleData data;
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Intent intent = new Intent(getBaseContext(), ViewArticleActivity.class);
            intent.putExtra("id", grvMain.getAdapter().getItemId(position));
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grvMain = findViewById(R.id.grvMain);
        data = new ArticleData(getBaseContext(), grvMain);
        data.execute();
        grvMain.setOnItemClickListener(onItemClickListener);
    }
}