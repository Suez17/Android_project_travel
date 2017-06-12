package com.example.michael.android_project_travel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Element.GroupTravel;

public class SearchResultActivity extends AppCompatActivity {

    List<GroupTravel> groupTravelList = new ArrayList<GroupTravel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result);

        String groupsInfo = getIntent().getStringExtra("groupsInfo");
        String[] group = groupsInfo.split("/");

        for (int i = 0; i < group.length; i++) {
            String[] info = group[i].split("_");
            groupTravelList.add(new GroupTravel(info[0], info[1] , info[2], info[3], info[4]));
        }

        ArrayAdapter<GroupTravel> adapter = new ArrayAdapter<GroupTravel>(this, android.R.layout.simple_list_item_1, groupTravelList);
        ListView lv = (ListView) findViewById(R.id.groupList);
        lv.setAdapter(adapter);
    }
}
