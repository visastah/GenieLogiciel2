package com.example.visas.genielogiciel2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by visas on 5/23/18.
 */

public class NewMessageRecyclerAdapter extends RecyclerView.Adapter<NewMessageRecyclerAdapter.GroupViewHolder> {

    private ArrayList<GroupsDataProvider> arrayList;

    public NewMessageRecyclerAdapter(ArrayList<GroupsDataProvider> arrayList){

        this.arrayList = arrayList;

    }

    @Override
    public NewMessageRecyclerAdapter.GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_item, parent, false);

        NewMessageRecyclerAdapter.GroupViewHolder holder = new NewMessageRecyclerAdapter.GroupViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NewMessageRecyclerAdapter.GroupViewHolder holder, int position) {

        GroupsDataProvider groupsDataProvider = arrayList.get(position);
        holder.groupInitials.setText(groupsDataProvider.getGroupInitials());
        holder.groupName.setText(groupsDataProvider.getGroupName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class GroupViewHolder extends RecyclerView.ViewHolder {

        TextView groupInitials, groupName;

        public GroupViewHolder(View view) {
            super(view);

            groupInitials = view.findViewById(R.id.new_message_group_initials);
            groupName = view.findViewById(R.id.new_message_group_name);

        }
    }

}
