package com.ultimate.b6_androidproject_btvn2_fragment;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ContentFrag extends Fragment {

    private GridView gridview;
    private GridAdapter gridAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_frag, container, false);
        view.setBackgroundColor(getResources().getColor(R.color.contentFragBackground));

        gridview = view.findViewById(R.id.gridview);
        gridAdapter = new GridAdapter();
        gridview.setAdapter(gridAdapter);
        return view;
    }

    public void updateContent(List<String> imageUrls) {
        new DownloadImagesTask().execute(imageUrls);
    }

    public class DownloadImagesTask extends AsyncTask<List<String>, Void, List<Bitmap>> {

        @Override
        protected List<Bitmap> doInBackground(List<String>... params) {
            List<String> imageUrls = params[0];

            try {
                List<Bitmap> bitmaps = new ArrayList<>();
                for (String imageUrl : imageUrls) {
                    URL url = new URL(imageUrl);
                    InputStream inputStream = url.openStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    bitmaps.add(bitmap);
                }
                return bitmaps;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Bitmap> bitmaps) {
            gridAdapter.setImages(bitmaps);
        }
    }
}






