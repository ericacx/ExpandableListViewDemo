package com.eric.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by eric on 2017/8/23.
 */

public class MyExpandableAdapter extends BaseExpandableListAdapter{

    private Context mContext;
    private List<String> mGroupEntityList;
    private List<List<ChildEntity>> mChildEntityList;

    public MyExpandableAdapter(Context context,List<String> groupEntityList, List<List<ChildEntity>> childEntityList) {
        this.mContext = context;
        this.mGroupEntityList = groupEntityList;
        this.mChildEntityList = childEntityList;
    }

    @Override
    public int getGroupCount() {
        if (mGroupEntityList.size() > 0){
            return mGroupEntityList.size();
        }
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (mChildEntityList.size() > 0){
            return mChildEntityList.get(groupPosition).size();
        }
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroupEntityList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mChildEntityList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if(convertView==null){
            groupViewHolder = new GroupViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.expandlist_group, null);
            groupViewHolder.groupName = (TextView) convertView.findViewById(R.id.group_name);
            groupViewHolder.groupStatus = (ImageView) convertView.findViewById(R.id.group_status);
            convertView.setTag(groupViewHolder);
        }else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.groupName.setText(mGroupEntityList.get(groupPosition));
        if (isExpanded) {
            //箭头向下
            Glide.with(mContext).load(R.mipmap.checked).into(groupViewHolder.groupStatus);
        }else{//如果组是伸缩状态
            //箭头向右
            Glide.with(mContext).load(R.mipmap.uncheck).into(groupViewHolder.groupStatus);
        }
        //返回得到的指定组的视图对象
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View
            convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.expandlist_item, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.itemRlBg = (RelativeLayout) convertView.findViewById(R.id.item_rl_bg);
            childViewHolder.itemName = (TextView) convertView.findViewById(R.id.item_name);
            childViewHolder.itemNameVip = (TextView) convertView.findViewById(R.id.item_name_vip);
            childViewHolder.itemPoint = (TextView) convertView.findViewById(R.id.item_point);
            childViewHolder.itemPointUsed = (TextView) convertView.findViewById(R.id.item_point_used);
            childViewHolder.itemExchange = (Button) convertView.findViewById(R.id.item_button_exchange);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        if (groupPosition == 0){
            childViewHolder.itemRlBg.setBackgroundResource(R.mipmap.aiqiyi);
            childViewHolder.itemExchange.setBackgroundResource(R.drawable.btn_bg_aiqiyi);
        } else if (groupPosition == 1){
            childViewHolder.itemRlBg.setBackgroundResource(R.mipmap.ykhx);
            childViewHolder.itemExchange.setBackgroundResource(R.drawable.btn_bg_yk);
        } else if (groupPosition == 2){
            childViewHolder.itemRlBg.setBackgroundResource(R.mipmap.txhy);
            childViewHolder.itemExchange.setBackgroundResource(R.drawable.btn_bg_tx);
        } else if (groupPosition == 3){
            childViewHolder.itemRlBg.setBackgroundResource(R.mipmap.qbcz);
            childViewHolder.itemExchange.setBackgroundResource(R.drawable.btn_bg_qb);
        } else if (groupPosition == 4){
            childViewHolder.itemRlBg.setBackgroundResource(R.mipmap.hfcz);
            childViewHolder.itemExchange.setBackgroundResource(R.drawable.btn_bg_hf);
        } else if (groupPosition == 5){
            childViewHolder.itemRlBg.setBackgroundResource(R.mipmap.llcz);
            childViewHolder.itemExchange.setBackgroundResource(R.drawable.btn_bg_ll);
        }
        childViewHolder.itemName.setText(mChildEntityList.get(groupPosition).get(childPosition).getItemName());
        childViewHolder.itemNameVip.setText(mChildEntityList.get(groupPosition).get(childPosition).getItemNameVip());
        childViewHolder.itemPoint.setText(mChildEntityList.get(groupPosition).get(childPosition).getItemPoint());
        childViewHolder.itemPointUsed.setText(mChildEntityList.get(groupPosition).get(childPosition).getItemPointUsed());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    private static class GroupViewHolder {
        TextView groupName;
        ImageView groupStatus;
    }

    private static class ChildViewHolder {
        RelativeLayout itemRlBg;
        TextView itemName;
        TextView itemPoint;
        TextView itemNameVip;
        TextView itemPointUsed;
        Button itemExchange;
    }
}
