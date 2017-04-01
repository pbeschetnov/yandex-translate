package com.geomslayer.ytranslate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geomslayer.ytranslate.storage.Language;

import java.util.ArrayList;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.ViewHolder> {

    private OnItemClickListener listener;
    private ArrayList<Language> dataset;

    public ArrayList<Language> getDataset() {
        return dataset;
    }

    public void setDataset(ArrayList<Language> dataset) {
        this.dataset = dataset;
        notifyDataSetChanged();
    }

    public LanguageAdapter(@NonNull OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindLanguage(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset == null ? 0 : dataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView text;

        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            text = (TextView) itemView.findViewById(android.R.id.text1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getAdapterPosition());
                }
            });
        }

        public void bindLanguage(Language language) {
            text.setText(language.getName());
        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }

}