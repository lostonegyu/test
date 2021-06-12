//package com.example.capstone_design;
//
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//
//import java.util.ArrayList;
//
//public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
//
//    private ArrayList<Post> postList;
//    private Context context;
//
//    public PostAdapter(ArrayList<Post> postList, Context context) {
//        this.postList = postList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
//        PostViewHolder holder = new PostViewHolder(view);
//
//
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
//        Glide.with(holder.itemView);
//        holder.tv_name.setText(postList.get(position).getName());
//        holder.tv_time.setText(String.valueOf(postList.get(position).getTime()));
//        holder.tv_status.setText(postList.get(position).getStatus());
//        holder.tv_kind.setText(postList.get(position).getKind());
//    }
//
//    @Override
//    public int getItemCount() {
//        //삼항 연산자
//        return (postList != null ? postList.size() : 0);
//    }
//
//    public class PostViewHolder extends RecyclerView.ViewHolder {
//
//        TextView tv_name,tv_time,tv_status,tv_kind;
//
//
//        public PostViewHolder(@NonNull View itemView) {
//
//            super(itemView);
//            this.tv_name = itemView.findViewById(R.id.item_name);
//            this.tv_time = itemView.findViewById(R.id.item_time);
//            this.tv_status = itemView.findViewById(R.id.item_status);
//            this.tv_kind = itemView.findViewById(R.id.item_kind);
//        }
//    }
//}


//package com.example.capstone_design;
//
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.TextView;
//
//        import androidx.annotation.NonNull;
//        import androidx.recyclerview.widget.RecyclerView;
//
//        import java.util.List;
//
//public class PostAdapter extends  RecyclerView.Adapter<PostAdapter.PostViewHolder> {
//
//    private List<Post> datas;
//
//    public PostAdapter(List<Post> datas) {
//        this.datas = datas;
//    }
//
//    @NonNull
//    @Override
//    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
//        Post data = datas.get(position);
//        holder.name.setText(data.getName());
//        holder.time.setText(data.getTime());
//        holder.status.setText(data.getStatus());
//        holder.kind.setText(data.getKind());
//    }
//
//    @Override
//    public int getItemCount() {
//        return datas.size();
//    }
//
//    class PostViewHolder extends  RecyclerView.ViewHolder{
//
//        private TextView name;
//        private TextView time;
//        private TextView status;
//        private TextView kind;
//
//        public PostViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            name = itemView.findViewById(R.id.item_name);
//            time = itemView.findViewById(R.id.item_time);
//            status = itemView.findViewById(R.id.item_status);
//            kind = itemView.findViewById(R.id.item_kind);
//        }
//    }
//
//}