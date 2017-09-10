package org.tutorials.hectorsdesign.udemymaterialdesign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.tutorials.hectorsdesign.udemymaterialdesign.R;
import org.tutorials.hectorsdesign.udemymaterialdesign.pojo.Information;

import java.util.Collections;
import java.util.List;

/**
 * Created by abelhectMACHOME on 8/20/16.
 * This is the adapter for the RecyclerView. It implements the view holder functions
 */
public class VivzAdapter extends RecyclerView.Adapter<VivzAdapter.MyViewHolder> {
    //arraylist for the information objects that will go on the recyclerView
    List<Information> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public VivzAdapter(Context context, List<Information> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

//    //    this is the method that removes the item from the recyclerView list
////    only until the app gets refreshed.  In order to make it permanent neet to connect
////    to database and update
//    public void delete(int position) {
//        data.remove(position);
//        notifyItemRemoved(position);
//    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row, parent, false);
//        Log.d("Hector's debug msg", "onCreateHolder called");
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        Log.d("Hector's debug msg", "onBindViewHolder called" + position);
        //Adding the data needed for the recyclerView list
        Information current = data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //This is the viewholder that goes in the extend above for the abstract class
//implements onClickListener in order to enable clickability of the item on the drawer list
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
            icon.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//    action of deleting an item from the recycle view
//            delete(getAdapterPosition());
        }
    }
}
