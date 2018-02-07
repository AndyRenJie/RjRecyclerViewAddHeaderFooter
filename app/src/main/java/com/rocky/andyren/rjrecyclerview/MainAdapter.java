package com.rocky.andyren.rjrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static com.rocky.andyren.rjrecyclerview.MainActivity.FOOTER_VIEW_TYPE;
import static com.rocky.andyren.rjrecyclerview.MainActivity.HEADER_VIEW_TYPE;

/**
 * Created by Andy.Ren on 2017/3/31.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<String> mList;
    private ArrayList<ViewBean> mHeaderViewInfos;
    private ArrayList<ViewBean> mFooterViewInfos;
    private LayoutInflater mInflater;
    private int mTotalCount;

    public MainAdapter(Context context, ArrayList<String>list , ArrayList<ViewBean> headerViewInfos, ArrayList<ViewBean> footerViewInfos){
        this.mList = list;
        this.mHeaderViewInfos = headerViewInfos;
        this.mFooterViewInfos = footerViewInfos;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == HEADER_VIEW_TYPE){
            View headerView = mHeaderViewInfos.get(0).view;
            return new HeaderViewHolder(headerView);
        }else if(viewType == FOOTER_VIEW_TYPE){
            View footerView = mFooterViewInfos.get(0).view;
            return new FooterViewHolder(footerView);
        }else{
            View view = mInflater.inflate(R.layout.item,parent,false);
            MainViewHolder viewHolder = new MainViewHolder(view);
            return viewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == HEADER_VIEW_TYPE) {
            return;
        }else if(viewType ==FOOTER_VIEW_TYPE){
            return;
        }else {
            MainViewHolder holder = (MainViewHolder) viewHolder;
            int realPosition = position - mHeaderViewInfos.size();
            holder.itemText.setText(mList.get(realPosition));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER_VIEW_TYPE;
        } else if (position == mTotalCount-1) {
            return FOOTER_VIEW_TYPE;
        } else {
            return 0;
        }
    }

    @Override
    public int getItemCount() {
        mTotalCount  = mHeaderViewInfos.size() + mList.size() + mFooterViewInfos.size();
        return mTotalCount;
    }

    class MainViewHolder extends RecyclerView.ViewHolder{

        TextView itemText;

        public MainViewHolder(View itemView) {
            super(itemView);
            itemText = (TextView) itemView.findViewById(R.id.item_text);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder{

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
