package com.example.visas.genielogiciel2;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

/**
 * Created by visas on 5/12/18.
 */

public class MessagesRecyclerAdapter extends RecyclerView.Adapter<MessagesRecyclerAdapter.MessageViewHolder>{

    private ArrayList<MessagesDataProvider> messagesDataList;
    public Context context;

    Dialog draftDialog;


    // Provide a suitable constructor (depends on the kind of dataset)
    public MessagesRecyclerAdapter(Context context, ArrayList<MessagesDataProvider> messagesDataList) {

        this.context = context;
        this.messagesDataList = messagesDataList;
        draftDialog = new Dialog(context);



    }

    // Create new views (invoked by the layout manager)
    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent,
                                                int viewType) {
        // create a new view
        View v = LayoutInflater.from(context)
                .inflate(R.layout.message_card, parent, false);
        final MessageViewHolder vh = new MessageViewHolder(v);

        vh.messageCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(messagesDataList.get(vh.getAdapterPosition()).isMessageIsSent()){
                    createSendDialog(vh, messagesDataList.get(vh.getAdapterPosition()));
                }
                else{
                    createDraftDialog(vh, messagesDataList.get(vh.getAdapterPosition()));
                }
            }
        });

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        MessagesDataProvider messagesDataProvider = messagesDataList.get(position);


        holder.groupInitials.setText(messagesDataList.get(position).getGroupInitials());
        holder.messageTitle.setText(messagesDataList.get(position).getMessageTitle());
        holder.messageInfo.setText(messagesDataList.get(position).getMessageInfo());
        holder.messageTime.setText(messagesDataList.get(position).getMessageTime());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return messagesDataList.size();
    }

    private void createSendDialog(MessageViewHolder vh, MessagesDataProvider dataProvider){

        draftDialog.setContentView(R.layout.dialog_send);

        TextView groupInitials = draftDialog.findViewById(R.id.sent_group_initials);
        TextView groupName = draftDialog.findViewById(R.id.sent_group_name);
        TextView sentTime = draftDialog.findViewById(R.id.sent_time);
        TextView textDetails = draftDialog.findViewById(R.id.sent_text_details);

        groupInitials.setText(dataProvider.getGroupInitials());
        groupName.setText(dataProvider.getMessageTitle());
        sentTime.setText(dataProvider.getMessageTime());
        textDetails.setText(dataProvider.getMessageInfo());

        draftDialog.show();
    }

    private void createDraftDialog(MessageViewHolder vh, MessagesDataProvider dataProvider){

        draftDialog.setContentView(R.layout.draft_dialog);


        TextView groupInitials = draftDialog.findViewById(R.id.dialog_group_initials);
        TextView groupName = draftDialog.findViewById(R.id.dialog_message_title);
        final EditText textDetails = draftDialog.findViewById(R.id.dialog_drafted_text);

        ImageButton clearDraft = draftDialog.findViewById(R.id.clear_draft);
        ImageButton saveDraft = draftDialog.findViewById(R.id.save_draft);
        ImageButton sendDraft = draftDialog.findViewById(R.id.send_draft);

        groupInitials.setText(dataProvider.getGroupInitials());
        groupName.setText(dataProvider.getMessageTitle());
        textDetails.setText(dataProvider.getMessageInfo());
        textDetails.setSelection(textDetails.getText().length());


//        Setting action events for Dialog buttons
        clearDraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDetails.setText("");
            }
        });

        saveDraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code to save draft
            }
        });

        sendDraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code to send draft
            }
        });

        draftDialog.show();

    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MessageViewHolder extends RecyclerView.ViewHolder{
        // each data item is just a string in this case
        private TextView groupInitials, messageTitle, messageInfo, messageTime;
        private LinearLayout messageCard;

        public MessageViewHolder(View view) {
            super(view);

            messageCard = view.findViewById(R.id.message_card);
            groupInitials = (CircularTextView) view.findViewById(R.id.group_initials);
            messageTitle = view.findViewById(R.id.message_title);
            messageInfo = view.findViewById(R.id.message_info);
            messageTime = view.findViewById(R.id.message_time);

        }

    }
}