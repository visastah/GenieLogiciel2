package com.example.visas.genielogiciel2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

public class NewMessageActivity extends AppCompatActivity {

    private RecyclerView nmRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<GroupsDataProvider> groupsList;

    private ImageButton sendNewMessage, saveNewMessage, clearNewMessage;
    private EditText draftText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);

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


        nmRecyclerView = (RecyclerView) findViewById(R.id.new_message_recycler_view);
        adapter = new NewMessageRecyclerAdapter(groupsList);
        layoutManager = new LinearLayoutManager(getApplicationContext());

        nmRecyclerView.setAdapter(adapter);
        nmRecyclerView.setLayoutManager(layoutManager);

        clearNewMessage = (ImageButton) findViewById(R.id.clear_new_message);
        saveNewMessage = (ImageButton) findViewById(R.id.save_new_message);
        sendNewMessage = (ImageButton) findViewById(R.id.send_new_message);

        draftText =(EditText) findViewById(R.id.drafted_text);

        //Setting action events for buttons in this view
        clearNewMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                draftText.setText("");
            }
        });

        saveNewMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code for saving message
            }
        });

        sendNewMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code for sending message
            }
        });

    }
}
