## RjRecyclerViewAddHeaderFooter ##

原生RecyclerView添加Header和Footer的例子，本项目只做了基本的RecyclerView添加头部布局和底部布局的操作，在这个基础上可以实现其他需求的操作，
例如头部布局添加首页轮播图，底部布局添加广告页等
 
先来上两张效果图，语言不够图来凑

![image](https://github.com/AndyRenJie/RjRecyclerViewAddHeaderFooter/blob/master/images/device-2018-02-07-172430.png)

![image](https://github.com/AndyRenJie/RjRecyclerViewAddHeaderFooter/blob/master/images/device-2018-02-07-172508.png)
 
项目中的顶部布局和底部布局就是一个最简单的TextView，首先用LayoutInflater初始化这两个布局View，设置它们的setLayoutParams，初始化数据后
绑定Adapter，具体的逻辑操作的在Adapter中处理
 
创建数据的ViewHolder，HeaderViewHolder和FooterViewHolder，getItemCount()函数中返回顶部+数据+底部的TotalCount
 
```
@Override
    public int getItemCount() {
        mTotalCount  = mHeaderViewInfos.size() + mList.size() + mFooterViewInfos.size();
        return mTotalCount;
    }
```

getItemViewType()中判断position，如果position=0就是顶部布局，position=最大值就是底部布局，这个很好理解

```
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
 ```
 
onCreateViewHolder()中判断当前的viewType，并new对应的ViewHolder

```
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
```

onBindViewHolder()中获取当前Item的viewType并显示数据

```
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
```
