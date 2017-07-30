package com.example.android.tourlink.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.android.tourlink.R;
import com.example.android.tourlink.buttom_navigation.DataGenerator;

public class RadioGroupTabActivity extends AppCompatActivity {
    private RadioGroup mRadioGroup;
    private Fragment[]mFragments;
    private RadioButton mRadioButtonHome;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group_tab);
        mFragments = DataGenerator.getFragments("RadioGroup Tab");

        toolbar = (Toolbar) findViewById(R.id.massage_toolbar);
        toolbar.inflateMenu(R.menu.message_toolbar_menu);
        toolbar.setTitle(R.string.home_page);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_search) {
                    Toast.makeText(getApplication(), R.string.menu_search, Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_add_friend) {
                    Toast.makeText(getApplication() , R.string.menu_add_friend , Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_add_group) {
                    Toast.makeText(getApplication() , R.string.menu_add_group , Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_creat_group) {
                    Toast.makeText(getApplication() , R.string.menu_creat_group , Toast.LENGTH_SHORT).show();

                }else if (menuItemId == R.id.action_rich_scan) {
                    Toast.makeText(getApplication() , R.string.menu_rich_scan , Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });

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
                        toolbar.setTitle(R.string.toolbar_title_msg);
                        break;
                    case R.id.radio_button_discovery:
                        mFragment = mFragments[1];
                        toolbar.setTitle(R.string.toolbar_title_group);
                        break;
                    case R.id.radio_button_attention:
                        mFragment = mFragments[2];
                        toolbar.setTitle(R.string.toolbar_title_funtion);
                        break;
                    case R.id.radio_button_profile:
                        mFragment = mFragments[3];
                        toolbar.setTitle(R.string.toolbar_title_my);
                        break;
                    case R.id.radio_button_circle:
                        mFragment = mFragments[4];
                        toolbar.setTitle(R.string.toolbar_title_circle);
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
