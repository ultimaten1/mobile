package com.ultimate.b6_androidproject_btvn2_fragment;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuFrag extends ListFragment {

    private IFragmentClickListener itemfragment;
    private HashMap<String, List<String>> menuImageUrlsMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_frag, container, false);
        view.setBackgroundColor(getResources().getColor(R.color.menuFragBackground));

        menuImageUrlsMap = new HashMap<>();
        menuImageUrlsMap.put("LCK", getLCKImageUrls());
        menuImageUrlsMap.put("LPL", getLPLImageUrls());
        menuImageUrlsMap.put("VCS", getVCSImageUrls());

        String[] menus = {"LCK", "LPL", "VCS"};
        ArrayAdapter<String> listadapter = new ArrayAdapter<String>(view.getContext(),
                R.layout.menu_layout, menus);
        setListAdapter(listadapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            itemfragment = (IFragmentClickListener) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (itemfragment != null) {
            String selectedMenu = (String) l.getItemAtPosition(position);
            List<String> imageUrls = menuImageUrlsMap.get(selectedMenu);
            if (imageUrls != null) {
                itemfragment.onMenuItemClick(imageUrls);
            }
        }
    }

    public interface IFragmentClickListener {
        void onMenuItemClick(List<String> imageUrls);
    }

    private List<String> getLCKImageUrls() {
        List<String> imageURLs = new ArrayList<>();
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/a/a2/T1logo_square.png/revision/latest/scale-to-width-down/123?cb=20230512040747");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/e/e3/Gen.Glogo_square.png/revision/latest/scale-to-width-down/123?cb=20210325073128");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/f/f8/KT_Rolsterlogo_square.png/revision/latest/scale-to-width-down/123?cb=20210605165230");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/7/73/Dplus_KIAlogo_square.png/revision/latest/scale-to-width-down/123?cb=20230512050104");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/a/a6/Hanwha_Life_Esportslogo_square.png/revision/latest/scale-to-width-down/123?cb=20211024145058");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/d/d3/DRXlogo_square.png/revision/latest/scale-to-width-down/123?cb=20230504052321");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/c/cf/BRIONlogo_square.png/revision/latest/scale-to-width-down/123?cb=20230518062717");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/b/b8/Nongshim_RedForcelogo_square.png/revision/latest/scale-to-width-down/123?cb=20210325081928");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/7/79/Kwangdong_Freecslogo_square.png/revision/latest/scale-to-width-down/123?cb=20221024185727");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/a/ad/Liiv_SANDBOXlogo_square.png/revision/latest/scale-to-width-down/123?cb=20210530043229");

        return imageURLs;
    }

    private List<String> getLPLImageUrls() {
        List<String> imageURLs = new ArrayList<>();
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/2/25/Anyone%27s_Legendlogo_square.png/revision/latest/scale-to-width-down/123?cb=20220111185713");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/9/91/Bilibili_Gaminglogo_square.png/revision/latest/scale-to-width-down/123?cb=20230503004120");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/5/56/EDward_Gaminglogo_square.png/revision/latest/scale-to-width-down/123?cb=20211024133123");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/b/b1/FunPlus_Phoenixlogo_square.png/revision/latest/scale-to-width-down/123?cb=20230426040632");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/e/e4/Invictus_Gaminglogo_square.png/revision/latest/scale-to-width-down/123?cb=20220121030730");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/0/00/JD_Gaminglogo_square.png/revision/latest/scale-to-width-down/123?cb=20230512083646");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/5/55/LGD_Gaminglogo_square.png/revision/latest/scale-to-width-down/123?cb=20220129015052");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/d/d5/LNG_Esportslogo_square.png/revision/latest/scale-to-width-down/123?cb=20230426041003");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/0/0d/Oh_My_Godlogo_square.png/revision/latest/scale-to-width-down/123?cb=20221227034426");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/8/87/Rare_Atomlogo_square.png/revision/latest/scale-to-width-down/123?cb=20210103142708");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/e/eb/Royal_Never_Give_Uplogo_square.png/revision/latest/scale-to-width-down/123?cb=20210521114222");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/0/0a/Team_WElogo_square.png/revision/latest/scale-to-width-down/123?cb=20210318224420");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/4/46/Top_Esportslogo_square.png/revision/latest/scale-to-width-down/123?cb=20211024130137");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/2/22/ThunderTalk_Gaminglogo_square.png/revision/latest/scale-to-width-down/123?cb=20210306231456");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/d/d6/Ultra_Primelogo_square.png/revision/latest/scale-to-width-down/123?cb=20210531063508");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/3/3d/Victory_Fivelogo_square.png/revision/latest/scale-to-width-down/123?cb=20221110080020");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/5/58/Weibo_Gaminglogo_square.png/revision/latest/scale-to-width-down/123?cb=20211122163901");

        return imageURLs;
    }

    private List<String> getVCSImageUrls() {
        List<String> imageURLs = new ArrayList<>();
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/b/bb/CERBERUS_Esports_%28Vietnamese_Team%29logo_square.png/revision/latest/scale-to-width-down/123?cb=20230526151502");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/8/8a/GAM_Esportslogo_square.png/revision/latest/scale-to-width-down/123?cb=20210808114459");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/b/b0/MGN_Box_Esportslogo_square.png/revision/latest/scale-to-width-down/123?cb=20230224121533");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/4/44/Saigon_Buffalologo_square.png/revision/latest/scale-to-width-down/123?cb=20230210063638");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/8/8c/SBTC_Esportslogo_square.png/revision/latest/scale-to-width-down/123?cb=20220618073617");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/0/04/Team_Flashlogo_square.png/revision/latest/scale-to-width-down/123?cb=20230521222958");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/c/cf/Team_Secret_%28Vietnamese_Team%29logo_square.png/revision/latest/scale-to-width-down/123?cb=20210315172131");
        imageURLs.add("https://static.wikia.nocookie.net/lolesports_gamepedia_en/images/a/a8/Team_Whaleslogo_square.png/revision/latest/scale-to-width-down/123?cb=20230228061118");

        return imageURLs;
    }
}




