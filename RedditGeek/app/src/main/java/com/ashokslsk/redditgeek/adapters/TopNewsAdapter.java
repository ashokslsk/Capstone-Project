package com.ashokslsk.redditgeek.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ashokslsk.redditgeek.R;
import com.ashokslsk.redditgeek.model.TopnewsResponse;

import java.util.List;

/**
 * Created by ashok.kumar on 19/10/16.
 */

public class TopNewsAdapter extends RecyclerView.Adapter<TopNewsAdapter.ViewHolder>  {

    List<TopnewsResponse.DataEntity.ChildrenEntity> mDataEntity;

    public TopNewsAdapter(List<TopnewsResponse.DataEntity.ChildrenEntity> mDataEntity) {
        this.mDataEntity = mDataEntity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_news_each_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.tv_name.setText(mDataEntity.get(position).getData().getTitle());

    }

    @Override
    public int getItemCount() {
      return mDataEntity.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_version,tv_api_level;
        public ViewHolder(View view) {
            super(view);
            tv_name = (TextView)view.findViewById(R.id.tv_name);
            tv_version = (TextView)view.findViewById(R.id.tv_version);
            tv_api_level = (TextView)view.findViewById(R.id.tv_api_level);

        }
    }
}
