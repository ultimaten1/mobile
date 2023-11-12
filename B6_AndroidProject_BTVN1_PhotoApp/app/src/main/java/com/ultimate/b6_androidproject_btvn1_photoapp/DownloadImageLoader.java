package com.ultimate.b6_androidproject_btvn1_photoapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.loader.content.AsyncTaskLoader;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadImageLoader extends AsyncTaskLoader<Bitmap> {
    private String imageUrl;

    public DownloadImageLoader(Context context, String imageUrl) {
        super(context);
        this.imageUrl = imageUrl;
    }

    @Override
    public Bitmap loadInBackground() {
        Bitmap result = null;
        Bitmap resizedResult = null;

        try {
            URL url = new URL(imageUrl);
            URLConnection connection = url.openConnection();
            connection.setUseCaches(true);
            InputStream inputStream = connection.getInputStream();
            result = BitmapFactory.decodeStream(inputStream);

            int resizeWidth = 700;
            int resizeHeight = 700;
            resizedResult = Bitmap.createScaledBitmap(result, resizeWidth, resizeHeight, false);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resizedResult;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}


