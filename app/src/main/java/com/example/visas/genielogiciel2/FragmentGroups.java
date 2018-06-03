package com.example.visas.genielogiciel2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by visas on 5/10/18.
 */

public class FragmentGroups extends Fragment {

    private View view;

    private RecyclerView gRecyclerView;
    private RecyclerView.Adapter gAdapter;
    private RecyclerView.LayoutManager gLayoutManager;
    private FloatingActionButton fab;

    public static ArrayList<GroupsDataProvider> groupsList;

    public FragmentGroups() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.groups_fragment, container, false);

        gRecyclerView = view.findViewById(R.id.groups_recycler_view);

        groupsList = new ArrayList<>();

        groupsList.add(new GroupsDataProvider("G1", "Group 1", 11));
        groupsList.add(new GroupsDataProvider("G2", "Group 2", 22));
        groupsList.add(new GroupsDataProvider("G3", "Group 3", 33));
        groupsList.add(new GroupsDataProvider("G4", "Group 4", 4));
        groupsList.add(new GroupsDataProvider("G5", "Group 5", 323));
        groupsList.add(new GroupsDataProvider("G6", "Group 6", 123));
        groupsList.add(new GroupsDataProvider("G7", "Group 7", 65));
        groupsList.add(new GroupsDataProvider("G8", "Group 8", 55));
        groupsList.add(new GroupsDataProvider("G9", "Group 9", 64));
        groupsList.add(new GroupsDataProvider("G10", "Group 10", 53));
        groupsList.add(new GroupsDataProvider("G11", "Group 11", 32));
        groupsList.add(new GroupsDataProvider("G12", "Group 12", 16));
        groupsList.add(new GroupsDataProvider("G13", "Group 13", 7));

        gAdapter = new GroupsRecyclerAdapter(groupsList);

        fab = view.findViewById(R.id.fab_groups);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NewGroupActivity.class);
                startActivity(intent);
            }
        });

        gLayoutManager = new LinearLayoutManager(getActivity());

        gRecyclerView.setHasFixedSize(true);
        gRecyclerView.setLayoutManager(gLayoutManager);
        gRecyclerView.setAdapter(gAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
