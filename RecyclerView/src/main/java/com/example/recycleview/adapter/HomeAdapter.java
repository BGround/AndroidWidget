package com.example.recycleview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recycleview.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    private List<String> mList;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    public HomeAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mList = list;
    }

    public interface OnItemClickListener {
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void removeData(int position) {
        if(!mList.isEmpty()) {
            mList.remove(position);
            notifyItemRemoved(position);
//            notifyDataSetChanged();
        }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.itemView.setTag(position);
        holder.textView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item);
        }
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }
    @Override
    public boolean onLongClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemLongClick(view,(int)view.getTag());
        }
        return true;
    }
}
