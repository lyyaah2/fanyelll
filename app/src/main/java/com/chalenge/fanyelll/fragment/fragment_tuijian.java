package com.chalenge.fanyelll.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chalenge.fanyelll.R;

/**
 * Created by Administrator on 2016/7/25.
 */
public class fragment_tuijian  extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View lView=inflater.inflate(R.layout.item_fragment_tuijian,container,false);
        return lView;
    }
    public static fragment_tuijian newInstance() {

        fragment_tuijian f = new fragment_tuijian();
//        Bundle b = new Bundle();
//        b.putString("msg", text);
//
//        f.setArguments(b);

        return f;
    }
}
