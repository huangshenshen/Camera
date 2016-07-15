package com.cninter.andorid5;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ${jacksen-hss} on 2016/7/14 0014.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.RecyclerViewHolder> implements View.OnClickListener{
    private Context context;
    private List<RecycleViewitem> list;

    public RecycleViewAdapter(Context context, List<RecycleViewitem> list) {
        this.context = context;
        this.list = list;
    }
    private OnRecycleViewItemClickListener listener;
    public void setItemClickListener(OnRecycleViewItemClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.OnItemClickListener(view,(int)view.getTag());
        }


    }


    interface  OnRecycleViewItemClickListener{
        void OnItemClickListener(View v ,int position);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_view_item,null);
        view.setOnClickListener(this);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);


        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        RecycleViewitem recycleViewitem = list.get(position);
        holder.imageView.setImageResource(recycleViewitem.getResid());
        holder.textView.setText(recycleViewitem.getMsg());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.recycle_view_item_iv);
            textView = (TextView) itemView.findViewById(R.id.recycle_view_item_tv);

        }
    }
}
