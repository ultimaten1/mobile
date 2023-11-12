package com.ultimate.b6_androidproject_btvn2_fragment_version_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import java.util.ArrayList;
import java.util.List;

public class ContentFrag extends Fragment implements LoaderManager.LoaderCallbacks<List<Bitmap>> {
    private GridView gridView;
    private ImageAdapter imageAdapter;
    private int position = 0; // Vị trí được chọn từ MenuFrag

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_frag, container, false);
        gridView = view.findViewById(R.id.gridview);
        imageAdapter = new ImageAdapter(requireContext());
        gridView.setAdapter(imageAdapter);

        getLoaderManager().initLoader(0, null, this);

        return view;
    }

    public void updatePosition(int position) {
        this.position = position;
        getLoaderManager().restartLoader(0, null, this);
    }


    @NonNull
    @Override
    public Loader<List<Bitmap>> onCreateLoader(int id, @Nullable Bundle args) {
        List<String> imageUrls = getImageUrlsForMenuPosition(position);
        return new DownloadImageLoader(requireContext(), imageUrls);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Bitmap>> loader, List<Bitmap> data) {
        imageAdapter.setImages(data);
        imageAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Bitmap>> loader) {
        // Điều chỉnh lại trạng thái loader nếu cần
    }

    // Thay thế bằng logic để lấy danh sách URL ảnh từ LCK hoặc LPL tùy vào giá trị của position
    private List<String> getImageUrlsForMenuPosition(int position) {
        List<String> imageUrls = new ArrayList<>();

        if (position == 0) {
            // LCK
            imageUrls.clear();
            imageUrls.addAll(getLCKImageUrls());
        } else if (position == 1) {
            // LPL
            imageUrls.clear();
            imageUrls.addAll(getLPLImageUrls());
        } else if (position == 2) {
            // VCS
            imageUrls.clear();
            imageUrls.addAll(getVCSImageUrls());
        }

        return imageUrls;
    }


    // Thay thế bằng logic để lấy danh sách URL ảnh từ LCK
    private List<String> getLCKImageUrls() {
        List<String> lckImageUrls = new ArrayList<>();
        lckImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/a/a2/T1logo_square.png/revision/latest/scale-to-width-down/123?cb=20230512040747");
        lckImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/e/e3/Gen.Glogo_square.png/revision/latest/scale-to-width-down/123?cb=20210325073128");
        lckImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/f/f8/KT_Rolsterlogo_square.png/revision/latest/scale-to-width-down/123?cb=20210605165230");
        lckImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/7/73/Dplus_KIAlogo_square.png/revision/latest/scale-to-width-down/123?cb=20230512050104");
        lckImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/a/a6/Hanwha_Life_Esportslogo_square.png/revision/latest/scale-to-width-down/123?cb=20211024145058");
        lckImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/d/d3/DRXlogo_square.png/revision/latest/scale-to-width-down/123?cb=20230504052321");
        lckImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/c/cf/BRIONlogo_square.png/revision/latest/scale-to-width-down/123?cb=20230518062717");
        lckImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/b/b8/Nongshim_RedForcelogo_square.png/revision/latest/scale-to-width-down/123?cb=20210325081928");
        lckImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/7/79/Kwangdong_Freecslogo_square.png/revision/latest/scale-to-width-down/123?cb=20221024185727");
        lckImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/a/ad/Liiv_SANDBOXlogo_square.png/revision/latest/scale-to-width-down/123?cb=20210530043229");

        return lckImageUrls;
    }

    // Thay thế bằng logic để lấy danh sách URL ảnh từ LPL
    private List<String> getLPLImageUrls() {
        List<String> lplImageUrls = new ArrayList<>();
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/2/25/Anyone%27s_Legendlogo_square.png/revision/latest/scale-to-width-down/123?cb=20220111185713");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/9/91/Bilibili_Gaminglogo_square.png/revision/latest/scale-to-width-down/123?cb=20230503004120");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/5/56/EDward_Gaminglogo_square.png/revision/latest/scale-to-width-down/123?cb=20211024133123");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/b/b1/FunPlus_Phoenixlogo_square.png/revision/latest/scale-to-width-down/123?cb=20230426040632");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/e/e4/Invictus_Gaminglogo_square.png/revision/latest/scale-to-width-down/123?cb=20220121030730");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/0/00/JD_Gaminglogo_square.png/revision/latest/scale-to-width-down/123?cb=20230512083646");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/5/55/LGD_Gaminglogo_square.png/revision/latest/scale-to-width-down/123?cb=20220129015052");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/d/d5/LNG_Esportslogo_square.png/revision/latest/scale-to-width-down/123?cb=20230426041003");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/0/0d/Oh_My_Godlogo_square.png/revision/latest/scale-to-width-down/123?cb=20221227034426");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/8/87/Rare_Atomlogo_square.png/revision/latest/scale-to-width-down/123?cb=20210103142708");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/e/eb/Royal_Never_Give_Uplogo_square.png/revision/latest/scale-to-width-down/123?cb=20210521114222");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/0/0a/Team_WElogo_square.png/revision/latest/scale-to-width-down/123?cb=20210318224420");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/4/46/Top_Esportslogo_square.png/revision/latest/scale-to-width-down/123?cb=20211024130137");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/2/22/ThunderTalk_Gaminglogo_square.png/revision/latest/scale-to-width-down/123?cb=20210306231456");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/d/d6/Ultra_Primelogo_square.png/revision/latest/scale-to-width-down/123?cb=20210531063508");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/3/3d/Victory_Fivelogo_square.png/revision/latest/scale-to-width-down/123?cb=20221110080020");
        lplImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/5/58/Weibo_Gaminglogo_square.png/revision/latest/scale-to-width-down/123?cb=20211122163901");

        return lplImageUrls;
    }
    private List<String> getVCSImageUrls() {
        List<String> vcsImageUrls = new ArrayList<>();
        vcsImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/b/bb/CERBERUS_Esports_%28Vietnamese_Team%29logo_square.png/revision/latest/scale-to-width-down/123?cb=20230526151502");
        vcsImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/8/8a/GAM_Esportslogo_square.png/revision/latest/scale-to-width-down/123?cb=20210808114459");
        vcsImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/b/b0/MGN_Box_Esportslogo_square.png/revision/latest/scale-to-width-down/123?cb=20230224121533");
        vcsImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/4/44/Saigon_Buffalologo_square.png/revision/latest/scale-to-width-down/123?cb=20230210063638");
        vcsImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/8/8c/SBTC_Esportslogo_square.png/revision/latest/scale-to-width-down/123?cb=20220618073617");
        vcsImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/0/04/Team_Flashlogo_square.png/revision/latest/scale-to-width-down/123?cb=20230521222958");
        vcsImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/c/cf/Team_Secret_%28Vietnamese_Team%29logo_square.png/revision/latest/scale-to-width-down/123?cb=20210315172131");
        vcsImageUrls.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/a/a8/Team_Whaleslogo_square.png/revision/latest/scale-to-width-down/123?cb=20230228061118");

        return vcsImageUrls;
    }

}