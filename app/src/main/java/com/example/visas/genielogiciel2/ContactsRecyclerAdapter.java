package com.example.visas.genielogiciel2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by visas on 5/16/18.
 */

public class ContactsRecyclerAdapter  extends
        RecyclerView.Adapter<ContactsRecyclerAdapter.ContactsViewHolder>{

    private ArrayList<ContactsDataProvider> contactsDataList;
    private AlertDialog.Builder deleteConfirmationDialog;
    private Dialog editContactDialog;

    private EditText contactName, contactNumber;

    public ContactsRecyclerAdapter(ArrayList<ContactsDataProvider> contactsDataList) {
        this.contactsDataList = contactsDataList;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                     .inflate(R.layout.contact_card, parent, false);

        final ContactsViewHolder holder = new ContactsViewHolder(view);
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    deleteConfirmationDialog = new AlertDialog.Builder(parent.getContext(),
                            R.style.ThemeOverlay_AppCompat_Dialog_Alert);
                }
                else{
                    deleteConfirmationDialog = new AlertDialog.Builder(parent.getContext());
                }

                deleteConfirmationDialog.setMessage("Voulez vous vraiment suprimmer "+holder.contactName.getText()+" parmi vos contacts?")
                        .setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                //Code to delete contact from server

                                int currentPosition = holder.getAdapterPosition();
                                contactsDataList.remove(currentPosition);
                                notifyItemRemoved(currentPosition);
                                notifyItemRangeChanged(currentPosition, contactsDataList.size());
                            }
                        })
                        .setNegativeButton("NON", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });

        holder.contactsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editContactDialog = new Dialog(parent.getContext());
                buildEditContactDialog(editContactDialog, holder);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {

        holder.contactName.setText(contactsDataList.get(position).getContactName());
        holder.contactNumber.setText(contactsDataList.get(position).contactNumberToString());
    }

    @Override
    public int getItemCount() {
        return contactsDataList.size();
    }

    private void buildEditContactDialog(final Dialog dialog, final ContactsViewHolder holder){

        dialog.setContentView(R.layout.new_contact_dialog);

        contactName = dialog.findViewById(R.id.new_contact_name);
        contactNumber = dialog.findViewById(R.id.new_contact_number);
        Button saveButton = dialog.findViewById(R.id.new_contact_save_btn);
        Button cancelButton = dialog.findViewById(R.id.new_contact_cancel_btn);
        TextView heading = dialog.findViewById(R.id.contact_dialog_heading);

        contactName.setText(holder.contactName.getText());
        contactName.setSelection(contactName.getText().length());
        contactNumber.setText(holder.contactNumber.getText());
        contactNumber.setSelection(contactNumber.getText().length());

        heading.setText("Modifier");

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContactInfo(holder);
                dialog.dismiss();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private void updateContactInfo(ContactsViewHolder holder){
        //code to update contact info
    }

    public static class ContactsViewHolder extends RecyclerView.ViewHolder{

        TextView contactName, contactNumber;
        ImageView deleteButton;
        LinearLayout contactsCard;

        public ContactsViewHolder(View itemView) {
            super(itemView);

            contactsCard = itemView.findViewById(R.id.contacts_linear_layout);
            contactName = itemView.findViewById(R.id.contact_name);
            contactNumber = itemView.findViewById(R.id.contact_number);
            deleteButton = itemView.findViewById(R.id.delete_contact);

        }
    }
}
