package com.chalenge.fanyelll.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chalenge.fanyelll.DianyingyuanshengActivity;
import com.chalenge.fanyelll.DuanPianActivity;
import com.chalenge.fanyelll.R;
import com.chalenge.fanyelll.ShangyingActivity;

/**
 * Created by Administrator on 2016/7/25.
 */
public class fragment_faxian extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View lView = inflater.inflate(R.layout.item_fragment_faxian, container, false);
        initview(lView);

        return lView;
    }

    private void initview(View lView) {
        ImageView iv_shangying = (ImageView) lView.findViewById(R.id.iv_shangying);
        iv_shangying.setOnClickListener(this);

        ImageView iv_duanpian = (ImageView) lView.findViewById(R.id.iv_duanpian);
        iv_duanpian.setOnClickListener(this);

        ImageView iv_yingdan = (ImageView) lView.findViewById(R.id.iv_yingdan);
        iv_yingdan.setOnClickListener(this);

        ImageView iv_shalong = (ImageView) lView.findViewById(R.id.iv_shalong);
        iv_shalong.setOnClickListener(this);

        ImageView iv_yingku = (ImageView) lView.findViewById(R.id.iv_yingku);
        iv_yingku.setOnClickListener(this);

        ImageView iv_dianyingyuansheng = (ImageView) lView.findViewById(R.id.iv_dianyingyuansheng);
        iv_dianyingyuansheng.setOnClickListener(this);


    }

    public static fragment_faxian newInstance() {

        fragment_faxian f = new fragment_faxian();
//        Bundle b = new Bundle();
//        b.putString("msg", text);
//
//        f.setArguments(b);

        return f;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_shangying:
                getActivity().startActivity(new Intent(getActivity(), ShangyingActivity.class));
                break;
            case R.id.iv_duanpian:
                Intent intent = new Intent(getActivity(), DuanPianActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.iv_yingdan:
                break;

            case R.id.iv_shalong:
                break;

            case R.id.iv_yingku:
                break;
            case R.id.iv_dianyingyuansheng:
                getActivity().startActivity(new Intent(getActivity(), DianyingyuanshengActivity.class));
                break;
            case R.id.tv_yingpin:
                break;
            case R.id.tv_huabao:
                break;
            case R.id.tv_zaliang:
                break;
            case R.id.tv_jingdiantaici:
                break;

        }

    }
}
