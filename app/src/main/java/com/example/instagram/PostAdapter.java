package com.example.instagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.parse.ParseFile;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    public static Context context;
    List<Post> postlist;

    public PostAdapter(Context context,List<Post> postlist) {
        this.context=context;
        this.postlist = postlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_post,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post=postlist.get(position);

        holder.bind(post);

    }

    @Override
    public int getItemCount() {
        return postlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView description;
        ImageView ivImagePost1;
        TextView moreOption;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName =itemView.findViewById(R.id.tvName);
            description =itemView.findViewById(R.id.description);
            ivImagePost1=itemView.findViewById(R.id.ivImagePost1);
            moreOption =itemView.findViewById(R.id.moreOption);
        }

        public void bind(Post post) {
            tvName.setText(post.getUser().getUsername());
            description.setText(post.getDescription());
            ParseFile image=post.getImage();


            if(image!=null) {
                Glide.with(context).
                        load(post.getImage().getUrl()).into(ivImagePost1);
            }




        }
    }
}