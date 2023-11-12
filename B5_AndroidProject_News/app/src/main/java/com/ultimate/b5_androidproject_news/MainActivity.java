package com.ultimate.b5_androidproject_news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvTitle;
    private NewsAdapter newsAdapter;
    private List<NewsItem> newsItemList;
    private NewsItem selectedNewsItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvTitle = findViewById(R.id.rcvTitle);
        rcvTitle.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        newsItemList = new ArrayList<>();
        AddNews();

        newsAdapter = new NewsAdapter(MainActivity.this, newsItemList);
        rcvTitle.setAdapter(newsAdapter);

        OnClickItemLister();
    }

    private void OnClickItemLister() {
        newsAdapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedNewsItem = newsItemList.get(position);
                Intent intent = new Intent(MainActivity.this, DetailsNews_Activity.class);
                intent.putExtra("photoUrl", selectedNewsItem.getPhotoUrl());
                intent.putExtra("title", selectedNewsItem.getTitle());
                intent.putExtra("description", selectedNewsItem.getDescription());
                startActivity(intent);
            }
        });
    }

    private void AddNews() {
        newsItemList.add(new NewsItem("https://vtv1.mediacdn.vn/zoom/490_306/562122370168008704/2023/9/10/photo1694337912238-16943379124641951713063.jpg",
                "Tổng thống Hoa Kỳ Joe Biden đến Hà Nội, bắt đầu chuyến thăm cấp Nhà nước tới Việt Nam",
                "VTV.vn - Tổng thống Hoa Kỳ Joe Biden đã tới sân bay quốc tế Nội Bài, bắt đầu chuyến thăm cấp Nhà nước tới Việt Nam từ ngày 10 đến ngày 11/9/2023."
        ));
        newsItemList.add(new NewsItem("https://vtv1.mediacdn.vn/zoom/256_159/562122370168008704/2023/9/10/photo1694311530018-1694311530496187357807.jpg",
                "Đội tuyển Đức thua sốc Nhật Bản trong trận giao hữu",
                "VTV.vn - Ở trận giao hữu diễn ra vào rạng sáng nay (10/9), đội tuyển Nhật Bản tiếp tục gieo sầu cho ĐT Đức trong cuộc tái đấu giữa hai đội kể từ vòng bảng World Cup 2022."
        ));
        newsItemList.add(new NewsItem("https://vtv1.mediacdn.vn/zoom/256_159/562122370168008704/2023/9/10/photo1694308615456-16943086159271233091698.jpg",
                "Antony rớt nước mắt, phủ nhận đánh đập bạn gái",
                "VTV.vn - Tiền đạo Antony đã không được triệu tập lên đội tuyển Brazil ở lần hội quân lần này sau những rắc rối bên ngoài sân cỏ."
        ));
        newsItemList.add(new NewsItem("https://vtv1.mediacdn.vn/zoom/256_159/562122370168008704/2023/9/10/photo1694308615456-16943086159271233091698.jpg",
                "Antony rớt nước mắt, phủ nhận đánh đập bạn gái",
                "VTV.vn - Tiền đạo Antony đã không được triệu tập lên đội tuyển Brazil ở lần hội quân lần này sau những rắc rối bên ngoài sân cỏ."
        ));
        newsItemList.add(new NewsItem("https://vtv1.mediacdn.vn/zoom/256_159/562122370168008704/2023/9/10/photo1694308615456-16943086159271233091698.jpg",
                "Antony rớt nước mắt, phủ nhận đánh đập bạn gái",
                "VTV.vn - Tiền đạo Antony đã không được triệu tập lên đội tuyển Brazil ở lần hội quân lần này sau những rắc rối bên ngoài sân cỏ."
        ));
    }
}