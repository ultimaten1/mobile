package com.ultimate.b6_androidproject_btvn2_fragment_version_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.loader.content.AsyncTaskLoader;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class DownloadImageLoader extends AsyncTaskLoader<List<Bitmap>> {
    private List<String> imageUrls;

    public DownloadImageLoader(Context context, List<String> imageUrls) {
        super(context);
        this.imageUrls = imageUrls;
    }

    @Override
    public List<Bitmap> loadInBackground() {
        List<Bitmap> result = new ArrayList<>();

        try {
            for (String imageUrl : imageUrls) {
                Log.d("ImageLoader", "Loading image from URL: " + imageUrl);
                URL url = new URL(imageUrl);
                URLConnection connection = url.openConnection();
                connection.setUseCaches(true);
                InputStream inputStream = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                int resizeWidth = 700;
                int resizeHeight = 700;
                Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, resizeWidth, resizeHeight, false);

                result.add(resizedBitmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("ImageLoader", "Error loading image: " + e.getMessage());
        }

        return result;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}

