package com.example.android.tourlink.ui.fragment;

import android.support.v4.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.tourlink.R;
import com.example.android.tourlink.widget.StateButton;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AttentionFragment extends Fragment {

    private EmptyFragment emptyFragment;
    private CalendarFragment calendarFragment;
    private AnnouncementFragment announcementFragment;

    @Bind(R.id.calendar_sbtn)
    StateButton calendarSbtn;
    @Bind(R.id.all_sbtn)
    StateButton allSbtn;
    @Bind(R.id.vote_sbtn)
    StateButton voteSbtn;
    @Bind(R.id.map_sbtn)
    StateButton mapSbtn;

    @Bind(R.id.group_setting_sbtn)
    StateButton groupSettingSbtn;
    @Bind(R.id.announcement_sbtn)
    StateButton announcementSbtn;
    @Bind(R.id.weather_sbtn)
    StateButton weatherSbtn;
    @Bind(R.id.sign_in_sbtn)
    StateButton signInSbtn;

    int colorSelect;
    int colorNotSelect;

    View view;
    private String mFrom;

    public static AttentionFragment newInstance(String from) {
        AttentionFragment fragment = new AttentionFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from", from);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFrom = getArguments().getString("from");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_attention, null);
            ButterKnife.bind(this, view);
        }

        colorNotSelect = getResources().getColor(R.color.colorDivideGroup);
        colorSelect = getResources().getColor(R.color.colorPrimary);
        clearBtnColor();
        allSbtn.setNormalBackgroundColor(colorSelect);
        initEmptyFragment();
        setSbtnListener();
        return view;
    }

    private void  clearBtnColor(){
        calendarSbtn.setNormalBackgroundColor(colorNotSelect);
        allSbtn.setNormalBackgroundColor(colorNotSelect);
        voteSbtn.setNormalBackgroundColor(colorNotSelect);
        mapSbtn.setNormalBackgroundColor(colorNotSelect);

        announcementSbtn.setNormalBackgroundColor(colorNotSelect);
        groupSettingSbtn.setNormalBackgroundColor(colorNotSelect);
        weatherSbtn.setNormalBackgroundColor(colorNotSelect);
        signInSbtn.setNormalBackgroundColor(colorNotSelect);
    }

    private void setSbtnListener() {
        calendarSbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarSbtn.setNormalBackgroundColor(colorSelect);
                allSbtn.setNormalBackgroundColor(colorNotSelect);
                voteSbtn.setNormalBackgroundColor(colorNotSelect);
                mapSbtn.setNormalBackgroundColor(colorNotSelect);

                announcementSbtn.setNormalBackgroundColor(colorNotSelect);
                groupSettingSbtn.setNormalBackgroundColor(colorNotSelect);
                weatherSbtn.setNormalBackgroundColor(colorNotSelect);
                signInSbtn.setNormalBackgroundColor(colorNotSelect);

                initCalendarFragment();
            }
        });
        allSbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allSbtn.setNormalBackgroundColor(colorSelect);
                calendarSbtn.setNormalBackgroundColor(colorNotSelect);
                voteSbtn.setNormalBackgroundColor(colorNotSelect);
                mapSbtn.setNormalBackgroundColor(colorNotSelect);

                announcementSbtn.setNormalBackgroundColor(colorNotSelect);
                groupSettingSbtn.setNormalBackgroundColor(colorNotSelect);
                weatherSbtn.setNormalBackgroundColor(colorNotSelect);
                signInSbtn.setNormalBackgroundColor(colorNotSelect);
                initEmptyFragment();
            }
        });
        voteSbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voteSbtn.setNormalBackgroundColor(colorSelect);
                calendarSbtn.setNormalBackgroundColor(colorNotSelect);
                allSbtn.setNormalBackgroundColor(colorNotSelect);
                mapSbtn.setNormalBackgroundColor(colorNotSelect);

                announcementSbtn.setNormalBackgroundColor(colorNotSelect);
                groupSettingSbtn.setNormalBackgroundColor(colorNotSelect);
                weatherSbtn.setNormalBackgroundColor(colorNotSelect);
                signInSbtn.setNormalBackgroundColor(colorNotSelect);
            }
        });
        mapSbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapSbtn.setNormalBackgroundColor(colorSelect);
                calendarSbtn.setNormalBackgroundColor(colorNotSelect);
                allSbtn.setNormalBackgroundColor(colorNotSelect);
                voteSbtn.setNormalBackgroundColor(colorNotSelect);

                announcementSbtn.setNormalBackgroundColor(colorNotSelect);
                groupSettingSbtn.setNormalBackgroundColor(colorNotSelect);
                weatherSbtn.setNormalBackgroundColor(colorNotSelect);
                signInSbtn.setNormalBackgroundColor(colorNotSelect);
            }
        });

        groupSettingSbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapSbtn.setNormalBackgroundColor(colorNotSelect);
                calendarSbtn.setNormalBackgroundColor(colorNotSelect);
                allSbtn.setNormalBackgroundColor(colorNotSelect);
                voteSbtn.setNormalBackgroundColor(colorNotSelect);

                groupSettingSbtn.setNormalBackgroundColor(colorSelect);
                announcementSbtn.setNormalBackgroundColor(colorNotSelect);
                weatherSbtn.setNormalBackgroundColor(colorNotSelect);
                signInSbtn.setNormalBackgroundColor(colorNotSelect);
            }
        });
        announcementSbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapSbtn.setNormalBackgroundColor(colorNotSelect);
                calendarSbtn.setNormalBackgroundColor(colorNotSelect);
                allSbtn.setNormalBackgroundColor(colorNotSelect);
                voteSbtn.setNormalBackgroundColor(colorNotSelect);

                announcementSbtn.setNormalBackgroundColor(colorSelect);
                groupSettingSbtn.setNormalBackgroundColor(colorNotSelect);
                weatherSbtn.setNormalBackgroundColor(colorNotSelect);
                signInSbtn.setNormalBackgroundColor(colorNotSelect);

                initAnnouncementFragment();
            }
        });
        weatherSbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapSbtn.setNormalBackgroundColor(colorNotSelect);
                calendarSbtn.setNormalBackgroundColor(colorNotSelect);
                allSbtn.setNormalBackgroundColor(colorNotSelect);
                voteSbtn.setNormalBackgroundColor(colorNotSelect);

                weatherSbtn.setNormalBackgroundColor(colorSelect);
                groupSettingSbtn.setNormalBackgroundColor(colorNotSelect);
                announcementSbtn.setNormalBackgroundColor(colorNotSelect);
                signInSbtn.setNormalBackgroundColor(colorNotSelect);
            }
        });
        signInSbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapSbtn.setNormalBackgroundColor(colorNotSelect);
                calendarSbtn.setNormalBackgroundColor(colorNotSelect);
                allSbtn.setNormalBackgroundColor(colorNotSelect);
                voteSbtn.setNormalBackgroundColor(colorNotSelect);

                signInSbtn.setNormalBackgroundColor(colorSelect);
                groupSettingSbtn.setNormalBackgroundColor(colorNotSelect);
                announcementSbtn.setNormalBackgroundColor(colorNotSelect);
                weatherSbtn.setNormalBackgroundColor(colorNotSelect);
            }
        });
    }

    //显示第一个fragment
    private void initEmptyFragment(){
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(emptyFragment == null){
            emptyFragment = new EmptyFragment();
            transaction.add(R.id.fragment_menu, emptyFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(emptyFragment);

        //提交事务
        transaction.commit();
    }

    private void initCalendarFragment(){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        if(calendarFragment == null){
            calendarFragment = new CalendarFragment();
            transaction.add(R.id.fragment_menu,calendarFragment);
        }
        hideFragment(transaction);
        transaction.show(calendarFragment);
        transaction.commit();
    }

    private void initAnnouncementFragment(){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        if(announcementFragment == null){
            announcementFragment = new AnnouncementFragment();
            transaction.add(R.id.fragment_menu,announcementFragment);
        }
        hideFragment(transaction);
        transaction.show(announcementFragment);
        transaction.commit();
    }


    //隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction){
        if(emptyFragment != null){
            transaction.hide(emptyFragment);
        }
        if(calendarFragment != null){
            transaction.hide(calendarFragment);
        }
        if(announcementFragment != null){
            transaction.hide(announcementFragment);
        }
    }
}
