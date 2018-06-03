package com.example.visas.genielogiciel2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class NewGroupActivity extends AppCompatActivity {

    View view;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ActionBar actionBar;

    EditText groupNameEntry, groupInitialsEntry;
    String groupName, groupInitials;
    Button cancelButton, saveButton;

    ArrayList<ContactsDataProvider> contactsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);

        view = LayoutInflater.from(this).inflate(R.layout.new_group_action_bar, null);

        actionBar = getSupportActionBar();

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(view);

        fillContactsList();

        cancelButton = (Button)findViewById(R.id.new_group_cancel_btn);
        saveButton = (Button)findViewById(R.id.new_group_save_btn);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewGroup();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.new_group_recycler_view);
        adapter = new ManageGroupRecyclerAdapter(contactsList, true);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }



    private void fillContactsList(){

        contactsList = new ArrayList<>();

        contactsList.add(new ContactsDataProvider("Tsebo Mike", 677898232));
        contactsList.add(new ContactsDataProvider("Tsebo Mike", 677898232));
        contactsList.add(new ContactsDataProvider("Tsebo Mike", 677898232));
        contactsList.add(new ContactsDataProvider("Tsebo Mike", 677898232));
        contactsList.add(new ContactsDataProvider("Tsebo Mike", 677898232));
        contactsList.add(new ContactsDataProvider("Tsebo Mike", 677898232));
        contactsList.add(new ContactsDataProvider("Tsebo Mike", 677898232));
        contactsList.add(new ContactsDataProvider("Tsebo Mike", 677898232));
        contactsList.add(new ContactsDataProvider("Tsebo Mike", 677898232));

    }

    private void saveNewGroup(){
        //Code to save group to server
    }
}
