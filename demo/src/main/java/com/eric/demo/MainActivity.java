package com.eric.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView mExpandableListView;
    private MyExpandableAdapter mAdapter;

    private List<String> mGroupEntityList;
    private List<List<ChildEntity>> mChildEntityList;

    private List<ChildEntity> mChildOne;
    private List<ChildEntity> mChildTwo;
    private List<ChildEntity> mChildThree;
    private List<ChildEntity> mChildFour;
    private List<ChildEntity> mChildFive;
    private List<ChildEntity> mChildSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        mExpandableListView = ((ExpandableListView) findViewById(R.id.expandable_listview));
        mAdapter = new MyExpandableAdapter(MainActivity.this,mGroupEntityList,mChildEntityList);
        mExpandableListView.setAdapter(mAdapter);
    }

    private void initData() {
        mGroupEntityList = new ArrayList<String>();
        mGroupEntityList.add("爱奇艺VIP");
        mGroupEntityList.add("优酷会员");
        mGroupEntityList.add("腾讯视频VIP");
        mGroupEntityList.add("Q币充值卡");
        mGroupEntityList.add("手机话费充值卡");
        mGroupEntityList.add("手机流量充值卡");

        ChildEntity childEntity1 = new ChildEntity();
        childEntity1.setItemName("一个月黄金VIP");
        childEntity1.setItemPoint("2000积分");
        childEntity1.setItemNameVip("一个月爱奇艺黄金VIP");
        childEntity1.setItemPointUsed("消耗2000积分");

        ChildEntity childEntity2 = new ChildEntity();
        childEntity2.setItemName("三个月黄金VIP");
        childEntity2.setItemPoint("6000积分");
        childEntity2.setItemNameVip("三个月爱奇艺黄金VIP");
        childEntity2.setItemPointUsed("消耗6000积分");

        ChildEntity childEntity3 = new ChildEntity();
        childEntity3.setItemName("十二个月黄金VIP");
        childEntity3.setItemPoint("20000积分");
        childEntity3.setItemNameVip("十二个月爱奇艺黄金VIP");
        childEntity3.setItemPointUsed("消耗20000积分");

        mChildOne = new LinkedList<ChildEntity>();
        mChildOne.add(childEntity1);
        mChildOne.add(childEntity2);
        mChildOne.add(childEntity3);


        ChildEntity childEntityYK1 = new ChildEntity();
        childEntityYK1.setItemName("一个月黄金会员");
        childEntityYK1.setItemPoint("2000积分");
        childEntityYK1.setItemNameVip("一个月优酷黄金会员");
        childEntityYK1.setItemPointUsed("消耗2000积分");

        ChildEntity childEntityYK2 = new ChildEntity();
        childEntityYK2.setItemName("三个月黄金会员");
        childEntityYK2.setItemPoint("6000积分");
        childEntityYK2.setItemNameVip("三个月优酷黄金会员");
        childEntityYK2.setItemPointUsed("消耗6000积分");

        ChildEntity childEntityYK3 = new ChildEntity();
        childEntityYK3.setItemName("十二个月黄金会员");
        childEntityYK3.setItemPoint("20000积分");
        childEntityYK3.setItemNameVip("十二个月优酷黄金会员");
        childEntityYK3.setItemPointUsed("消耗20000积分");

        mChildTwo = new LinkedList<ChildEntity>();
        mChildTwo.add(childEntityYK1);
        mChildTwo.add(childEntityYK2);
        mChildTwo.add(childEntityYK3);

        ChildEntity childEntityTX1 = new ChildEntity();
        childEntityTX1.setItemName("一个月腾讯视频VIP");
        childEntityTX1.setItemPoint("2000积分");
        childEntityTX1.setItemNameVip("一个月腾讯视频VIP");
        childEntityTX1.setItemPointUsed("消耗2000积分");

        ChildEntity childEntityTX2 = new ChildEntity();
        childEntityTX2.setItemName("三个月腾讯视频VIP");
        childEntityTX2.setItemPoint("6000积分");
        childEntityTX2.setItemNameVip("三个月腾讯视频VIP");
        childEntityTX2.setItemPointUsed("消耗6000积分");

        ChildEntity childEntityTX3 = new ChildEntity();
        childEntityTX3.setItemName("六个月腾讯视频VIP");
        childEntityTX3.setItemPoint("11000积分");
        childEntityTX3.setItemNameVip("六个月腾讯视频VIP");
        childEntityTX3.setItemPointUsed("消耗11000积分");

        ChildEntity childEntityTX4 = new ChildEntity();
        childEntityTX4.setItemName("十二个月腾讯视频VIP");
        childEntityTX4.setItemPoint("20000积分");
        childEntityTX4.setItemNameVip("十二个月腾讯视频VIP");
        childEntityTX4.setItemPointUsed("消耗20000积分");

        mChildThree = new LinkedList<ChildEntity>();
        mChildThree.add(childEntityTX1);
        mChildThree.add(childEntityTX2);
        mChildThree.add(childEntityTX3);
        mChildThree.add(childEntityTX4);

        ChildEntity childEntityQB1 = new ChildEntity();
        childEntityQB1.setItemName("10Q币充值卡");
        childEntityQB1.setItemPoint("1000积分");
        childEntityQB1.setItemNameVip("腾讯10Q币充值卡");
        childEntityQB1.setItemPointUsed("消耗1000积分");

        ChildEntity childEntityQB2 = new ChildEntity();
        childEntityQB2.setItemName("30Q币充值卡");
        childEntityQB2.setItemPoint("3000积分");
        childEntityQB2.setItemNameVip("腾讯30Q币充值卡");
        childEntityQB2.setItemPointUsed("消耗3000积分");

        ChildEntity childEntityQB3 = new ChildEntity();
        childEntityQB3.setItemName("50Q币充值卡");
        childEntityQB3.setItemPoint("5000积分");
        childEntityQB3.setItemNameVip("腾讯50Q币充值卡");
        childEntityQB3.setItemPointUsed("消耗5000积分");

        ChildEntity childEntityQB4 = new ChildEntity();
        childEntityQB4.setItemName("100Q币充值卡");
        childEntityQB4.setItemPoint("10000积分");
        childEntityQB4.setItemNameVip("腾讯100Q币充值卡");
        childEntityQB4.setItemPointUsed("消耗10000积分");

        mChildFour = new LinkedList<ChildEntity>();
        mChildFour.add(childEntityQB1);
        mChildFour.add(childEntityQB2);
        mChildFour.add(childEntityQB3);
        mChildFour.add(childEntityQB4);

        ChildEntity childEntityHF1 = new ChildEntity();
        childEntityHF1.setItemName("10元话费充值卡");
        childEntityHF1.setItemPoint("1000积分");
        childEntityHF1.setItemNameVip("10元话费充值卡");
        childEntityHF1.setItemPointUsed("消耗1000积分");

        ChildEntity childEntityHF2 = new ChildEntity();
        childEntityHF2.setItemName("30元话费充值卡");
        childEntityHF2.setItemPoint("3000积分");
        childEntityHF2.setItemNameVip("30元话费充值卡");
        childEntityHF2.setItemPointUsed("消耗3000积分");

        ChildEntity childEntityHF3 = new ChildEntity();
        childEntityHF3.setItemName("50元话费充值卡");
        childEntityHF3.setItemPoint("5000积分");
        childEntityHF3.setItemNameVip("50元话费充值卡");
        childEntityHF3.setItemPointUsed("消耗5000积分");

        ChildEntity childEntityHF4 = new ChildEntity();
        childEntityHF4.setItemName("100元话费充值卡");
        childEntityHF4.setItemPoint("10000积分");
        childEntityHF4.setItemNameVip("100元话费充值卡");
        childEntityHF4.setItemPointUsed("消耗10000积分");

        mChildFive = new LinkedList<ChildEntity>();
        mChildFive.add(childEntityHF1);
        mChildFive.add(childEntityHF2);
        mChildFive.add(childEntityHF3);
        mChildFive.add(childEntityHF4);


        ChildEntity childEntityLL1 = new ChildEntity();
        childEntityLL1.setItemName("100M手机流量充值卡");
        childEntityLL1.setItemPoint("800积分");
        childEntityLL1.setItemNameVip("100M手机流量充值卡");
        childEntityLL1.setItemPointUsed("消耗800积分");

        ChildEntity childEntityLL2 = new ChildEntity();
        childEntityLL2.setItemName("300M手机流量充值卡");
        childEntityLL2.setItemPoint("1500积分");
        childEntityLL2.setItemNameVip("300M手机流量充值卡");
        childEntityLL2.setItemPointUsed("消耗1500积分");

        ChildEntity childEntityLL3 = new ChildEntity();
        childEntityLL3.setItemName("500M手机流量充值卡");
        childEntityLL3.setItemPoint("2500积分");
        childEntityLL3.setItemNameVip("500M手机流量充值卡");
        childEntityLL3.setItemPointUsed("消耗2500积分");

        ChildEntity childEntityLL4 = new ChildEntity();
        childEntityLL4.setItemName("1G手机流量充值卡");
        childEntityLL4.setItemPoint("5000积分");
        childEntityLL4.setItemNameVip("1G手机流量充值卡");
        childEntityLL4.setItemPointUsed("消耗5000积分");

        mChildSix = new LinkedList<ChildEntity>();
        mChildSix.add(childEntityLL1);
        mChildSix.add(childEntityLL2);
        mChildSix.add(childEntityLL3);
        mChildSix.add(childEntityLL4);


        mChildEntityList = new LinkedList<List<ChildEntity>>();
        mChildEntityList.add(mChildOne);
        mChildEntityList.add(mChildTwo);
        mChildEntityList.add(mChildThree);
        mChildEntityList.add(mChildFour);
        mChildEntityList.add(mChildFive);
        mChildEntityList.add(mChildSix);

    }
}
