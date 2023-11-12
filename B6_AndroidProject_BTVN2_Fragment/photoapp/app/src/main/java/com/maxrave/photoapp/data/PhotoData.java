package com.maxrave.photoapp.data;

import com.maxrave.photoapp.data.model.Photo;

import java.util.ArrayList;

public class PhotoData {
    public static ArrayList<Photo> generatePhotoData() {
        ArrayList<Photo> photos = new ArrayList<>();
        photos.add(new Photo(1, "https://raw.githubusercontent.com/maxrave-dev/SimpMusic/main/asset/screenshot/miniplayer_top.jpg", "SimpMusic 1", "Miniplayer Top"));
        photos.add(new Photo(2, "https://raw.githubusercontent.com/maxrave-dev/SimpMusic/main/asset/screenshot/miniplayer_bottom.jpg", "SimpMusic 2", "Miniplayer Bottom"));
        photos.add(new Photo(3, "https://raw.githubusercontent.com/maxrave-dev/SimpMusic/main/asset/screenshot/home.jpg", "SimpMusic 3", "Home"));
        photos.add(new Photo(4, "https://raw.githubusercontent.com/maxrave-dev/SimpMusic/main/asset/screenshot/moodmoment.jpg", "SimpMusic 4", "Mood Moment"));
        photos.add(new Photo(5, "https://raw.githubusercontent.com/maxrave-dev/SimpMusic/main/asset/screenshot/chart.jpg", "SimpMusic 5", "Chart"));
        photos.add(new Photo(6, "https://raw.githubusercontent.com/maxrave-dev/SimpMusic/main/asset/screenshot/artist_top.jpg", "SimpMusic 6", "Artist Top"));
        photos.add(new Photo(7, "https://raw.githubusercontent.com/maxrave-dev/SimpMusic/main/asset/screenshot/search.jpg", "SimpMusic 7", "Search"));
        photos.add(new Photo(8, "https://raw.githubusercontent.com/maxrave-dev/SimpMusic/main/asset/screenshot/search_suggest.jpg", "SimpMusic 8", "Search Suggest"));
        photos.add(new Photo(9, "https://raw.githubusercontent.com/maxrave-dev/SimpMusic/main/asset/screenshot/search_result.jpg", "SimpMusic 9", "Search Result"));

        return photos;
    }
    public static Photo getPhotoById(int id) {
        ArrayList<Photo> photos = generatePhotoData();
        for (Photo photo : photos) {
            if (photo.getId() == id) {
                return photo;
            }
        }
        return null;
    }
}
