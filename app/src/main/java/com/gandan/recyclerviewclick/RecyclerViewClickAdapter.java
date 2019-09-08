package com.gandan.recyclerviewclick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewClickAdapter extends RecyclerView.Adapter<RecyclerViewClickAdapter.RecyclerViewClickHolder> {


    public interface ClickListener {
        void clicked(int position, int value);
    }

    ArrayList<DummyModel> list;
    ClickListener clickListener;

    public RecyclerViewClickAdapter(ArrayList<DummyModel> list, ClickListener clickListener){
        this.list = list;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerViewClickHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new RecyclerViewClickHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewClickHolder holder, final int position) {
        DummyModel model = list.get(position);
        holder.animalNameTxtView.setText(model.getName());
        holder.animalCountTxtView.setText(model.getCount()+"");
        final int countValue = model.getCount();

        holder.plusTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.clicked(position,countValue+1);
            }
        });
        holder.minusTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.clicked(position,countValue-1);
            }
        });
    }

    public void setList(ArrayList<DummyModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecyclerViewClickHolder extends RecyclerView.ViewHolder {

        TextView animalNameTxtView, plusTxtView, animalCountTxtView, minusTxtView;

        public RecyclerViewClickHolder(@NonNull View itemView) {
            super(itemView);

            animalNameTxtView = itemView.findViewById(R.id.animalNameTxtView);
            plusTxtView = itemView.findViewById(R.id.plusTxtView);
            animalCountTxtView = itemView.findViewById(R.id.animalCountTxtView);
            minusTxtView = itemView.findViewById(R.id.minusTxtView);
        }
    }
}
