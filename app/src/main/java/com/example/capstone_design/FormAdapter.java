package com.example.capstone_design;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FormAdapter extends RecyclerView.Adapter<FormAdapter.FormViewHolder> {


    private ArrayList<Form> arrayList;
    private Context context;

    public FormAdapter(ArrayList<Form> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public FormViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.form_list_item, parent, false);
        FormViewHolder holder = new FormViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FormViewHolder holder, int position) {
        holder.tv_date.setText(arrayList.get(position).getDate());
        holder.tv_acquisition_name.setText(arrayList.get(position).getName());
        holder.tv_place.setText(arrayList.get(position).getPlace());

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class FormViewHolder extends RecyclerView.ViewHolder {
        TextView tv_date;
        TextView tv_acquisition_name;
        TextView tv_place;

        public FormViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_date = itemView.findViewById(R.id.item_date);
            this.tv_acquisition_name =itemView.findViewById(R.id.item_acquisition_name);
            this.tv_place = itemView.findViewById(R.id.item_place);
        }
    }
}
