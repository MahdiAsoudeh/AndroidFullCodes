package com.mahdi20.fullcodes.retrofitExample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mahdi20.fullcodes.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {


    public interface OnItemClickListener {
        void onItemClick(View view, Person item, int position);
    }


    private final List<Person> items;
    private final OnItemClickListener listener;

    public PersonAdapter(List<Person> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_person, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(items.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView fname;
        private TextView lname;
        private TextView phone;

        ViewHolder(View itemView) {
            super(itemView);

            fname = itemView.findViewById(R.id.fname);
            lname = itemView.findViewById(R.id.lname);
            phone = itemView.findViewById(R.id.phone);

        }

        void bind(final Person item, final OnItemClickListener listener) {

            fname.setText(item.getFname());
            lname.setText(item.getLname());
            phone.setText(item.getPhone());

            itemView.setOnClickListener(v ->
                    listener.onItemClick(v, item, getLayoutPosition())
            );
        }
    }

}