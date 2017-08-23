package com.eric.expandablelistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //声明一个可伸展的列表视图对象
    private ExpandableListView expandlist;
    //声明并初始化一个组集合对象，该集合时一个一维数组
    private List<Map<String, Object>> groupList = new ArrayList<Map<String,Object>>();
    //声明一个子元素集合对象，该集合是一个数组链表
    private List<List<Map<String, Object>>>childList = new ArrayList<List<Map<String,Object>>>();
    //声明一个子元素集合对象
    private List<Map<String, Object>> child;
    //声明一个map对象
    private Map<String, Object> map;
    //组元素值
    private String[] armTypes = new String[]{
            "WORD", "EXCEL", "EMAIL", "PPT"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //给组赋值
        for (int i = 0; i < armTypes.length; i++) {
            //每次都要初始化map对象
            map = new HashMap<String, Object>();
            //将组值放入key为Group的map中
            map.put("Group", armTypes[i]);
            //将map添加到组集合中
            groupList.add(map);
        }
        //给每组的子元素赋值
        for (int j = 0; j < 4; j++) {
            //每次初始化子集合对象。该对象是一个一维数组
            child = new ArrayList<Map<String,Object>>();
            //每个组下面有25个子元素
            for (int i = 0; i < 25; i++) {
                //初始化map对象
                map = new HashMap<String, Object>();
                //将子元素的值放入key值为Child的map中
                map.put("Child", "this is "+i+" example");
                //将map添加到一维数组中
                child.add(map);
            }
            //将一维数组添加到集合中
            childList.add(child);
        }
        //可伸展的列表视图绑定ID
        expandlist = (ExpandableListView) findViewById(R.id.expandable_listview);
        //声明并初始化一个adapter
        MyExpandableListAdapter adapter = new MyExpandableListAdapter(MainActivity.this,groupList,childList);
        //可伸展的列表视图加载adapter
        expandlist.setAdapter(adapter);
    }
}
