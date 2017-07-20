package com.example.android.tourlink.buttom_navigation;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.android.tourlink.R;
import com.example.android.tourlink.buttom_navigation.DataGenerator;

public class RadioGroupTabActivity extends AppCompatActivity {
    private RadioGroup mRadioGroup;
    private Fragment[]mFragments;
    private RadioButton mRadioButtonHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group_tab);
        mFragments = DataGenerator.getFragments("RadioGroup Tab");

        Toolbar toolbar = (Toolbar) findViewById(R.id.massage_toolbar);
        toolbar.inflateMenu(R.menu.message_toolbar_menu);
        toolbar.setTitle(R.string.home_page);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        initView();
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group_button);
        mRadioButtonHome = (RadioButton) findViewById(R.id.radio_button_home);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            Fragment mFragment = null;
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.radio_button_home:
                        mFragment = mFragments[0];
                        break;
                    case R.id.radio_button_discovery:
                        mFragment = mFragments[1];
                        break;
                    case R.id.radio_button_attention:
                        mFragment = mFragments[2];
                        break;
                    case R.id.radio_button_profile:
                        mFragment = mFragments[3];
                        break;
                }
                if(mFragments!=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.home_container,mFragment).commit();
                }
            }
        });
        // 保证第一次会回调OnCheckedChangeListener
        mRadioButtonHome.setChecked(true);
    }
}
