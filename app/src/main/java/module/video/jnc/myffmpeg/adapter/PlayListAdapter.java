package module.video.jnc.myffmpeg.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import module.video.jnc.myffmpeg.R;

public class PlayListAdapter extends MyBaseAdapter<String, PlayListAdapter.MyViewHolder > {

    public PlayListAdapter(List<String> list, Context context) {
        super(list, context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup container, int type) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.player_list_layout_item , container , false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final String f = list.get(position);
        displayImageView(holder.img , "file://"+f);
        if(position == 0){
            holder.tv.setText("网络流rtmp");
        }
        else{
            holder.tv.setText(getFileName(f));
        }

        holder.rlRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lis != null){
                    lis.onItemClick(v , f , position);
                }
            }
        });
    }

    private String getFileName(String name){
        String[] strs = name.split("/");
        return strs[strs.length - 1];
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView img ;
        TextView tv;
        RelativeLayout rlRoot;
        public MyViewHolder(View itemView) {
            super(itemView);
            rlRoot = itemView.findViewById(R.id.rl_root);
            img = itemView.findViewById(R.id.img_logo);
            tv = itemView.findViewById(R.id.tv_name);
        }
    }
}
