package com.example.capstone_design;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {


    private ArrayList<Member> arrayList;
    private Context context;


    public CustomAdapter(ArrayList<Member> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
//        Glide.with(holder.itemView)
//                .load(arrayList.get(position).getProfile())
//                .into(holder.iv_profile);
        holder.tv_name.setText(arrayList.get(position).getBln());
        holder.tv_time.setText(String.valueOf(arrayList.get(position).getBdt()));
        holder.tv_status.setText(arrayList.get(position).getBst());
        holder.tv_kind.setText(arrayList.get(position).getStat());
    }

    @Override
    public int getItemCount() {
        // 삼항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_time;
        TextView tv_status;
        TextView tv_kind;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_name = itemView.findViewById(R.id.item_name);
            this.tv_time = itemView.findViewById(R.id.item_time);
            this.tv_status = itemView.findViewById(R.id.item_state);
            this.tv_kind = itemView.findViewById(R.id.item_kind);
        }
    }
}