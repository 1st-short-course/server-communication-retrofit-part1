package com.example.rany.retrofitsdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rany.retrofitsdemo.R;
import com.example.rany.retrofitsdemo.callback.OnMainCateItemClickListener;
import com.example.rany.retrofitsdemo.response.main_cate_rs.Maincates;

import java.util.ArrayList;
import java.util.List;

public class MainCateAdapter extends RecyclerView.Adapter<MainCateViewHolder>{

    private List<Maincates> maincateList;
    private OnMainCateItemClickListener listener;

    public void onClickListenet(OnMainCateItemClickListener listener){
        this.listener = listener;
    }

    public MainCateAdapter() {
        this.maincateList = new ArrayList<>();
    }

    public Maincates getMainCateById(int position){
        return maincateList.get(position);
    }

    public void getMainCates(List<Maincates> maincates){
        maincateList.addAll(maincates);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainCateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.main_cate_item, parent, false
        ) ;
        return new MainCateViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MainCateViewHolder holder, int position) {
        Maincates maincates = maincateList.get(position);
        holder.onBind(maincates);
    }

    @Override
    public int getItemCount() {
        return maincateList.size();
    }
}
