package com.eric.expandablelistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.util.List;
import java.util.Map;

/**
 * Created by eric on 2017/8/22.
 */

public class MyExpandableListAdapter extends BaseExpandableListAdapter{

    Context mContext;
    LayoutInflater inflater;
    //声明一个组集合
    List<Map<String, Object>>group;
    //声明一个子元素集合
    List<List<Map<String, Object>>>child;
    //声明一个map对象
    Map<String, Object>map;

    /**
     * 自定义适配器的构造函数
     * @param context 上下文
     * @param group 组集合
     * @param child 子元素集合
     */
    public MyExpandableListAdapter(Context context,List<Map<String, Object>>group,List<List<Map<String, Object>>>child){
        //初始化上下文
        this.mContext = context;
        //初始化布局管理器对象
        inflater = LayoutInflater.from(context);
        //初始化组集合
        this.group = group;
        //初始化子元素集合
        this.child = child;
    }

    /**
     * ExpandableListAdapter里面的所有条目
     * 都可用吗？如果是yes，就意味着所有条目可以选择和点击了。
     * 返回值：返回True表示所有条目均可用。
     */
    @Override
    public boolean areAllItemsEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    /**
     * 获取指定组中的指定子元素数据。
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        /*child.get(groupPosition)是得到groupPosition处的list对象，然后
         * child.get(groupPosition).get(childPosition)得到child的map对象，然后
         * child.get(groupPosition).get(childPosition).get("Child")是得到key值
         * 为Child的值
         * */
        return child.get(groupPosition).get(childPosition).get("Child");
    }

    /**
     * 获取指定组中的指定子元素ID，这个ID在组里一定是唯一的。联合ID（getCombinedChildId(long, long)）在所有条目（所有组和所有元素）中也是唯一的。
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        /******子元素的位置********/
        return childPosition;
    }


    /**获取一个视图对象，显示指定组中的指定子元素数据。
     * @param groupPosition 组位置（该组内部含有子元素）
     * @param childPosition 子元素位置（决定返回哪个视图）
     * @param isLastChild 子元素是否处于组中的最后一个
     * @param convertView 重用已经有的视图对象，它是RecycleBin缓存机制调用getScrapView方法获取废弃已缓存的view.
     * @param parent 返回的视图(View)对象始终依附于的视图组。通俗的说是它的父视图。
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolderChild viewHolderChild;
        /*当convertView为空，也就是没有废弃已缓存 view时，将执行下面方法，调用layoutinflate的
         * inflate()方法来加载一个view。
         * 如有不懂，请点击：http://blog.csdn.net/libmill/article/details/49644743
         */
        if(convertView==null){
            //重新加载布局
            convertView = inflater.inflate(R.layout.expandlist_item, null);
            //初始化控件管理器（自己命名的）
            viewHolderChild = new ViewHolderChild();
            //绑定控件id
            viewHolderChild.relativeLayout = ((RelativeLayout) convertView.findViewById(R.id.item_rl_bg));
            viewHolderChild.itemName = (TextView) convertView.findViewById(R.id.item_name);
            viewHolderChild.itemPoint = (TextView) convertView.findViewById(R.id.item_point);
            viewHolderChild.itemNameVip = (TextView) convertView.findViewById(R.id.item_name_vip);
            viewHolderChild.itemPointUsed = (TextView) convertView.findViewById(R.id.item_point_used);
            viewHolderChild.itemButtonExchange = (Button) convertView.findViewById(R.id.item_button_exchange);
            /*convertView的setTag将viewHolderChild设置到Tag中，以便系统第二次绘制
                ExpandableListView时从Tag中取出
            */
            convertView.setTag(viewHolderChild);
        }else{
            //当convertView不为空时，从Tag中取出viewHolderChild
            viewHolderChild = (ViewHolderChild) convertView.getTag();
        }
        //给子元素的TextView设置值
        viewHolderChild.itemName.setText(getChild(groupPosition, childPosition).toString());
        //返回视图对象，这里是childPostion处的视图
        return convertView;
    }

    /**
     * 获取指定组中子元素的个数
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        return child.get(groupPosition).size();
    }


    /**
     * 从列表所有项(组或子项)中获得一个唯一的子ID号。可折叠列表要求每个元素(组或子项)在所有的子元素和组中
     * 有一个唯一的ID。本方法负责根据所给的子ID号和组ID号返回唯一的ID。此外，若hasStableIds()
     * 是true，那么必须要返回稳定的ID。
     * @param groupId 包含该子元素的组ID
     * @param childId 子元素的ID
     * @return:列表所有项(组或子项)中唯一的(和可能稳定)的子元素ID号。（译者注：ID理论上是稳定的，
     * 不会发生冲突的情况。也就是说，这个列表会有组、子元素，它们的ID都是唯一的。）
     */
    @Override
    public long getCombinedChildId(long groupId , long childId ) {
        // TODO Auto-generated method stub
        return 0;
    }
    /**
     * 获取组ID
     * @param groupId 组ID
     * @return :组ID
     */
    @Override
    public long getCombinedGroupId(long groupId) {
        // TODO Auto-generated method stub
        return 0;
    }


    /**
     * 得到指定组的组数据
     * @param groupPosition:指定的组的位置
     * @return 返回指定组的组数据
     */
    @Override
    public Object getGroup(int groupPosition) {
        // TODO Auto-generated method stub
        /**group.get(groupPosition)获取map对象
         * group.get(groupPosition).get("Group")获取key值为Group的数据
         * **/
        return group.get(groupPosition).get("Group");
    }
    /**
     * 获取组长
     */
    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return group.size();
    }

    /**
     * 获取指定组的Id
     */
    @Override
    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }


    /**
     * 获取指定组的视图对象
     * @param groupPosition:组位置（决定返回哪个视图）
     * @param isExpanded:改组是展开状态还是伸缩状态
     * @param convertView:重用已有的视图对象
     * @return 返回指定组的视图对象
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolderGroup viewHolder;
        //判断convertView是否为空，convertView是RecycleBean调用getScrapView函数得到废弃已缓存的view
        if(convertView==null){
            //初始化控件管理器对象
            viewHolder = new ViewHolderGroup();
            //重新加载布局
            convertView = inflater.inflate(R.layout.expandlist_group, null);
            //给组元素绑定ID
            viewHolder.groupName = (TextView) convertView.findViewById(R.id.group_name);
            //给组元素箭头绑定ID
//            viewHolder.checkBox = (TextView) convertView.findViewById(R.id.group_checkbox);
            //convertView将viewHolder设置到Tag中，以便再次绘制ExpandableListView时从Tag中取出viewHolder;
            convertView.setTag(viewHolder);
        }else {//如果convertView不为空，即getScrapView得到废弃已缓存的view
            //从Tag中取出之前存入的viewHolder
            viewHolder = (ViewHolderGroup) convertView.getTag();
        }
        //设置组值
        viewHolder.groupName.setText(getGroup(groupPosition).toString());
        //如果组是展开状态
        if (isExpanded) {
            //箭头向下
            viewHolder.checkBox.setText("关闭");
        }else{//如果组是伸缩状态
            //箭头向右
            viewHolder.checkBox.setText("展开");
        }
        //返回得到的指定组的视图对象
        return convertView;
    }
    /**
     * 组和子元素是否持有稳定的ID,也就是底层数据的改变不会影响到它们。
     * @return 返回一个Boolean类型的值，如果为TRUE，意味着相同的ID永远引用相同的对象
     */
    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }
    /**
     * 是否选中指定位置上的子元素。
     */
    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return true;
    }
    /**
     * 如果当前适配器不包含任何数据则返回True。经常用来决定一个空视图是否应该被显示。
     * 一个典型的实现将返回表达式getCount() == 0的结果，但是由于getCount()包含了头部和尾部，适配器可能需要不同的行为。
     */
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }


    /**
     * 组控件管理器
     * @author Administrator
     *
     */
    class ViewHolderGroup{
        TextView checkBox;
        TextView groupName;
    }

    /**
     * 子控件管理器
     * @author Administrator
     *
     */
    class ViewHolderChild{
        RelativeLayout relativeLayout;
        TextView itemName;
        TextView itemPoint;
        TextView itemNameVip;
        TextView itemPointUsed;
        Button itemButtonExchange;
    }

}
