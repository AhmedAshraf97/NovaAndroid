package com.example.narim.nova;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.narim.nova.Followers_Item;

import java.util.List;

public class Following_Adapter extends RecyclerView.Adapter<Following_Adapter.myViewHolder> {
    List<Following_Item> Items;

    public Following_Adapter(List<Following_Item> Items) {
        this.Items = Items;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View row= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_followers_following,viewGroup,false);
        myViewHolder holder= new myViewHolder(row);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull Following_Adapter.myViewHolder myViewHolder, int i) {
        Following_Item item =Items.get(i);
        myViewHolder.Name.setText(item.Name);
        myViewHolder.Username.setText(item.Username);
    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView Name;
        TextView Username;

        public myViewHolder(@NonNull final View itemView) {
            super(itemView);
            Name= itemView.findViewById(R.id.TextView_Following_Followers_Name);
            Username= itemView.findViewById(R.id.TextView_Following_Followers_Username);
        }
    }
}