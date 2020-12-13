package com.example.slowkajangielski;

import android.content.Context;
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
    private TextView infinitiveVerb, pastTenseVerb, pastPartVerb;
    private EditText infinitiveEdit, pastTenseEdit, pastPartEdit;
    private int listState;

    public IrregularVerbAdapter(Context context, ArrayList<IrregularVerb> verbs){
        super(context, R.layout.verb_layout, verbs);

        this.context = context;
        this.verbs = verbs;
        this.listState = 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.verb_layout, parent, false);

//        rInfinitive.findViewById(R.id.radioInf);
//        rTense.findViewById(R.id.radioTense);
//        rParticiple.findViewById(R.id.radioPart);

        infinitiveVerb = rowView.findViewById(R.id.infinitive);
        pastTenseVerb = rowView.findViewById(R.id.pastTense);
        pastPartVerb = rowView.findViewById(R.id.pastParticiple);

        infinitiveEdit = rowView.findViewById(R.id.infinitiveEdit);
        pastTenseEdit = rowView.findViewById(R.id.pastTenseEdit);
        pastPartEdit = rowView.findViewById(R.id.pastParticipleEdit);

//        if(rInfinitive.isChecked()) {
//            infinitiveVerb.setVisibility(View.GONE);
//            pastTenseVerb.setText(verbs.get(position).getPastTense());
//            pastPartVerb.setText(verbs.get(position).getPastParticiple());
//        } else if(rTense.isChecked()) {
//            pastTenseVerb.setVisibility(View.GONE);
//            pastTenseEdit.setVisibility(View.VISIBLE);
//            infinitiveVerb.setText(verbs.get(position).getInfinitive());
//            pastPartVerb.setText(verbs.get(position).getPastParticiple());
//
//        } else if(rParticiple.isChecked()) {
//            pastPartVerb.setVisibility(View.GONE);
//            //pastPartVerb.setVisibility(View.VISIBLE);
//            infinitiveVerb.setText(verbs.get(position).getInfinitive());
//            pastTenseVerb.setText(verbs.get(position).getPastTense());
//        } else {
////            infinitiveVerb.setVisibility(View.VISIBLE);
////            pastTenseVerb.setVisibility(View.VISIBLE);
////            pastPartVerb.setVisibility(View.VISIBLE);
//        }

        infinitiveVerb.setText(verbs.get(position).getInfinitive());
        pastTenseVerb.setText(verbs.get(position).getPastTense());
        pastPartVerb.setText(verbs.get(position).getPastParticiple());
//        pastPartVerb.setText(String.valueOf(listState));

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
        this.notifyDataSetChanged();
        // infinitiveVerb.setText(verbs.get(position).getInfinitive());
        // pastPartVerb.setText(verbs.get(position).getPastParticiple());
    }
}
