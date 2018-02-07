package com.rocky.andyren.rjrecyclerview;

import android.view.View;

/**
 * Created by Andy.Ren on 2017/3/31.
 */

public class ViewBean {

    public View view;

    public int viewType;

    public ViewBean(View v, int type){
        this.view = v;
        this.viewType = type;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
