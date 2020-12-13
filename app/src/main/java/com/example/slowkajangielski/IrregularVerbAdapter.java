package com.example.slowkajangielski;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class IrregularVerbAdapter extends ArrayAdapter<IrregularVerb> {
    private Context context;
    private ArrayList<IrregularVerb> verbs;
    private ArrayList<String> answers;
    private TextView infinitiveVerb, pastTenseVerb, pastPartVerb;
    private EditText infinitiveEdit, pastTenseEdit, pastPartEdit;
    private int listState;
    private boolean test;

    public IrregularVerbAdapter(Context context, ArrayList<IrregularVerb> verbs){
        super(context, R.layout.verb_layout, verbs);

        this.context = context;
        this.verbs = verbs;

        this.setState(0);

        this.test = false;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.verb_layout, parent, false);

        infinitiveVerb = rowView.findViewById(R.id.infinitive);
        pastTenseVerb = rowView.findViewById(R.id.pastTense);
        pastPartVerb = rowView.findViewById(R.id.pastParticiple);

        infinitiveVerb.setText(verbs.get(position).getInfinitive());
        pastTenseVerb.setText(verbs.get(position).getPastTense());
        pastPartVerb.setText(verbs.get(position).getPastParticiple());

        if(this.test && this.listState != 0) {
            boolean goodAnswer = false;
            switch(this.listState) {
                case 1:
                    goodAnswer = verbs.get(position).getInfinitive().equals(this.answers.get(position));
                    break;
                case 2:
                    goodAnswer = verbs.get(position).getPastTense().equals(this.answers.get(position));
                    break;
                case 3:
                    goodAnswer = verbs.get(position).getPastParticiple().equals(this.answers.get(position));
                    break;
            }

            if(goodAnswer) {
                rowView.setBackgroundColor(Color.rgb(150, 255, 200));
            } else {
                rowView.setBackgroundColor(Color.rgb(255, 150, 150));
            }
        }

        infinitiveEdit = rowView.findViewById(R.id.infinitiveEdit);
        pastTenseEdit = rowView.findViewById(R.id.pastTenseEdit);
        pastPartEdit = rowView.findViewById(R.id.pastParticipleEdit);

        TextWatcher tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                answers.set(position, String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        infinitiveEdit.addTextChangedListener(tw);
        pastTenseEdit.addTextChangedListener(tw);
        pastPartEdit.addTextChangedListener(tw);

        infinitiveEdit.setText(answers.get(position));
        pastTenseEdit.setText(answers.get(position));
        pastPartEdit.setText(answers.get(position));

        switch (this.listState) {
            case 0:
                infinitiveVerb.setVisibility(View.VISIBLE);
                infinitiveEdit.setVisibility(View.GONE);

                pastTenseVerb.setVisibility(View.VISIBLE);
                pastTenseEdit.setVisibility(View.GONE);

                pastPartVerb.setVisibility(View.VISIBLE);
                pastPartEdit.setVisibility(View.GONE);
                break;
            case 1:
                infinitiveVerb.setVisibility(View.GONE);
                infinitiveEdit.setVisibility(View.VISIBLE);

                pastTenseVerb.setVisibility(View.VISIBLE);
                pastTenseEdit.setVisibility(View.GONE);

                pastPartVerb.setVisibility(View.VISIBLE);
                pastPartEdit.setVisibility(View.GONE);
                break;
            case 2:
                infinitiveVerb.setVisibility(View.VISIBLE);
                infinitiveEdit.setVisibility(View.GONE);

                pastTenseVerb.setVisibility(View.GONE);
                pastTenseEdit.setVisibility(View.VISIBLE);

                pastPartVerb.setVisibility(View.VISIBLE);
                pastPartEdit.setVisibility(View.GONE);
                break;
            case 3:
                infinitiveVerb.setVisibility(View.VISIBLE);
                infinitiveEdit.setVisibility(View.GONE);

                pastTenseVerb.setVisibility(View.VISIBLE);
                pastTenseEdit.setVisibility(View.GONE);

                pastPartVerb.setVisibility(View.GONE);
                pastPartEdit.setVisibility(View.VISIBLE);
                break;
        }

        return rowView;
    }

    public void setState(int number) {
        this.listState = number;

        this.answers = new ArrayList<String>();
        for(IrregularVerb v:verbs) {
            this.answers.add("");
        }

        this.checkAnswers(false);
    }

    public void checkAnswers(boolean check) {
        this.test = check;
        this.notifyDataSetChanged();
    }
}
