package com.example.capstone_design;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Acquirer_Adapter extends RecyclerView.Adapter<Acquirer_Adapter.AcquirerViewHolder> {

    private ArrayList<Form> arrayList;
    private Context context;


    public Acquirer_Adapter(ArrayList<Form> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AcquirerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.acquirer_list_item,parent,false);
        AcquirerViewHolder holder = new AcquirerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AcquirerViewHolder holder, int position) {
        holder.tv_date.setText(arrayList.get(position).getDate());
        holder.tv_name.setText(arrayList.get(position).getName());
        holder.tv_place.setText(arrayList.get(position).getPlace());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class AcquirerViewHolder extends RecyclerView.ViewHolder {
        TextView tv_date;
        TextView tv_name;
        TextView tv_place;

        public AcquirerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_date = itemView.findViewById(R.id.a_item_date);
            this.tv_name = itemView.findViewById(R.id.a_item_name);
            this.tv_place = itemView.findViewById(R.id.a_item_place);
        }
    }
}
