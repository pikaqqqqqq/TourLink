package com.example.android.tourlink.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.tourlink.R;
import com.example.android.tourlink.ui.activity.ChatActivity;
import com.lucasurbas.listitemview.ListItemView;

import butterknife.Bind;


public class HomeFragment extends Fragment {

    ListItemView attributeLuFeiDu;
    ListItemView attributeLittleNine;

    private String mFrom;
    public static HomeFragment newInstance(String from){
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home,null);
//        TextView textView = (TextView) view.findViewById(R.id.title_from);
//        TextView content = (TextView) view.findViewById(R.id.fragment_content);
//        textView.setText(mFrom);
//        content.setText("消息");
        attributeLuFeiDu = (ListItemView)view.findViewById(R.id.list_item_user);
        attributeLittleNine = (ListItemView)view.findViewById(R.id.list_item_user2);

        attributeLuFeiDu.setOnClickListener(new ListItemView.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "都路飞", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        attributeLittleNine.setOnClickListener(new ListItemView.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "小阿九", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        return view;
    }
}
