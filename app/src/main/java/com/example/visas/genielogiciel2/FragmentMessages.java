package com.example.visas.genielogiciel2;

import android.app.Activity;
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

public class FragmentMessages extends Fragment {

    private View view;
    private Activity activity;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<MessagesDataProvider> messagesDataProviderList;


    public FragmentMessages() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.messages_fragment, container, false);


        mRecyclerView = view.findViewById(R.id.messages_recycler_view);

        messagesDataProviderList = new ArrayList<>();


        messagesDataProviderList.add(new MessagesDataProvider("I1", "TITLE 1", "This message is a message of adapter 1", "10:00"));
        messagesDataProviderList.add(new MessagesDataProvider("I2", "TITLE 2", "This message is a message of adapter 2", "10:00"));
        messagesDataProviderList.add(new MessagesDataProvider("I3", "TITLE 3", "This message is a message of adapter 3", "10:00"));
        messagesDataProviderList.add(new MessagesDataProvider("I4", "TITLE 4", "This message is a message of adapter 4", "10:00"));
        messagesDataProviderList.add(new MessagesDataProvider("I5", "TITLE 5", "This message is a message of adapter 5", "10:00"));
        messagesDataProviderList.add(new MessagesDataProvider("I6", "TITLE 6", "This message is a message of adapter 6", "10:00"));
        messagesDataProviderList.add(new MessagesDataProvider("I7", "TITLE 7", "This message is a message of adapter 7", "10:00", false));
        messagesDataProviderList.add(new MessagesDataProvider("I8", "TITLE 8", "This message is a message of adapter 8", "10:00", false));
        messagesDataProviderList.add(new MessagesDataProvider("I9", "TITLE 9", "This message is a message of adapter 9", "10:00"));
        messagesDataProviderList.add(new MessagesDataProvider("I10", "TITLE 10", "This message is a message of adapter 10", "10:00"));
        messagesDataProviderList.add(new MessagesDataProvider("I11", "TITLE 11", "This message is a message of adapter 11", "10:00"));
        messagesDataProviderList.add(new MessagesDataProvider("I12", "TITLE 12", "This message is a message of adapter 12", "10:00"));
        messagesDataProviderList.add(new MessagesDataProvider("I13", "TITLE 13", "This message is a message of adapter 13", "10:00"));
        messagesDataProviderList.add(new MessagesDataProvider("I14", "TITLE 14", "This message is a message of adapter 14", "10:00"));

        mAdapter = new MessagesRecyclerAdapter(view.getContext(), messagesDataProviderList);


        mLayoutManager = new LinearLayoutManager(getActivity());

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_messages);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), NewMessageActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
