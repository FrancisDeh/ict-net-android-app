package com.francisdeh.ictnetapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by FrancisDeh on 10/31/2017.
 */

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {

   private List<Term> termList;
    private int previosPosition = 0;
    termClickListener listener;

    public TermAdapter(List<Term> terms, termClickListener termClickListener){
        termList = terms;
        this.listener = termClickListener;
    }

    public interface termClickListener{
        void onTermClick(int positionOfTerm);
    }
    @Override
    public TermViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.term_list_cards, parent, false);

        return new TermViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TermViewHolder holder, int position) {
        holder.titleTextView.setText(termList.get(position).getTerm());
        holder.definitionTextView.setText(termList.get(position).getDefinition());

        if(position > previosPosition){
            AnimationsCustomUtils.animate(holder,true);
        } else {
            AnimationsCustomUtils.animate(holder, false);
        }
        previosPosition = position;

    }

    @Override
    public int getItemCount() {
        return termList.size();
    }

    class TermViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView titleTextView, definitionTextView;
        LinearLayout linearLayout;

        public TermViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView)itemView.findViewById(R.id.term_list_title);
            definitionTextView  = (TextView)itemView.findViewById(R.id.term_list_definition);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.term_linear_layout);
            linearLayout.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            listener.onTermClick(getAdapterPosition());
        }
    }
}
