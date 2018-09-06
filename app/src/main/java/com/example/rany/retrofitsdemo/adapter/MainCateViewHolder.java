package com.example.rany.retrofitsdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rany.retrofitsdemo.R;
import com.example.rany.retrofitsdemo.callback.OnMainCateItemClickListener;
import com.example.rany.retrofitsdemo.response.main_cate_rs.Maincates;
import com.squareup.picasso.Picasso;

public class MainCateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView icon;
    private TextView name, desc;
    private OnMainCateItemClickListener listener;

    public MainCateViewHolder(View itemView, OnMainCateItemClickListener listener) {
        super(itemView);
        icon = itemView.findViewById(R.id.imvIcon);
        name = itemView.findViewById(R.id.cateName);
        desc = itemView.findViewById(R.id.cateDesc);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }

    public void onBind(Maincates maincates){
        name.setText(maincates.getCateName());
        desc.setText(maincates.getDes());
        if(maincates.getIconName() != null && maincates.getIconName().contains("www")){
            Picasso.get()
                    .load(maincates.getIconName())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(icon);
        }
        else {
            Picasso.get()
                    .load("http://www.knongdai.com/"+maincates.getIconName())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(icon);
        }
//        Picasso.get()
//                    .load(maincates.getIconName())
//                    .placeholder(R.drawable.ic_launcher_foreground)
//                    .error(R.drawable.ic_launcher_foreground)
//                    .into(icon);
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(getAdapterPosition());
    }
}
