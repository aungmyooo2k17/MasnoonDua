package com.mmucsy.masnoondua.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mmucsy.masnoondua.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aungmyooo on 2/16/18.
 */

public class DuaViewPagerAdapter extends PagerAdapter {

    @BindView(R.id.tv_dua_tilte)
    TextView tvDuaTitle;

    @BindView(R.id.tv_dua)
    TextView tvDua;

    @BindView(R.id.tv_dua_translation)
    TextView tvDuaTranslation;

    private Context context;
    private LayoutInflater mLayoutInflater;

    public DuaViewPagerAdapter(Context context) {
        this.context = context;
        mLayoutInflater = (LayoutInflater) this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 19;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mLayoutInflater.inflate(R.layout.view_dua_detail_item, container, false);
        ButterKnife.bind(this, view);


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
