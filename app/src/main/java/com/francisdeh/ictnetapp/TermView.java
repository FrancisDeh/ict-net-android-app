package com.francisdeh.ictnetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class TermView extends AppCompatActivity {
    Toolbar toolbar;
    TextView termTextView, definitionTextView;
    Button prevBtn, randBtn, nextBtn;
    List<Term>  termList = DataSource.getTerms();
    int termIndex;
    private static String TERM_NUMBER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_view);
        
        termTextView = (TextView)findViewById(R.id.term);
        definitionTextView = (TextView)findViewById(R.id.definition);
        prevBtn = (Button)findViewById(R.id.prev_btn);
        randBtn = (Button)findViewById(R.id.rand_btn);
        nextBtn = (Button)findViewById(R.id.next_btn);
        
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Networking Terms");
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if(savedInstanceState != null){
            termIndex = savedInstanceState.getInt(TERM_NUMBER, 0);
            setTermAndDefinition(termIndex);
        } else {
            //get intent information here
            if (getIntent().hasExtra(Classroom.TERM_INDEX)) {
                termIndex = getIntent().getIntExtra(Classroom.TERM_INDEX, 0);
                setTermAndDefinition(termIndex);
            }
        }
        
        //handle click events here
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePreviousTerm();

            }
        });

        randBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomTerm();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNextTerm();
            }
        });

    }

    private void setTermAndDefinition(int position) {
        if(!(position < 0) && (position != termList.size())) {
            Term term = termList.get(position);
            termTextView.setText(term.getTerm());
            definitionTextView.setText(term.getDefinition());
        }
        
    }

    private void generatePreviousTerm() {
        int newtermIndex = --termIndex;
        if(newtermIndex < 0){
            newtermIndex = termList.size() - 1;
            termIndex = termList.size() - 1;
        }

        setTermAndDefinition(newtermIndex);

    }

    private void generateRandomTerm() {
        int randomtermIndex = (int)(Math.random() * termList.size());
        termIndex = randomtermIndex;
        setTermAndDefinition(randomtermIndex);


    }

    private void generateNextTerm() {
        int newtermIndex = ++termIndex;
        if(newtermIndex == termList.size()){
            newtermIndex = 0;
            termIndex = 0;
        }

        setTermAndDefinition(newtermIndex);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TERM_NUMBER, termIndex);
    }
}
