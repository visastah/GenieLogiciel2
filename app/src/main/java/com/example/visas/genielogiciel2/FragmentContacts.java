package com.example.visas.genielogiciel2;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by visas on 5/10/18.
 */

public class FragmentContacts extends Fragment {

    View view;

    private RecyclerView cRecyclerView;
    private RecyclerView.Adapter cAdapter;
    private RecyclerView.LayoutManager cLayoutManager;
    private FloatingActionButton fab;

    private Dialog newContactDialog, editContactDialog;
    private Button cancelButton, saveButton;
    private EditText nameField, numberField;

    private ArrayList<ContactsDataProvider> contactsList;

    public FragmentContacts() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.contacts_fragment, container, false);

       cRecyclerView = view.findViewById(R.id.contacts_recycler_view);

        fillContactsList();

        cAdapter = new ContactsRecyclerAdapter(contactsList);

        cLayoutManager = new LinearLayoutManager(getActivity());

        fab = view.findViewById(R.id.fab_contacts);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildNewContactDialog();
            }
        });

        cRecyclerView.setHasFixedSize(true);
        cRecyclerView.setLayoutManager(cLayoutManager);
        cRecyclerView.setAdapter(cAdapter);


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    private void buildNewContactDialog(){

        newContactDialog = new Dialog(getContext());
        newContactDialog.setContentView(R.layout.new_contact_dialog);

        TextView heading = newContactDialog.findViewById(R.id.contact_dialog_heading);

        saveButton = newContactDialog.findViewById(R.id.new_contact_save_btn);
        cancelButton = newContactDialog.findViewById(R.id.new_contact_cancel_btn);

        heading.setText("Nouveau Contact");
        nameField = newContactDialog.findViewById(R.id.new_contact_name);
        numberField = newContactDialog.findViewById(R.id.new_contact_number);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContact();
                newContactDialog.dismiss();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newContactDialog.dismiss();
            }
        });

        newContactDialog.show();
    }

    private void saveContact(){

        //Code to save contact.
        cAdapter.notifyDataSetChanged();
    }
}
