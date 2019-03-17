package com.francisdeh.ictnetapp;



import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by FrancisDeh on 10/29/2017.
 */

public class TermsFragment extends Fragment implements TermAdapter.termClickListener {

    RecyclerView recyclerView;
    List<Term> termList;
    TermAdapter termAdapter;
    onFragmentInteraction interaction;

    public TermsFragment(){

    }

     interface onFragmentInteraction{
        void onFragmentClick(int position);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeTermArray();

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.terms_fragment_layout, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.term_recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        DefaultItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setMoveDuration(2000);
        recyclerView.setItemAnimator(itemAnimator);

        termAdapter = new TermAdapter(termList, this);
        recyclerView.setAdapter(termAdapter);

        return rootView;
    }

    private void initializeTermArray() {
        termList =  DataSource.getTerms();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof onFragmentInteraction){
            interaction = (onFragmentInteraction)context;
        } else {
            throw new RuntimeException(context.toString() + " fragment must be implemented");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interaction = null;
    }

    @Override
    public void onTermClick(int positionOfTerm) {
        interaction.onFragmentClick(positionOfTerm);
    }
}
