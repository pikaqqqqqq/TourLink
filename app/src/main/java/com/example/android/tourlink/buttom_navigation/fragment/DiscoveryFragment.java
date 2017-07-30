package com.example.android.tourlink.buttom_navigation.fragment;

import android.app.LauncherActivity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.tourlink.R;
import com.lucasurbas.listitemview.ListItemView;


public class DiscoveryFragment extends Fragment {
    private String mFrom;

    private ListItemView attributeGroupSetting;
    private ListItemView attributeLittleNine;

    public static DiscoveryFragment newInstance(String from){
        DiscoveryFragment fragment = new DiscoveryFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from",from);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mFrom = getArguments().getString("from");
        }
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discovery,null);
//        TextView textView = (TextView) view.findViewById(R.id.title_from);
//        TextView content = (TextView) view.findViewById(R.id.fragment_content);
//        textView.setText(mFrom);
//        content.setText("群组");
        attributeGroupSetting = (ListItemView)view.findViewById(R.id.list_item_group_view);
        attributeLittleNine = (ListItemView)view.findViewById(R.id.list_item_user2);

        attributeGroupSetting.setOnClickListener(new ListItemView.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"从你的全世界路过", Toast.LENGTH_SHORT).show();
            }
        });
        attributeGroupSetting.setOnMenuItemClickListener(new ListItemView.OnMenuItemClickListener() {
            @Override
            public void onActionMenuItemSelected(MenuItem item) {
                Toast.makeText(getActivity(), "设置", Toast.LENGTH_SHORT).show();
            }
        });
        attributeLittleNine.setOnClickListener(new ListItemView.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"小阿九", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
