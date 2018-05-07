package com.example.daehee.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    ArrayList<profile> f3 = new ArrayList<profile>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListView 로 카카오톡 만들기
        //    1. 다량의 데이터
        //    2. Adapter (데이터와 view의 연결 관계를 정의)
        //    3. AdapterView (ListView)
        profile fx = new profile();
        fx.img = R.drawable.profile_1;
        fx.name = "default";
        fx.text = "default";
        f3.add(fx);
        f3.add(new profile(R.drawable.profile_1,"강진영","오늘도 즐거운 하루"));
        f3.add(new profile(R.drawable.profile_1,"나얼짱","우울한 하루"));
        f3.add(new profile(R.drawable.profile_1,"다영이","힘찬 내일을 향해"));
        f3.add(new profile(R.drawable.profile_3,"마동석","마! 따라온나!"));
        f3.add(new profile(R.drawable.profile_4,"이선희","내 꿈은 가수"));
        f3.add(new profile(R.drawable.profile_5,"장동건","잘생기고 싶다"));
        f3.add(new profile(R.drawable.profile_6,"차태현","배우 차태현입니다."));
        f3.add(new profile(R.drawable.profile_7,"하정우","먹방같은 하루"));

        // adapter
        KakaoAdapter adapter3 = new KakaoAdapter(getApplicationContext(), R.layout.profile_xml, f3);

        ListView lv3 = (ListView)findViewById(R.id.listView3);
        lv3.setAdapter(adapter3);

    } // end of onCreate
} // end of class

class KakaoAdapter extends BaseAdapter {
    Context context;     // 현재 화면의 제어권자
    int layout;             // 한행을 그려줄 layout
    ArrayList<profile> al;     // 다량의 데이터
    LayoutInflater inf; // 화면을 그려줄 때 필요
    public KakaoAdapter(Context context, int layout, ArrayList<profile> al) {
        this.context = context;
        this.layout = layout;
        this.al = al;
        this.inf = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() { // 총 데이터의 개수를 리턴
        return al.size();
    }
    @Override
    public Object getItem(int position) { // 해당번째의 데이터 값
        return al.get(position);
    }
    @Override
    public long getItemId(int position) { // 해당번째의 고유한 id 값
        return position;
    }
    @Override // 해당번째의 행에 내용을 셋팅(데이터와 레이아웃의 연결관계 정의)
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inf.inflate(layout, null);

        ImageView pv = (ImageView)convertView.findViewById(R.id.ProfileView);
        TextView pn=(TextView)convertView.findViewById(R.id.ProfileName);
        TextView pt =(TextView)convertView.findViewById(R.id.ProfileText);

        profile m = al.get(position);

        pv.setImageResource(m.img);
        pn.setText(m.name);
        pt.setText(m.text);
        return convertView;
    }
}

class profile { // 자바 빈 (java Bean)
    int img; // 사진 - res/drawable
    String name = "";
    String text = "";

    // 생성자가 있으면 객체 생성시 편리하다
    public profile(int img, String name, String text) {
        this.img = img;
        this.name = name;
        this.text = text;
    }
    public profile() {}// 기존 코드와 호환을 위해서 생성자 작업시 기본생성자도 추가
}

